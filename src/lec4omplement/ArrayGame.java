package lec4omplement;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayGame {


	public static String sumGame(int number) {
		if(number%2!=0) {
			return "enter an even number";
		}
		else {
			int a[]=new int[number];
			for(int i=0;i<a.length;i++) {//initial a game
				a[i]=(int)(Math.random()*(2*a.length));
			}
			int oddsum=0;
			int evensum=0;
			for(int i=0,j=1;(i<a.length&&j<a.length);i+=2,j+=2) {
				evensum+=a[i];
				oddsum+=a[j];
			}
			System.out.println(evensum);
			System.out.println(oddsum);
			boolean even;
			if(evensum>oddsum) {
				even=true;
			}
			else {
				even=false;
			}
			int left=0;
			int right=a.length-1;
			int usersum=0;
			int mysum=0;
			System.out.println(Arrays.toString(a));
			//my turn
			if(even) {

				System.out.println("my turn");
				mysum+=a[left];
				left++;
				System.out.println("i choose left");
				System.out.print("[");
				for(int i=left;i<right+1;i++) {
					if(i<right) {
					System.out.print(a[i]+ " ,");
					}
					else {
						System.out.print(a[i]);
					}
				}
				System.out.print("]");
				System.out.println();
				System.out.println("my sum is:" +mysum);
			}
			else {
				System.out.println("my turn");
				mysum+=a[right];
				right--;
				System.out.println("i choose right");
				System.out.print("[");
				for(int i=left;i<right+1;i++) {
					if(i<right) {
					System.out.print(a[i]+ " ,");
					}
					else {
						System.out.print(a[i]);
					}
				}
				System.out.print("]");
				System.out.println("my sum is:" +mysum);
			}

			while(left<right) {
				//System.out.println(Arrays.toString(a));
				Scanner side=new Scanner(System.in);
				System.out.println("your turn");
				System.out.println("choose side-l/r?:");//user turn
				char ans=side.next().charAt(0);
				if(ans=='l') {
					usersum+=a[left];
					left++;
					System.out.println("you choose left");
					System.out.print("[");
					for(int i=left;i<right+1;i++) {
						if(i<right) {
						System.out.print(a[i]+ " ,");
						}
						else {
							System.out.print(a[i]);
						}
					}
					System.out.print("]");
					System.out.println();
					System.out.println("your sum is:" +usersum);

					//my turn

					System.out.println("my turn");
					int choose;
					if(even) {
						if(left%2==0) {
							choose=left;
						}
						else {
							choose=right;
						}
					}
					else {
						if(right%2==0) {
							choose=left;
						}
						else {
							choose=right;
						}
					}
					if(choose==left) {
						mysum+=a[left];
						left++;
						System.out.println("i choose left");
						System.out.print("[");
						for(int i=left;i<right+1;i++) {
							if(i<right) {
							System.out.print(a[i]+ " ,");
							}
							else {
								System.out.print(a[i]);
							}
						}
						System.out.print("]");
						System.out.println();
						System.out.println("my sum is:" +mysum);
					}
					else {
						mysum+=a[right];
						right--;
						System.out.println("i choose right");
						System.out.print("[");
						for(int i=left;i<right+1;i++) {
							if(i<right) {
							System.out.print(a[i]+ " ,");
							}
							else {
								System.out.print(a[i]);
							}
						}
						System.out.print("]");
						System.out.println();
						System.out.println("my sum is:" +mysum);
					}
				}
				//ans=r
				else {
					usersum+=a[right];
					right--;
					System.out.println("you choose right");
					System.out.print("[");
					for(int i=left;i<right+1;i++) {
						if(i<right) {
						System.out.print(a[i]+ " ,");
						}
						else {
							System.out.print(a[i]);
						}
					}
					System.out.print("]");
					System.out.println();
					System.out.println("your sum is:" +usersum);

					//my turn

					System.out.println("my turn");
					int choose;
					if(even) {
						if(left%2==0) {
							choose=left;
						}
						else {
							choose=right;
						}
					}
					else {
						if(right%2==0) {
							choose=left;
						}
						else {
							choose=right;
						}
					}
					if(choose==left) {
						mysum+=a[left];
						left++;
						System.out.println("i choose left");
						System.out.print("[");
						for(int i=left;i<right+1;i++) {
							if(i<right) {
							System.out.print(a[i]+ " ,");
							}
							else {
								System.out.print(a[i]);
							}
						}
						System.out.print("]");
						System.out.println();
						System.out.println("my sum is:" +mysum);
					}
					else {
						mysum+=a[right];
						right--;
						System.out.println("i choose right");
						System.out.print("[");
						for(int i=left;i<right+1;i++) {
							if(i<right) {
							System.out.print(a[i]+ " ,");
							}
							else {
								System.out.print(a[i]);
							}
						}
						System.out.print("]");
						System.out.println();
						System.out.println("my sum is:" +mysum);
					}
				}
			}
			System.out.println("you no have a choice");
			usersum+=a[0];
			System.out.println("your sum is:" +usersum);
			System.out.println("my sum is:"+mysum);
			System.out.println("i win!!!");
		}

		return "end";

	}


	public static void main(String[] args) {
		sumGame(8);

	}

}
