package TestsToExam;

public class NumbersGame {

	public static void main(String[] args) {
		int arr[]= {5,8,3,7,4,9,6,7};
		System.out.println(gameStrategy(arr));
	}
	public static int [][] buildMat(int arr[]){//O(n^2)
		int m[][]=new int[arr.length][arr.length];
		for (int i = 0; i < m.length; i++) {
			m[i][i]=arr[i];
		}
		for (int i = arr.length-2; i >= 0; i--) {
			for (int j = i+1; j < m.length; j++) {
				m[i][j]=Math.max(arr[i]-m[i+1][j], arr[j]-m[i][j-1]);
			}
		}
		return m;
	}

	public static String gameStrategy(int arr[]) {//O(n^2)
		int m[][]=buildMat(arr);//O(n^2)
		int i=0;
		int j=arr.length-1;
		String patha="A";
		String pathb="B";

		for (int k = 0; k < m.length/2; k++) {
			if(m[i][j]==arr[i]-m[i+1][j]) {
				patha+="->"+i;
				i++;
			}
			else {
				patha+="->"+j;
				j--;
			}
			if(m[i][j]==arr[i]-m[i+1][j]) {
				pathb+="->"+i;
				i++;
			}
			else {
				pathb+="->"+j;
				j--;
			}
		}
		return patha+"\n"+pathb;
	}
	
}
