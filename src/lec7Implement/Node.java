package lec7Implement;


public class Node{
	int up;
	int right;
	int value;
	String path;
	int pathNum;
	
	public Node() {
		up=right=pathNum=0;
		path="";
	}
	public String toString() {
		return "up:"+up+"right:"+right+"value:"+value+"path:"+path;
	}
}
