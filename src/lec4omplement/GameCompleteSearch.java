package lec4omplement;

import java.util.Arrays;
import java.util.Scanner;

public class GameCompleteSearch {

	public static int parent(int i) {return (i-1)/2;}
	public static int leftChild(int i) {return i*2+1;}
	public static int rightChild(int i) {return i*2+2;}

	public static void initGame(int []a) {
		int size=(int) (Math.pow(2, a.length)-1);
		Node [] n=new Node[size];
		for (int i = 0; i < n.length; i++) {
			n[i]=new Node(0, "");

		}
		n[0].pos=""+"0"+(a.length-1);
		System.out.print(n[0].pos+" ,");
		int i=1;
		while (i<n.length) {//initial leaves position
			if(i==parent(i)*2+1) {
				char s=n[parent(i)].pos.charAt(n[parent(i)].pos.length()-1);
				int t=(int)s -48;
				t=t-1;
				n[i].pos=""+n[parent(i)].pos.charAt(0)+t;
				System.out.print(n[i].pos+" ,");

			}
			else {
				char s=n[parent(i)].pos.charAt(0);
				int t=(int)s -48;
				t=t+1;
				n[i].pos=""+t+n[parent(i)].pos.charAt(1);
				System.out.print(n[i].pos+" ,");
			}
			i++;
		}
		System.out.println("\n");
		for(int j=n.length/2;j<n.length;j++) {
			char s=n[j].pos.charAt(0);
			int t=(int)s -48;
			n[j].profit=a[t];
			System.out.print(n[j].profit+" ,");
		}
		System.out.println("<<<leaves profit");
		int k=(n.length/2)-1;
		while(k>=0) {
			char c=n[k].pos.charAt(0);//i
			char d=n[k].pos.charAt(1);//j
			int x=(int)c-48;//i
			int y=(int)d-48;//j
			//			int e=(int)c -48;
			//			e=(char)(e+1);//i+1;
			//			System.out.print("e:"+e+ ", ");
			//			int f=(int)d -48;
			//			f=(char)(f-1);//j-1
			//			System.out.print("f:"+f+ ", ");
			//			String temp1=""+e+d;//i+1,j
			//			String temp2=""+c+f;//i,j-1

			n[k].profit=Math.max(a[x]-n[rightChild(k)].profit, a[y]-n[leftChild(k)].profit);
			System.out.print(n[k].profit+" ,");
			k--;
		}
		System.out.print("<<<parents profit");
		int index=0;
		int left=0;
		int right=a.length-1;
		int usersum=0;
		int mysum=0;

		System.out.println("\n");
		System.out.println("the game start now!");
		System.out.println("its my turn");
		System.out.println("this is the array:" +Arrays.toString(a));
		if(n[leftChild(index)].profit<n[rightChild(index)].profit) {
			System.out.println("i choose right:");
			mysum+=a[right];
			right--;
			index=leftChild(index);
			System.out.println("my sum is:" +mysum);
		}
		else {
			System.out.println("i choose left:");
			mysum+=a[left];
			left++;
			index=rightChild(index);
			System.out.println("my sum is:" +mysum);
		}
		while(left<right) {
			System.out.print("this is the current array:[");
			for (int j = left; j < right+1; j++) {
				if(j<right) {
					System.out.print(a[j]+" ,");
				}
				else {
					System.out.print(a[j]);
				}
			}
			System.out.print("]");
			System.out.println("\n");
			System.out.println("its your turn");
			System.out.println("choose l/r:");
			Scanner choose=new Scanner(System.in);
			char side=choose.next().charAt(0);
			if(side=='l') {
				System.out.println("you choose left");
				usersum+=a[left];
				left++;
				index=rightChild(index);
				System.out.println("your sum is:"+usersum);
			}
			else if(side=='r') {
				System.out.println("you choose right");
				usersum+=a[right];
				right--;
				index=leftChild(index);
				System.out.println("your sum is:"+usersum);
			}

			System.out.print("this is the current array:[");
			for (int j = left; j < right+1; j++) {
				if(j<right) {
					System.out.print(a[j]+" ,");
				}
				else {
					System.out.print(a[j]);
				}			
			}
			System.out.print("]");
			System.out.println("\n");
			System.out.println("its my turn");
			if(index>=n.length/2) {//leaves
				if(n[leftChild(index)].profit>n[rightChild(index)].profit) {
					System.out.println("i choose left");
					mysum+=a[left];
					left++;
					index=rightChild(index);
					System.out.println("my sum is:"+mysum);
				}
				else {
					System.out.println("i choose right");
					mysum+=a[right];
					right--;
					index=leftChild(index);
					System.out.println("my sum is:"+mysum);

				}

			}
			else {
				if(n[leftChild(index)].profit<n[rightChild(index)].profit) {
					System.out.println("i choose right:");
					mysum+=a[right];
					right--;
					index=leftChild(index);
					System.out.println("my sum is:" +mysum);
				}
				else {
					System.out.println("i choose left:");
					mysum+=a[left];
					left++;
					index=rightChild(index);
					System.out.println("my sum is:" +mysum);
				}

			}
		}
		System.out.print("this is the current array:[");
		for (int j = left; j < right+1; j++) {
			System.out.print(a[j]);
		}
		System.out.print("]");
		System.out.println("\n");
		System.out.println("you're no have choice");
		System.out.println("you have to choose " +a[left]);
		usersum+=a[left];
		System.out.println("your sum is:"+usersum);
		System.out.println("i won with "+mysum+" , because your sum is "+usersum);


	}
	public static void main(String[] args) {

		int a[]= {7,5,9,6,8,6,5,5};
		for (int i = 0; i < a.length; i++) {
			a[i]=(int)((6*Math.random())+5);
		}
		initGame(a);
	}
}