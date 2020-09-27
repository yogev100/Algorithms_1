package TestsToExam;

import java.util.Stack;

public class Max1Max2 {

	public static void main(String[] args) {
		int a[]= {6,5,9,2,15,4,1,3,8,7,1};
		Max1Max2(a);
	}

	static class Node{
		int num;
		Stack<Integer> st=new Stack<>();
		
		public Node(int num) {
			this.num=num;
		}
	}
	
	public static void Max1Max2(int arr[]) {
		Node n[]=new Node[arr.length];
		for (int i = 0; i < arr.length; i++) {
			n[i]=new Node(arr[i]);
		}
		int index=Max1Max2Rec(n,0,n.length-1);
		int max1=n[index].num;
		int max2=Integer.MIN_VALUE;
		if(!n[index].st.isEmpty()) {
			max2=n[index].st.pop();
		}
		while(!n[index].st.isEmpty()) {
			int temp=n[index].st.pop();
			if(temp>max2) {
				max2=temp;
			}
		}
		System.out.println("max1:"+max1+" ,max2:"+max2);
	}
	
	private static int Max1Max2Rec(Node n[],int low,int high) {
		if(low<high) {
			int mid=(low+high)/2;
			int index;
			int i=Max1Max2Rec(n,low,mid);
			int j=Max1Max2Rec(n,mid+1,high);
			
			if(n[i].num>n[j].num) {
				n[i].st.push(n[j].num);
				index=i;
			}
			else {
				n[j].st.push(n[i].num);
				index=j;
			}
			return index;
		}
		return low;
	}
	
	public static void sumGame(int arr[]) throws InterruptedException {
		int oddSum=0;
		int evenSum=0;
		boolean myTurn=true;
		boolean even=false;
		for (int i = 0; i < arr.length; i++) {
			if(i%2==0) {
				evenSum+=arr[i];
			}
			else {
				oddSum+=arr[i];
			}
		}
		if(evenSum>oddSum) {
			even=true;
		}
		else {
			even=false;
		}
		int mySum=0;
		int userSum=0;
		int low=0;
		int high=arr.length-1;
		while(low<high) {
			if(myTurn) {
				if(even) {
					if(low%2==0) {
						System.out.println("i choose arr["+low+"]="+arr[low]);
						mySum+=arr[low];
						low++;
						System.out.println("my sum is:"+mySum);
						Thread.sleep(1000);
						
						int rand=(int)(Math.random()*2);
						if(rand==0) {
							userSum+=arr[low];
							low++;
							System.out.println("you choose arr["+low+"]="+arr[low]);
							System.out.println("your sum is:"+userSum);
						}
						else {
							userSum+=arr[high];
							high--;
							System.out.println("you choose arr["+high+"]="+arr[high]);
							System.out.println("your sum is:"+userSum);
						}
					}
					else {
						System.out.println("i choose arr["+high+"]="+arr[high]);
						mySum+=arr[high];
						high--;
						System.out.println("my sum is:"+mySum);
						
						Thread.sleep(1000);
						
						int rand=(int)(Math.random()*2);
						if(rand==0) {
							userSum+=arr[low];
							low++;
							System.out.println("you choose arr["+low+"]="+arr[low]);
							System.out.println("your sum is:"+userSum);
						}
						else {
							userSum+=arr[high];
							high--;
							System.out.println("you choose arr["+high+"]="+arr[high]);
							System.out.println("your sum is:"+userSum);
						}
					}
				}
			}
			else {
				
			}
		}
	}
}
