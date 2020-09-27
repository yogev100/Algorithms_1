package lec3Implement;

public class Max1Max2 {/*max1max2 function that execute in running time of n+log(n) 
						by Node class with number and stack attributes.*/

	public static void main(String[] args) {
		int arr[]= {15,3,7,13,9,5,6,10};
		System.out.println(max1_max2(arr));

	}
	public static int max1_max2(Node a[],int low,int high) {
		if(low<high) {
			int mid=(low+high)/2;
			int i=max1_max2(a,low,mid);
			int j=max1_max2(a,mid+1,high);
			if(a[i].num>a[j].num) {
				a[i].st.push(a[j].num);
				return i;
			}
			else {
				a[j].st.push(a[i].num);
				return j;
			}
		}
		return low;
	}
	public static String max1_max2(int a[]) {
		int n=a.length;
		Node []nodes=new Node[n];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i]=new Node(a[i]);
		}
		int index=max1_max2(nodes,0,a.length-1);
		int max1=nodes[index].num;
		int max2=nodes[index].st.pop();
		while(!nodes[index].st.isEmpty()) {
			int temp=nodes[index].st.pop();
			if(temp>max2) {
				max2=temp;
			}
		}
		return "max1:"+max1 + "\n" + "max2:" +max2;

	}
	
}

