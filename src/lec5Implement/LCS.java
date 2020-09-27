package lec5Implement;

import java.util.Arrays;

public class LCS {

	public static int GreedyLCS(String s1,String s2) {
		int count=0;
		int index1=0;
		for (int index2 = 0; index1<s1.length()&&index2 < s2.length(); index2++) {
			if(s1.charAt(index1)==s2.charAt(index2)) {
				count++;
				index1++;
			}
		}
		return count;
	}

	public static String CompleteLCS(String s1,String s2) {
		String a1[]=binaryArr(s1.length());
		String a2[]=binaryArr(s2.length());
		for (int i = 0; i < a1.length; i++) {
			for(int j=0;j<a1[i].length();j++) {
				if(a1[i].charAt(j)=='1') {
					a1[i]+=s1.charAt(j);
				}
			}
			a1[i]=a1[i].substring(s1.length());
		}
		for (int i = 0; i < a2.length; i++) {
			for(int j=0;j<a2[i].length();j++) {
				if(a2[i].charAt(j)=='1') {
					a2[i]+=s2.charAt(j);
				}
			}
			a2[i]=a2[i].substring(s2.length());
		}
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		
		String ans="the common substrings are:";
		for(int i=0;i<a1.length;i++) {
			for(int j=0;j<a2.length;j++) {
				if(a1[i].equals(a2[j])) {	
					ans=ans+a1[i]+" ,";
				}
			}
		}
		return ans;
	}
	public static String[] binaryArr(int length) {
		int x=(int)Math.pow(2, length);
		String arr[]=new String[x];
		for (int i = 0; i < arr.length; i++) {//initial the array
			arr[i]="";
		}
		int l=length;
		while(l!=0) {
			arr[0]+="0";
			l--;
		}
		for (int i = 1; i < arr.length; i++) {
			arr[i]=plusOne(arr[i-1]);
		}
		return arr;


	}
	private static String plusOne(String s) { //0001
		String ans="";
		int count=0;
		int j=s.length()-1;
		for (j = s.length()-1; j >= 0; j--) {
			if(s.charAt(j)=='0') {
				ans+=s.substring(0,j)+"1";
				break;
			}
			else {
				count++;
			}
		}
		while(count>0) {
			ans+="0";
			count--;
		}
		return ans;
	}
	
	public static int LCS(String s1,String s2) {
		String arr[][]=new String[s1.length()+2][s2.length()+2];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]="";
			}
		}
		arr[1][0]+="s1";
		arr[0][1]+="s2";
		for(int i=2,t=0;i<arr.length;i++,t++) {
			arr[i][0]+=s1.charAt(t);
		}
		for(int i=2,t=0;i<arr[0].length;i++,t++) {
			arr[0][i]+=s2.charAt(t);
		}
		for(int i=2;i<arr.length;i++) {
			if(arr[i][0].equals(arr[0][2])) {
				arr[i][2]+="1";
			}
			else {
				arr[i][2]+="0";
			}
		}
		
		for(int i=3;i<arr[0].length;i++) {
			if(arr[0][i].equals(arr[2][0])) {
				arr[2][i]+="1";
			}
			else {
				arr[2][i]+="0";
			}
		}
		System.out.println(Arrays.deepToString(arr));
		
		for(int i=3;i<arr.length;i++) {
			for(int j=3;j<arr[i].length;j++) {
				if(arr[i][0].equals(arr[0][j])) {
					int a=Integer.parseInt(arr[i-1][j-1])+1;//(int)arr[i-1][j-1].charAt(0)-48;
					arr[i][j]+=a;
				}
				else {
					int a=Integer.parseInt(arr[i-1][j]);
					int b=Integer.parseInt(arr[i][j-1]);
					arr[i][j]+=Math.max(a, b);
				}
			}
		}
		int a=Integer.parseInt(arr[arr.length-1][arr[0].length-1]);
		
		
		//find the longest substrings
		
		String ans="";
		for(int i=arr.length-1,j=arr[0].length-1;i>1&&j>1;) {
			if(arr[i][0].equals(arr[0][j])) {
				ans+=arr[i][0];
				i=i-1;
				j=j-1;
			}
			else {
				int c=Integer.parseInt(arr[i-1][j]);
				int b=Integer.parseInt(arr[i][j-1]);
				if(b==c) {
					i=i-1;
				}
				else if(c>b){
					i=i-1;
				}
				else {
					j=j-1;
				}
			}
		}
		String ans1="";
		for(int i=ans.length()-1;i>=0;i--) {
			ans1+=ans.charAt(i);
		}
		System.out.println(ans1);
		return a;
	}

	public static void main(String[] args) {

		//System.out.println(CompleteLCS("abcjdcs", "dcswaab"));
		
		System.out.println(LCS("ronit","roni"));
	}

}
