package lec4omplement;

import java.util.Arrays;

public class median {
	
	/*
	 * a function that find the median of 2 sorted arrays in n compares.
	 */
	public static double median2arrays(int a[],int b[]) {//n compares at this function - running time: o(n)
		int c[]=new int[a.length];
		int i,j,k;
		int t=0;
		for(i=a.length-1,j=b.length-1,k=0;k<a.length;k++) {
			if(a[i]>b[j]) {
				c[t++]=a[i--];
			}
			else {
				c[t++]=b[j--];
			}
		}
		if(a[i]>b[j]) {
			return (c[c.length-1]+a[i])/2.0;
		}
		else {
			return (c[c.length-1]+b[j])/2.0;
		}
	}
	/*
	 * a function that find half numbers that biggest then the median of 2 sorted arrays within n compares.
	 */
	
	public static int[] halfNumAbove(int a[],int b[]) {
		int c[]=new int[a.length];
		int index=0;
		for(int k=0,i=0,j=b.length-1;k<a.length;k++) {
			if(a[i]>b[j]) {
				
				c[index++]=a[i++];
				j--;
			}
			else {
				c[index++]=b[j--];
				i++;
			}
		}
		return c;
	}
	/*
	 * a function that find number that biggest then the median in a big array,
	 * the chance to wrong is 1/2^64 - so we take on own self this.
	 */
	public static int aboveMedian(int a[]) {
		int height=64;
		int max=a[0];
		for(int i=1;i<height;i++) {
			if(a[i]>max) {
				max=a[i];
			}
		}
		return max;
	}









	public static void main(String[] args) {
		int a[]= {1,3,7,9};
		int b[]= {5,8,10,12};
		System.out.println(median2arrays(a,b));
		System.out.println(Arrays.toString(halfNumAbove(a, b)));
		int c[]=new int[1000];
		for(int i=0;i<c.length;i++) {
			c[i]=(int)(Math.random()*10000);
		}
		System.out.println("median in c:" +aboveMedian(c));
		System.out.println("array c:" + Arrays.toString(c));
	}

}
