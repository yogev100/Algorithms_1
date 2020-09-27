package ParkingProblem;

import ParkingProblem.LinkedList.Node;

/*
 * This class represents a loop search problem in an linked list with handle.
 * This class shows methods for calculating arm length, circle length and value within the circle.
 * The correctness of the methods is with the help of a simple formula that we calculated that if there
 * is a circular linked list and 2 people walking at some speed, they will inevitably 
 * meet at some point within the circle.
 * We marked one speed by a rabbit - its speed is double that the other one - two steps(2i).
 * We marked one speed by a turtle - its speed is regular - one step (i).
 * The circle length marked by n, the handle by n, the meeting point by k,
 * the number of rounds the rabbit did by q, and the number of rounds the turtle did by p.
 * So - after simple calculating we get that k=n(q – 2p) – m.
 * That is - a meeting point is m - n at the beginning of the circle. 
 */
public class RabbitTurtleProb {

	public static void main(String[] args) {		
		LinkedList ls=new LinkedList();
		for(int i=1;i<21;i++) {
			ls.add(i*10);
		}
		ls.finish();
		
		Node r=ls.head.next.next;
		Node t=ls.head.next;
		while(r!=t) {
			r=r.next.next;
			t=t.next;
		}
		///question 1-print a value that for sure inside the cycle///
		System.out.println("the value inside the cycle is:" + t.data);
		
		r=ls.head;
		while(r!=t) {
			r=r.next;
			t=t.next;
		}
		///question 2-print the start of the cycle///
		System.out.println("the start value of the cycle is:" + r.data);
		
		r=ls.head;
		int handleLength=0;
		while(r!=t) {
			r=r.next;
			handleLength++;
		}
		///question 3-print the handle length///
		System.out.println("the handle length is:" + handleLength);
		
		r=r.next;
		int CycleLength=0;
		while(r!=t) {
			r=r.next;
			CycleLength++;
		}
		///question 4- print the length cycle///
		System.out.println("the cycle length is:" + CycleLength);
		
	}

}
