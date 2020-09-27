package Assignment;

import java.util.ArrayList;

public class BestPath {

	Node arr[][];
	int teta;
	int runningTime=0;

	public BestPath(Node mat[][],int teta){
		this.arr=mat;
		this.teta=teta;
		computeAllDetails();
	}

	/**
	 * Side function that add the best path from the correct node 
	 * @param arr - the path we added to it
	 * @param temp - the paths to add to 'arr' with 0/1 addition
	 * @param c- the current move - 0/1
	 */
	private void addList(ArrayList<String> arr,ArrayList<String> temp,String c) {
		if(temp.size()==0) {
			arr.add(c);
		}
		for (int i = 0; i < temp.size(); i++) {
			arr.add(temp.get(i)+c);
		}
	}

	/**
	 * Side function that add 2 paths to the correct node's path.
	 * @param arr - the path we added to it
	 * @param temp0 - the first path to add with 0 addition
	 * @param temp1 - the second path to add with 1 addition
	 */
	private void add2List(ArrayList<String> arr,ArrayList<String> temp0,ArrayList<String> temp1) {
		for (int i = 0; i < temp0.size(); i++) {
			arr.add(temp0.get(i)+'0');
		}
		for (int i = 0; i < temp1.size(); i++) {
			arr.add(temp1.get(i)+'1');
		}
	}

	/**
	 * Main function that compute all the details we need to resolve the assignment,
	 * compare the cheapest path/second cheapest path each iteration with each node,
	 * build a best path/best path2 for each node.
	 * for the last node - we have in Node class Side void functions that sets the turns of the optimal path
	 * and the number of optimal paths.
	 */
	public void computeAllDetails() {
		int col=arr[0].length;
		int row=arr.length;
		//initial last row//
		for (int i = 1; i < col; i++) {
			arr[row-1][i].BestValue=arr[row-1][i-1].x+arr[row-1][i-1].BestValue;
			addList(arr[row-1][i].BestPath,arr[row-1][i-1].BestPath,"0");
			runningTime++;
		}

		//initial first column//
		for (int i = row-2; i>=0; i--) {
			arr[i][0].BestValue=arr[i+1][0].y+arr[i+1][0].BestValue;
			addList(arr[i][0].BestPath,arr[i+1][0].BestPath,"1");
			runningTime++;
		}

		for (int i = row-2; i >=0 ; i--) {
			for (int j = 1; j < arr.length; j++) {

				//set fields for the best path//
				double tmp1=arr[i+1][j].y+arr[i+1][j].BestValue;
				double tmp2=arr[i][j-1].x+arr[i][j-1].BestValue;
				arr[i][j].BestValue=Math.min(tmp1, tmp2);

				if(tmp1<tmp2) {
					addList(arr[i][j].BestPath,arr[i+1][j].BestPath,"1");

					//set fields for the second best path//
					if(arr[i+1][j].BestPath2.size()==0) {
						arr[i][j].SecondValue=tmp2;
						addList(arr[i][j].BestPath2,arr[i][j-1].BestPath,"0");
						runningTime++;
					}
					else {
						double tmp3=arr[i+1][j].y+arr[i+1][j].SecondValue;
						if(tmp2<tmp3) {
							arr[i][j].SecondValue=tmp2;
							addList(arr[i][j].BestPath2,arr[i][j-1].BestPath,"0");
							runningTime++;
						}
						else if(tmp3<tmp2) {
							arr[i][j].SecondValue=tmp3;
							addList(arr[i][j].BestPath2,arr[i+1][j].BestPath2,"1");
							runningTime++;
						}
						else {
							arr[i][j].SecondValue=tmp2;
							add2List(arr[i][j].BestPath2,arr[i][j-1].BestPath,arr[i+1][j].BestPath2);
							runningTime++;
						}
					}

					//check if this is the last node//
					if(i==0&&j==arr[0].length-1) {
						arr[i][j].printNumOfTurns(arr[i][j].BestPath,1);
						arr[i][j].getNumOfOptimalPaths(arr[i][j].BestPath,1);
						arr[i][j].printNumOfTurns(arr[i][j].BestPath2,2);
						arr[i][j].getNumOfOptimalPaths(arr[i][j].BestPath2,2);

					}
				}
				else if(tmp2<tmp1) {
					addList(arr[i][j].BestPath,arr[i][j-1].BestPath,"0");

					//set fields for the second best path//
					if(arr[i][j-1].BestPath2.size()==0) {
						arr[i][j].SecondValue=tmp1;
						addList(arr[i][j].BestPath2,arr[i+1][j].BestPath,"1");
						runningTime++;
					}
					else {
						double tmp3=arr[i][j-1].x+arr[i][j-1].SecondValue;
						if(tmp1<tmp3) {
							arr[i][j].SecondValue=tmp1;
							addList(arr[i][j].BestPath2,arr[i+1][j].BestPath,"1");
							runningTime++;
						}
						else if(tmp3<tmp1) {
							arr[i][j].SecondValue=tmp3;
							addList(arr[i][j].BestPath2,arr[i][j-1].BestPath2,"0");
							runningTime++;
						}
						else {
							arr[i][j].SecondValue=tmp1;
							add2List(arr[i][j].BestPath2,arr[i][j-1].BestPath2,arr[i+1][j].BestPath);
							runningTime++;
						}
					}
					//check if this is the last node//
					if(i==0&&j==arr[0].length-1) {
						arr[i][j].printNumOfTurns(arr[i][j].BestPath,1);
						arr[i][j].getNumOfOptimalPaths(arr[i][j].BestPath,1);
						arr[i][j].printNumOfTurns(arr[i][j].BestPath2,2);
						arr[i][j].getNumOfOptimalPaths(arr[i][j].BestPath2,2);

					}
				}
				else {
					add2List(arr[i][j].BestPath,arr[i][j-1].BestPath,arr[i+1][j].BestPath);

					if((i!=0&&j!=arr[0].length-1)&&(arr[i+1][j].BestPath2.size()==0&&arr[i][j-1].BestPath2.size()==0)) {
						arr[i][j].SecondValue=Double.MAX_VALUE;
						runningTime++;
						continue;
					}

					double t1=arr[i+1][j].SecondValue+arr[i+1][j].y;
					double t2=arr[i][j-1].SecondValue+arr[i][j-1].x;
					if(t1<t2) {
						arr[i][j].SecondValue=t1;
						addList(arr[i][j].BestPath2,arr[i+1][j].BestPath2,"1");
					}
					else if(t2<t1) {
						arr[i][j].SecondValue=t2;
						addList(arr[i][j].BestPath2,arr[i][j-1].BestPath2,"0");
					}
					else {
						arr[i][j].SecondValue=t1;
						add2List(arr[i][j].BestPath2,arr[i][j-1].BestPath2,arr[i+1][j].BestPath2);
					}

					//check if this is the last node//
					if(i==0&&j==arr[0].length-1) {
						arr[i][j].printNumOfTurns(arr[i][j].BestPath,1);
						arr[i][j].getNumOfOptimalPaths(arr[i][j].BestPath,1);
						arr[i][j].printNumOfTurns(arr[i][j].BestPath2,2);
						arr[i][j].getNumOfOptimalPaths(arr[i][j].BestPath2,2);

					}
				}	
			}
		}	
	}


	public int getNumOfCheapestPaths() {
		if(arr.length>0) {
			if(arr.length==1&&arr[0].length==1) {
				return 1;
			}
			else {
				return this.arr[0][arr[0].length-1].BestPath.size();
			}
		}
		return -1;
	}

	public int getNumOfCheapestPaths2() {
		if(arr.length>0) {
			if(arr.length==1&&arr[0].length==1) {
				return 1;
			}
			else {
				return this.arr[0][arr[0].length-1].BestPath2.size();
			}
		}
		return -1;
	}

	public int getNumOfOptimalPaths() {
		if(arr.length>0) {
			if(arr.length==1&&arr[0].length==1) {
				return 1;
			}
			else {
				return arr[0][arr[0].length-1].numOptimal;
			}
		}
		return -1;
	}

	public int getNumOfOptimalPaths2() {
		if(arr.length>0) {
			if(arr.length==1&&arr[0].length==1) {
				return 1;
			}
			else {
				return arr[0][arr[0].length-1].numOptimal2;
			}
		}
		return -1;
	}

	public double getCheapestPrice() {
		if(arr.length>0) {
			if(arr.length==1&&arr[0].length==1) {
				return 0;
			}
			else {
				return this.arr[0][arr[0].length-1].BestValue;
			}
		}
		return -1;
	}

	public double getCheapestPrice2() {
		if(arr.length>0) {
			if(arr.length==1&&arr[0].length==1) {
				return 0;
			}
			else {
				return this.arr[0][arr[0].length-1].SecondValue;
			}
		}
		return -1;
	}

	public int printNumOfTurns() {
		if(arr.length>0) {
			if(arr.length==1&&arr[0].length==1) {
				return 0;
			}
			else {
				return this.arr[0][arr[0].length-1].turns;
			}
		}
		return -1;
	}

	public int printNumOfTurns2() {
		if(arr.length>0) {
			if(arr.length==1&&arr[0].length==1) {
				return 0;
			}
			else {
				return this.arr[0][arr[0].length-1].turns2;
			}
		}
		return -1;
	}

	public ArrayList<String> getAllCheapestPaths(){
		if(arr.length>0) {
			if(this.teta>=this.arr[0][arr[0].length-1].BestPath.size()) {
				return this.arr[0][arr[0].length-1].BestPath;
			}
			else {
				ArrayList<String> temp=new ArrayList<>();
				for (int i = 0; i <this.teta; i++) {
					temp.add(this.arr[0][arr[0].length-1].BestPath.get(i));
				}
				return temp;
			}
		}
		return null;
	}

	public ArrayList<String> getAllCheapestPaths2(){
		if(arr.length>0) {
			if(this.teta>=this.arr[0][arr[0].length-1].BestPath2.size()) {
				return this.arr[0][arr[0].length-1].BestPath2;
			}
			else {
				ArrayList<String> temp=new ArrayList<>();
				for (int i = 0; i <this.teta; i++) {
					temp.add(this.arr[0][arr[0].length-1].BestPath2.get(i));
				}
				return temp;
			}
		}
		return null;
	}

	public ArrayList<String> getAllOptimalPaths(){
		arr[0][arr[0].length-1].OptimalList(arr[0][arr[0].length-1], 1);
		return this.arr[0][arr[0].length-1].Optimal;
	}

	public ArrayList<String> getAllOptimalPaths2(){
		arr[0][arr[0].length-1].OptimalList(arr[0][arr[0].length-1], 2);
		return this.arr[0][arr[0].length-1].Optimal2;
	}

}
