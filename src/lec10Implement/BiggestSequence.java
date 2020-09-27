package lec10Implement;

public class BiggestSequence {

	/**
	 * greedy algorithm that pass over the array and count the biggest sequence of 1 in the array 
	 * in O(n) running time.
	 * @param arr - the array to check
	 * @return a string that contains the number of the biggest sequence and the sub array where we found it.
	 */
	public static String biggestSequenceArrayGreedy(int arr[]) {
		int max=0;
		int count=0;
		int index=-1;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==1) {
				count++;
			}
			else {
				if(count>max) {
					max=count;
					index=i-1;
				}
				count=0;
			}
		}
		if(index>=0) {
			return "the biggest sequence of 1 is "+max+" in subarray ["+(index-max+1)+","+index+"]";
		}
		else {
			return "there is no sequence of 1";
		}
	}
	/**
	 * dynamic argorithm to find the biggest sequence of 1 , with a side array that we use it,
	 * every iteration we check the value of each variable at 'arr' array and if is 1, we adding 1 to H[i]
	 * and thus we counting the biggest sequence.
	 * @param arr
	 * @return
	 */
	public static String DynamicAlgorithmBiggestSequence(int arr[]) {
		int H[]=new int[arr.length];
		H[0]=arr[0];
		int max;
		if(H[0]==1) {
			max=1;
		}
		else {
			max=0;
		}
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]==1) {
				H[i]=H[i-1]+1;
				if(max<H[i]) {
					max=H[i];
				}
			}
			else {
				H[i]=0;
			}
		}
		
		return "the biggest sequence of 1 is "+max;
	}

	public static void main(String[] args) {
		int a[]= {1,0,0,0,0,1,1,0,0,1,1,0};
		System.out.println(DynamicAlgorithmBiggestSequence(a));
	}
}
