package Assignment;

import java.util.ArrayList;
import java.util.List;

public class Node {
	double x,y;
	double BestValue;
	double SecondValue;
	int turns,turns2;
	int numOptimal,numOptimal2;
	ArrayList<String> BestPath;
	ArrayList<String> BestPath2;
	ArrayList<String> Optimal=new ArrayList<>();
	ArrayList<String> Optimal2=new ArrayList<>();


	public Node() {
		this.x=0;
		this.y=0;
		this.BestValue=0;
		this.SecondValue=Double.MAX_VALUE;
		this.BestPath=new ArrayList<>();
		this.BestPath2=new ArrayList<>();

	}

	public Node(double x,double y) {
		this.x=x;
		this.y=y;
		this.BestValue=0;
		this.SecondValue=0;
		this.BestPath=new ArrayList<>();
		this.BestPath2=new ArrayList<>();
	}

	public void printNumOfTurns(List<String> s,int x) {
		int level=Integer.MAX_VALUE;
		for (int i = 0; i < s.size(); i++) {
			String temp=s.get(i);
			if(ComfortLevel(temp)<=level) {
				level=ComfortLevel(temp);
			}
		}
		if(x==1) {
			this.turns=level;
		}
		else {
			this.turns2=level;
		}
	}

	public void getNumOfOptimalPaths(List<String> s,int x) {
		int level=0;
		int count=0;
		if(s.size()>0) {
			level=ComfortLevel(s.get(0));
			count=1;
		}
		else {
			if(x==1) {
				this.numOptimal=count;
				return;
			}
			else {
				this.numOptimal2=count;
				return;
			}
		}
		for (int i = 1; i < s.size(); i++) {
			String temp=s.get(i);
			if(ComfortLevel(temp)>level) {
				continue;
			}
			else if(ComfortLevel(temp)<level) {
				level=ComfortLevel(temp);
				count=1;
			}
			else {
				count++;
			}
		}
		if(x==1) {
			this.numOptimal=count;
		}
		else {
			this.numOptimal2=count;
		}
	}

	private int ComfortLevel(String temp) {
		int x=0;
		for (int i = 0; i < temp.length()-1; i++) {
			if(temp.charAt(i)!=temp.charAt(i+1)) {
				x++;
			}
		}
		return x;
	}

	public void OptimalList(Node n,int x) {
		if(x==1) {
			for (int i = 0; i < n.BestPath.size(); i++) {
				if(ComfortLevel(n.BestPath.get(i))==n.turns) {
					n.Optimal.add(n.BestPath.get(i));
				}
			}
			return;
		}
		else {
			for (int i = 0; i < n.BestPath2.size(); i++) {
				if(ComfortLevel(n.BestPath2.get(i))==n.turns2) {
					n.Optimal2.add(n.BestPath2.get(i));
				}
			}
			return;
		}
	}
}
