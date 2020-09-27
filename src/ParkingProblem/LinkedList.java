package ParkingProblem;

public class LinkedList {
	public class Node {
		int data;
		Node next;
		
		public Node(int d) {
			this.data=d;
			this.next=null;
		}
		public int getData() {
			return this.data;
		}
		public void setData(int d) {
			this.data=d;
		}
	}
	Node head,tail;
	int size;
	
	public LinkedList() {
		head=tail=null;
		size=0;
	}
	public void add(int d) {
		if(head==null) {
			head=new Node(d);
			tail=head;
		}
		else {
			Node n=new Node(d);
			tail.next=n;
			tail=n;
		}
		size++;
	}
	public void finish() {
		if(size>10) {
			Node t=head;
			int num=(int)(Math.random()*size/2);
			for(int i=0;i<num;i++) {
				t=t.next;
			}
			tail.next=t;
		}
	}
}
