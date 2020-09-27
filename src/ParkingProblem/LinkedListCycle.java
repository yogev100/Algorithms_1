package ParkingProblem;

public class LinkedListCycle {
	class Node {
		private char data;
		private Node next,prev;
		
		public Node(char d,Node n,Node p) {
			this.data=d;
			this.next=n;
			this.prev=p;
		}
		public String toString() {
			return ""+this.data;
		}
		public void SetData(char c) {
			this.data=c;
		}
		public char getData() {
			return this.data;
		}
		public Node getNext() {
			return this.next;
		}
		public Node getPrev() {
			return this.prev;
		}
	}
	private Node head,tail;
	private int size;
	/**
	 * default constructor
	 */
	public LinkedListCycle() {
		head=tail=null;
		size=0;
	}
	public void add(char c) {
		if(head==null) {
			head=new Node(c,null,null);
			tail=head;
			head.next=head.prev=tail;
		}
		else {
			Node n=new Node(c,head,tail);
			tail.next=n;
			tail=n;
			head.prev=tail;
		}
		size++;
	}
	public Node getHead() {
		return this.head;
	}
	public Node getNext(Node n) {
		return n.next;
	}
	public String toString() {
		String t="";
		if(head==null) return t;
		else {
			t=t+head.getData() +" ,";
			for(Node n=head.getNext();n!=head;n=n.next) {
				t=t+n.data +" ,";
			}
			t=t.substring(0,t.length()-1);
		}
		return t;
	}
}//end LinkedListCycle

	

