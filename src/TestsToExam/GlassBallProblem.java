package TestsToExam;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class GlassBallProblem {

	public static void main(String[] args) {
		
		int arr[]=new int[101];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=(i+1)*2;
		}
		
		TwoBallsWithTriangleNumbers(101, arr);
		System.out.println(numberOfChecking2(110));
	
	}
	public static int TwoBallsWithTriangleNumbers(int a,int arr[]) {//in O(MAth.sqrt(2n))
		int num=0;//numbers of parts to divide the build
		int numFloor=arr.length;
		int time=0;
		String path="";
		while(numFloor>num*(num+1)/2) {//sum of sereal 
			num++;
		}
		int jump=num;
		int step=num;
		path+="->"+step;

		while(arr[step]<a) {//while the ball dont broken in this floor
			jump--;
			step=step+jump;//add lower step by 1.
			path+="->"+step;
			time++;
		}
		System.out.println("the first ball broken in floor:"+step);
		int from=step-jump;
		while(arr[from]<a) {
			from++;
			path+="->"+from;
			time++;
		}
		System.out.println("the second ball broken in floor:"+from);
		System.out.println("running time:"+time);
		System.out.println(path);
		return from;
	}
	
	/**
	 * function that compute the minimal number of throws with 2 ball to get the floor the ball will broken.
	 * @param n - number of floors
	 * @return the minimal checks.
	 */
	public static int numberOfChecking2(int n) {//O(n^2)
		int f[]=new int[n+1];
		f[0]=0; f[1]=1 ;f[2]=2;
		
		for (int i = 3; i < f.length; i++) {
			int min=n;
			for (int j = 1; j < i; j++) {
				int x=Math.max(j, f[i-j]+1);
				if(x<min) {
					min=x;
				}
			}
			f[i]=min;
		}
		return f[n];
	}
	
	public static int numberOfCheckingK(int n,int k) {
		int f[][]=new int [k+1][n+1];
		for (int i = 0; i <= n; i++) {
			f[0][i]=0;
			f[1][i]=i;
		}
		
		for (int i = 2; i <=k; i++) {//balls
			f[i][0]=0;
			f[i][1]=1;
			if(n>=2) {
				f[i][2]=2;
			}
			for (int j = 2; j <=n; j++) {//floors
				int min=n;
				for (int p = 1; p < j; p++) {//which floor to throw the ball
					int x=Math.max(f[i-1][p-1]+1, f[i][j-p])+1;
					min=Math.min(x,min);
				}
				f[i][j]=min;
			}
		}
		return f[k][n];
	}
}
