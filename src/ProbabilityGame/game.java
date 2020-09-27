package ProbabilityGame;

import java.util.Scanner;
/**
 * this class represents probability game between the programmer to the user.
 * Monty Hall's game.
 * The program presents to the player three doors. Behind one door is a valuable prize - a car -
 * and behind both doors.
 * The others - goats, of course, the player prefers the car,
 * but he does not know which door hides it, and has to choose
 * at random. If he chooses the right door, he will win a prize; Otherwise, he will receive nothing.
 * After the player points to one of the doors, the moderator, who knows the correct door, opens one of the other two doors,
 * And reveals a goat behind her. Now let the player decide whether to stay with his original choice,
 * or change the decision And prefer the last remaining door closed.
 * @author Yogev
 *
 */
public class game {
	public static String ShowCar(int ind,int a[]) {
		for (int i = 0; i < a.length; i++) {
			a[i]=0;
		}
		int car=(int)(Math.random()*a.length);
		a[car]=1;
		int ran=(int)(Math.random()*a.length);

	    for (int i = 0; i < a.length; i++) {
	    	if(car==ind) {
	    		while(ran==car) {
	    			ran=(int)(Math.random()*a.length);
	    		}
	    		if(i!=car&&i!=ran) {
	    			a[i]=-1;
	    		}
	    		a[ran]=0;
	    	}
			if(i!=car&&i!=ind) {
				a[i]=-1;//open the doors except the car door and his choice.
			}
		}
	    Scanner x=new Scanner(System.in);
	    System.out.println("do you want to change your choice ?");
	    String choice=x.nextLine();
	    if(choice=="yes") {
	    	if(ind==car) {
	    		return "you got the cow";
	    	}
	    	else {
	    		return "your car is ready";
	    	}
	    }
	    else {
	    	if(ind==car) {
	    		return "your car is ready";
	    	}
	    	else {
	    		return "you got the cow";

	    	}
	    }
	}
	public static String carPick(int s,int arr) {
		int car=(int)(Math.random()*arr);
		int lie=car;
		Scanner scn= new Scanner(System.in);
		System.out.println("s "+s);
		System.out.println("car "+car);
		if(s==car) {
			while(lie==s||lie==car) {
				lie=(int)Math.random()*arr;
			}
		}
		System.out.println("lie "+lie);
		if(car==s) System.out.println("You want to replace your choice to: "+lie+" door?");
		else System.out.println("You want to replace your choice to: "+car+" door?");
		if(scn.nextInt()==1) {
			if(car==s)s=lie;
			else s=car;
		}
		if(s==car) return "You won the car!!!";
		else return "You faild!!!";
	}
	public static void main(String[] args) {
		int a[]= {4,3,2,5,5,5,5,5,5,5,5,5,5,5,5};

		for (int i = 0; i < a.length; i++) {
			System.out.println(i+")"+carPick(1,20));

		}
	}
}
