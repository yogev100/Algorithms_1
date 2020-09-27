package lec9Implement;

public class FibonachiProblem {
	
	/**
	 * functino that compute the n index in fibonachi in O(logn) running time.
	 * @param n - the n index number in fibonachi numbers.
	 */
	
	public static int Fibonachi(int n) {
		int ans[][]={{1,1},
			    {1,0}};
		return MatrixPower(ans,n);
		
	}
	public static int [][] multiplyMatrix(int a[][],int b[][]){
		int c[][]= new int[2][2];
		c[0][0]=a[0][0]*b[0][0]+a[0][1]*b[1][0];
		c[0][1]=a[0][0]*b[0][1]+a[0][1]*b[1][1];
		c[1][0]=a[1][0]*b[0][0]+a[1][1]*b[1][0];
		c[1][1]=a[1][0]*b[0][1]+a[1][1]*b[1][1];
		return c;
	}
	
	public static int MatrixPower(int a[][],int n) {
		int ans[][]={{1,1},
			    {1,0}};
		while(n>0) {
			if(n%2==1) {
				ans=multiplyMatrix(ans, a);
			}
			a=multiplyMatrix(a, a);
			n=n/2;
		}
		return ans[0][0];
	}
	
	public static void main(String[] args) {
		System.out.println(Fibonachi(3));
	}

}
