package lec9Implement;

public class PowerProblem {
	
	/**
	 * 
	 * @param x - base
	 * @param n - power
	 * @return x^n in running time of O(logn)
	 */
	
	public static int Power(int x,int n) {
		int ans=1;
		while(n>0) {
			if(n%2==1) {
				ans=ans*x;
			}
			x=x*x;
			n=n/2;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(Power(3,4));
	}

}
