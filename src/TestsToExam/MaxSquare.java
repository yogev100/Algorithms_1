package TestsToExam;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class MaxSquare {

	public static void main(String[] args) {
//		int arr[][]= {{1,1,1,1,1},{1,0,1,1,1},{0,1,1,1,1},{1,1,1,1,0}};
//		maxSquare(arr,2);
//		int[][] mat = {
//				{1,0,1,0,0},
//				{0,0,1,0,1},
//				{0,0,0,0,0},
//				{0,0,0,1,1},
//				{1,1,0,1,1}};
//		System.out.println(numOfRectangles(mat));
//		
//		int a[]= {3,3,4,2,4,4,2,4};
//		System.out.println(majority(a));
		int arr[]= {5,1,4,7,10,8,2,3};
		System.out.println(subIncDec(arr));
	}
	
	public static int majority(int arr[]) {
		HashMap<Integer,Integer> hm=new HashMap();
		if(arr.length==0)return Integer.MAX_VALUE;
		hm.put(arr[0], 1);
		int count=1;
		int ans=arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(hm.containsKey(arr[i])) {
				int x=hm.get(arr[i]);
				hm.replace(arr[i], x+1);
				if(hm.get(arr[i])>count) {
					count=hm.get(arr[i]);
					ans=arr[i];
				}
			}
			else {
				hm.put(arr[i], 1);
			}
		}
		if(count>arr.length/2) {
			return ans;
		}
		else return Integer.MAX_VALUE;
	}
	
	public static void maxSquare(int arr[][],int k) {
		int count=0,countk=0,indexi=-1,indexj=-1,max=0;
		int m[][]=new int[arr.length][arr[0].length];
		for (int i = 0; i < m.length; i++) {
			m[i][0]=arr[i][0];
			if(arr[i][0]==k) {
				max=k;
				countk++;
				indexi=i;
				indexj=0;
			}
		}
		for (int i = 0; i < m[0].length; i++) {
			m[0][i]=arr[0][i];
			if(arr[0][i]==k) {
				max=k;
				countk++;
				indexi=0;
				indexj=i;
			}
		}
		
		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m[0].length; j++) {
				if(arr[i][j]==1) {
					m[i][j]=Math.min(m[i-1][j-1], Math.min(m[i][j-1], m[i-1][j]))+1;
					if(m[i][j]>=k) {
						countk++;
					}
					if(m[i][j]>max) {
						max=m[i][j];
						indexi=i;
						indexj=j;
						
					}
				}
			}
		}
		System.out.println("max square:"+max+"x"+max);
		System.out.println("amount of k squares:"+countk);
		System.out.println("max square indexes:"+(indexi-max+1)+","+(indexj-max+1));
	}
	public static int numOfRectangles(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(mat[i][j] == 1) {
					if((i == 0 || mat[i-1][j] == 0) && (j == 0 || mat[i][j-1] == 0)) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static int subIncDec(int arr[]) {
		int r[]=new int[arr.length];
		for (int i = 0; i < r.length; i++) {
			r[r.length-1-i]=arr[i];
		}
		int lis[]=LIS(arr);
		int lds[]=LIS(r);
		int max=lds[0];
		for (int i = 0; i < lds.length; i++) {
			if(i<lis.length-1) {
				int temp=lis[i]+lds[i+1];
				if(temp>max) {
					max=temp;
				}
			}
			else {
				int t=lis[i];
				if(t>max) {
					max=t;
				}
			}
		}
		return max;
	}
	
	private static int[] LIS(int arr[]) {
		int help[]=new int[arr.length];
		help[0]=1;
		int temp[]=new int[arr.length];
		temp[0]=arr[0];
		int k=1;
		for (int i = 1; i < help.length; i++) {
			int index=binarySearchBet(temp,arr[i],k);
			if(k==index) {
				k++;
			}
			help[i]=k;
			temp[index]=arr[i];//{5,1,4,7,10,8,2,3}
		}
		return help;
	}
	
	private static int binarySearchBet(int help[],int a,int high) {
		if(a<help[0]) {
			return 0;
		}
		if(a>help[high-1]) {
			return high;
		}
		int start=0;
		while(start<=high) {
			if(start==high) {
				return start;
			}
			int mid=(start+high)/2;
			if(help[mid]==a) {
				return mid;
			}
			else if(help[mid]<a) {
				start=mid+1;
			}
			else {
				high=mid;
			}
		}
		return -1;
	}
}
