package TestsToExam;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MoodleTests {
	
	public static int LengthsubK(int arr[],int k) {
		int max=0;
		for (int i = 0; i < arr.length; i++) {
			int count=0;
			int p=i;
			for (int j = p+1; j < arr.length; j++) {
				if(Math.abs(arr[p]-arr[j])==k) {
					count++;
					p=j;
				}
			}
			if(count>max) {
				max=count;
			}
		}
		return max+1;//length of sub array that each 2 tight elements the subtruct is k
	}

	
	public static String diffSeq(String x) {
		String max="";
		String ans="";
		Queue<Character> q=new LinkedList<Character>(); 
		for (int i = 0; i < x.length(); i++) {
			char c=x.charAt(i);
			if(ans.contains(""+c)) {
				while(!q.isEmpty()&&q.peek()!=c) {
					q.poll();
					ans=ans.substring(1);
				}
				if(!q.isEmpty()) {
					q.poll();
					ans=ans.substring(1);
				}
			}
			ans+=c;
			q.add(c);
			if(ans.length()>max.length()) {
				max=ans;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int a[]= {5,1,-1,3,5,4,2,0};
		System.out.println(LengthsubK(a, 2));
		System.out.println(diffSeq("aabcbadexf"));
		System.out.println(LSC("abcabb","ababc"));
	}
	
	public static String LSC(String x,String y) {
		int m[][]=new int[x.length()+1][y.length()+1];
		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m[0].length; j++) {
				if(x.charAt(i-1)==y.charAt(j-1)) {
					m[i][j]=m[i-1][j-1]+1;
				}
				else {
					m[i][j]=Math.max(m[i-1][j], m[i][j-1]);
				}
			}
		}
		String ans="";
		int i=m.length-1,j=m[0].length-1;
		while(i>0&&j>0) {
			if(x.charAt(i-1)==y.charAt(j-1)) {
				ans=x.charAt(i-1)+ans;
				i--;
				j--;
			}
			else {
				if(m[i-1][j]==m[i][j]) {
					i--;
				}
				else {
					j--;
				}
			}
		}
		return ans;
	}
}
		