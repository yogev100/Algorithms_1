package lec6Implement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TimeQueueProblem {

//	private static double QueueAvg(int[] arr) {
//		double avgTime=0;
//		int sum = 0;
//		for(int i=0;i<arr.length;i++) {//for sum the waiting time of all the costumers
//			for(int j=0;j<=i;j++) {
//				sum+=arr[j];
//			}
//		}
//		avgTime=sum/arr.length;
//		
//		return avgTime;	
//	}
//	
//	private static int[] checkQueue(int []arr,double avg,int start,int end) {
//		if(start!=end) {
//			
//		}
//	}
//	
//	private static int[] CostumerQueueOrder(int arr[]){
//		return checkQueue(arr,QueueAvg(arr),0,arr.length-1);
//	}
//	
	
	public static void 
	permutations(Set<Integer> items, Stack<Integer> permutation, int size) {

	    /* permutation stack has become equal to size that we require */
	    if(permutation.size() == size) {
	        /* print the permutation */
	        System.out.println(Arrays.toString(permutation.toArray(new Integer[0])));
	    }

	    /* items available for permutation */
	    Integer[] availableItems = items.toArray(new Integer[0]);
	  //  System.out.println(Arrays.toString(availableItems));
	    for(Integer i : availableItems) {
	        /* add current item */
	        permutation.push(i);

	        /* remove item from available item set */
	        items.remove(i);

	        /* pass it on for next permutation */
	        permutations(items, permutation, size);

	        /* pop and put the removed item back */
	        items.add(permutation.pop());
	    }
	}
	
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int []costumersTime= {4,2,6,3,1};
//		
//		CostumerQueueOrder(costumersTime);
//	}
	public static void main(String[] args) {
	    // TODO Auto-generated method stub


	    Set<Integer> s = new HashSet<Integer>();
	    s.add(1);
	    s.add(2);
	    s.add(3);
	  //  s.add(4);
	    Integer[] availableItems = s.toArray(new Integer[0]);
	   // System.out.println(Arrays.toString(availableItems));
	    permutations(s, new Stack<Integer>(), s.size());
	}

}
