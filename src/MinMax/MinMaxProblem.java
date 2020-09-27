package MinMax;

import java.util.Arrays;
import java.util.Scanner;
/*
 * This class represents different methods for calculating the minimum and maximum element
 * in an array of numbers.
 * In this class we analyze each method by calculating the running time and the number of comparisons performed.
 */


public class MinMaxProblem {
	/*
	 * Side function thats find the minimum element in an array in O(n) running time with n-1 comparisons. 
	 */
	public static int min(int a[]) {
		int Min=Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++) {
			if(a[i]<Min) Min=a[i];
		}
		return Min;
	}
	/*
	 * Side function thats find the maximum element in an array in O(n) running time with n-1 comparisons.
	 */
	public static int max(int a[]) {
		int Max=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++) {
			if(a[i]>Max) Max=a[i];
		}
		return Max;
	}
	///Method 1///
	/*
	 * A function that is aided by the side functions to compute the min and max elements
	 * in the array in running time of O(n) and 2n-2 comparisons.
	 */
	public static int[] min_max1(int a[]) {
		int Min=min(a);//O(n) - n-1 comparisons.
		int Max=max(a);//O(n) - n-1 comparisons.
		
		int b[]= {Min,Max};
		return b;
	}
	///Method 2///
	/*
	 * A function that compute the min and max elements in array by using 2 variables  that necessary for compare.
	 * Running time of O(n) with 2n-2 comparisons.
	 */
	public static int[] min_max2(int a[]) {
		int x=0;
		int Min = a[0],Max=a[0];
		for (int i = 1; i < a.length; i++) {
			if(Min>a[i]) Min=a[i];
			else if(Max<a[i]) Max=a[i];//the 2 conditions togheter - O(n) - 2n-2 comparisons.
			x++;
		}
		int b[]= {Min,Max};
		System.out.println(x);
		return b;
	}
	///Method 3///
	/*
	 * Let's move on to an array in pairs.
	 * Compared with two adjacent elements a[i] and a[i+1] the larger one is the maximum candidate
	 * and the smaller one is Minimum candidate.
	 * Running time of O(n) with 1.5n comparisons.
	 */
	public static int[] optimalMin_Max(int a[]) {
		int x=0;
		int Min,Max=0;
		if(a.length>=2&&a[0]<a[1]) { 
			Min=a[0];
			Max=a[1];
		}
		else {
			Min=a[1];
			Max=a[0];
		}
		for (int i = 0; i < a.length-1; i=i+2) {
			if(a[i]<a[i+1]) {//the 2 outer conditions togheter :(n-1)/2 comparisons
				if(a[i]<Min) {//the 2 inner conditions togheter : n-2 comparisons.
					Min=a[i];
				}
				if(a[i+1]>Max) {
					Max=a[i+1];
				}
			}
			else {
				if(a[i+1]<Min) {
					Min=a[i+1];
				}
				if(a[i]>Max) {
					Max=a[i];
				}
			}
			x++;
		}
		if(a.length%2!=0) {//if the size of the array are odd.
			if(a[a.length-1]<Min) {
				Min=a[a.length-1];
			}
			if(a[a.length-1]>Max) {
				Max=a[a.length-1];
			}
		}
		System.out.println(x);
		int b[]= {Min,Max};
		return b;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a[]= {4,7,2,8,4,45,23,76,43,89};
//		System.out.println(min(a));
//		System.out.println(max(a));
//		System.out.println(Arrays.toString(min_max1(a)));
//		System.out.println(Arrays.toString(min_max2(a)));
//		System.out.println(Arrays.toString(optimalMin_Max(a)));

		
	}

}
