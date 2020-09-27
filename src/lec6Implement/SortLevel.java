package lec6Implement;

import java.util.Arrays;

public class SortLevel {

	public static int sortlevel(int arr1[]) {
		int mtrxI[][]=new int[arr1.length+1][arr1.length+1];
		int mtrxD[][]=new int[arr1.length+1][arr1.length+1];


		System.out.println(Arrays.toString(arr1));

		//sort array in increase order
		int arrI[]=new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			arrI[i]=arr1[i];
		}
		Arrays.sort(arrI);
		System.out.println(Arrays.toString(arrI));


		//sort array in decrease order
		int arrD[]=new int[arr1.length];
		for (int i = arrD.length-1,j=0; i >=0&&j<arrD.length; i--,j++) {
			arrD[i]=arrI[j];
		}
		System.out.println(Arrays.toString(arrD));


		int a1=0;
		int a2=0;

		//compute the sort level of the arrI
		for (int i = 1; i < mtrxI.length; i++) {
			for(int j=1;j<mtrxI[0].length;j++) {
				if(arr1[a1]==arrI[a2]) {
					mtrxI[i][j]=mtrxI[i-1][j-1]+1;
				}
				else {
					mtrxI[i][j]=Math.max(mtrxI[i-1][j], mtrxI[i][j-1]);
				}
				a1++;
				if(a1==arr1.length) {
					a2++;
					a1=0;
				}
			}
		}
		System.out.println(Arrays.deepToString(mtrxI));

		//compute the sort level of the arrD
		a1=0;
		a2=0;
		for (int i = 1; i < mtrxD.length; i++) {
			for(int j=1;j<mtrxD[0].length;j++) {
				if(arr1[a1]==arrD[a2]) {
					mtrxD[i][j]=mtrxD[i-1][j-1]+1;
				}
				else {
					mtrxD[i][j]=Math.max(mtrxD[i-1][j], mtrxD[i][j-1]);
				}
				a1++;
				if(a1==arr1.length) {
					a2++;
					a1=0;
				}
			}
		}

		System.out.println(Arrays.deepToString(mtrxD));


		int increase=mtrxI[mtrxI.length-1][mtrxI.length-1];
		int decrease=mtrxD[mtrxD.length-1][mtrxD.length-1];

		return Math.max(increase, decrease);

	}


	public static int improveGready(int []arr) {
		int m[][]=new int[arr.length][arr.length];
		m[0][0]=arr[0];
		int j=0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]>m[j][j]) {
				copy(m,arr[i],j+1);//mtrx,value,copy to witch line
				j++;
			}
			else {
				if(j==0) {
					m[j][j]=arr[i];
				}
				else {
					int k=j-1;
					while(k>=0) {
						if(m[k][k]<arr[i]) {
							for (int k2 = 0; k2 < m.length; k2++) {
								copy(m,m[k][k2],k+1);
							}
							m[k+1][k+1]=arr[i];
							break;
						}
						else {
							k--;
						}
					}
				}
			}
		}
		int row=0;
		while (row<m.length&&m[row][0]!=0) {
			row++;
		}
		row=row-1;
		
		int count=0;
		for (int i = 0; i<m.length&&m[row][i]!=0; i++) {
			count++;
		}
		System.out.println(Arrays.deepToString(m));
		return count;
	}

	private static void copy(int m[][],int value,int line) {
		if(line<m.length) {
			int i=0;
			for (i = 0; (m[line-1][i]!=0)&&(i<m.length); i++) {
				m[line][i]=m[line-1][i];
			}
			if(i<m.length) {
				m[line][i]=value;
			}
		}
	}
	public static void main(String[] args) {
		int arr[]= {8,4,12,2,3,10,14};

		System.out.println(improveGready(arr));
	}

}
