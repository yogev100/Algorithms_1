package ParkingProblem;

/*
This class presents a parking problem.
There is a researcher who comes to a circular parking lot and aims to count the amount of parking there.
The length of the circle is unknown to the researcher.
The parking lot is large and the investigator sees only the car next to it and the next car.
The researcher can mark the car with any mark, but the marker can already appear on several cars.
The researcher can also delete the previous mark and write a new one.
Data structure to solve the problem: a two-way circular linked list.
 */
public class CalcCarLinkedList {
	LinkedListCycle cars;
	final int nLetters=23, size=13;
	final char v='v',w='w';//
	
	/**
	 * build parking
	 */
	public CalcCarLinkedList() {
		cars=new LinkedListCycle();
		for(int i=0;i<size;i++) {
			char c=(char)('a'+ (int)(Math.random()*nLetters));
			cars.add(c);
		}
		
		System.out.println(cars.toString());
	}
	
	/**
	 * The algorithm that solve the problem.
	 * Steps:
	 * 1) First car marks V.
	 * 2) Follow the circle until we find the V sign and count the number of cars we passed.
	 * 3) We reached the V mark, erasing it and writing W in its place.
	 * 4) Go back to the start point for a few steps we counted.
			If you see the W-we closed a circle.
			If you see V, go ahead with the same number of steps we repeated and go back to step 2
	 * @return the numbers of cars with V mark.
	 */
	public int calcCars() {
		cars.getHead().SetData(v);
		System.out.println(cars.getHead().getData());
		System.out.println(cars.toString());
		LinkedListCycle.Node n=cars.getHead().getNext();
		boolean flag=true;
		int counter=1;
		int num=0;
		while(flag) {
			if(n.getData()==v) {
				int i=counter;
				n.SetData(w);
				num++;
				while(i>0) {
					n=n.getPrev();
					i--;
				}
				if(n.getData()==w) {
					flag=false;
				}
				else {
					n=cars.getHead().getNext();
					counter=1;
				}
			}
			else {
				n=n.getNext();
				counter++;
			}
		}
		return num;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalcCarLinkedList car=new CalcCarLinkedList();
		System.out.println("numbers of cars :" + car.calcCars());
	}
}
