package lec10Implement;

public class BiggestSquare {

	public static String biggestSquareGreedy(int arr[][]) {
		int max=0;
		int count=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j]==1) {
					//max=1;
					boolean square=true;
					for (int k = 0; k < arr.length&&square==true; k++) {//sub matrix k*k
						for (int t=i,r=j; (t<arr.length&&r<arr[i].length)&&(t<=k&&r<=k);r++ ) {
							if(arr[t][r]!=1) {
								square=false;
								break;
							}
							else {
								if(t==k&&r==k) {
									count=(k+1)*(k+1);
									if(count>max) {
										max=count;
										break;
									}
								}
							}
							if(r==k) {
								r=j;
								t++;
							}
						}
					}
				}
				else {
					continue;
				}
			}
		}
		int sqrt=(int) Math.sqrt(max);
		return "the max square of 1 is: "+sqrt+"x"+sqrt+"="+max;
	}
	
	public static String biggestSquareDynamic(int arr[][]) {
		int M[][]=new int[arr.length][arr[0].length];
		int max=0;
		for (int i = 0; i < M.length; i++) {//initial first row
			M[0][i]=arr[0][i];
		}
		for (int i = 0; i < M.length; i++) {//initial first column
			M[i][0]=arr[i][0];
		}
		for (int i = 1; i < M.length; i++) {
			for (int j = 1; j < M.length; j++) {
				if(arr[i][j]==1) {
					M[i][j]=Math.min(M[i-1][j],Math.min( M[i][j-1], M[i-1][j-1]))+1;
					if(M[i][j]>max) {
						max=M[i][j];
					}
				}
				else {
					M[i][j]=0;
				}
			}
		}
		return "the biggest square is:"+max+"x"+max+"="+max*max;
	}
	
	public static void main(String[] args) {
		int arr[][]= {{0,0,1,0,0},
					  {1,1,1,1,1},
					  {0,1,1,1,1},
					  {1,1,1,1,1},
					  {1,1,1,0,1}};
		System.out.println(biggestSquareDynamic(arr));
		}
	}

