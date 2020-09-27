package lec7Implement;

import java.util.Arrays;

public class AirPlanProblem {


	public static Node[][] initialMtrx(int num) {
		Node [][]m=new Node[num+1][num+1];
		for (int i = 0; i <m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j]=new Node();
				m[i][j].up=(int)(Math.random()*10+1);
				m[i][j].right=(int)(Math.random()*10+1);
			}
		}
		return m;

	}

	public static String allDetailsPath(Node [][]m) {
		m[m.length-1][0].value=0;
		m[m.length-1][0].pathNum=1;
		m[m.length-1][0].path="start";
		for (int i = 1; i < m.length; i++) {//initial last row
			m[m.length-1][i].value=m[m.length-1][i-1].right+m[m.length-1][i-1].value;
			for (int j = 0; j < i; j++) {
				m[m.length-1][i].path+='r';
			}
			m[m.length-1][i].pathNum++;
		}
		System.out.println(Arrays.deepToString(m));

		for (int i = m.length-2; i >=0; i--) {//initial first column
			m[i][0].value=m[i+1][0].up+m[i+1][0].value;
			for (int j = m.length-1; j > i; j--) {
				m[i][0].path+='u';

			}
			m[i][0].pathNum++;

		}
		System.out.println(Arrays.deepToString(m));

		for (int i = m.length-2; i >=0; i--) {
			for (int j = 1; j < m.length; j++) {
				int tmp1=m[i+1][j].up+m[i+1][j].value;
				int tmp2=m[i][j-1].right+m[i][j-1].value;
				m[i][j].value=Math.min(tmp1, tmp2);

				if(tmp1<tmp2) {
					if(m[i+1][j].path.contains(",")) {
						m[i][j].path=morePath(m[i+1][j].path, 'u');
					}
					else {
						m[i][j].path=m[i+1][j].path+'u';
					}
					m[i][j].pathNum=m[i+1][j].pathNum;

				}
				else if(tmp2<tmp1) {
					if(m[i][j-1].path.contains(",")) {
						m[i][j].path=morePath(m[i][j-1].path, 'r');
					}
					else {
						m[i][j].path=m[i][j-1].path+'r';
					}
					m[i][j].pathNum=m[i][j-1].pathNum;

				}
				else {
					boolean con1=false;
					boolean con2=false;
					if(m[i][j-1].path.contains(",")) {
						m[i][j].path=morePath(m[i][j-1].path,'r');
						con1=true;
					}
					else {
						m[i][j].path+=m[i][j-1].path+'r';
					}
					if(m[i+1][j].path.contains(",")) {
						con2=true;
						if(con1) {
							String t=morePath(m[i+1][j].path,'u');
							m[i][j].path+=","+t;
						}
						else{
							m[i][j].path+=","+morePath(m[i+1][j].path,'u');
						}

					}
					else {
						if(con1) {
							m[i][j].path+=","+m[i+1][j].path+'u';
						}
						else {
							m[i][j].path+=","+m[i+1][j].path+'u';
						}
					}
					if(!con1&&!con2) {
						m[i][j].path=m[i][j-1].path+"r,"+m[i+1][j].path+'u';
					}
					m[i][j].pathNum=m[i][j-1].pathNum+m[i+1][j].pathNum;

				}
			}

		}
		System.out.println(Arrays.deepToString(m));
		return "weight:"+m[0][m.length-1].value+" ,"+m[0][m.length-1].pathNum+" path:"+m[0][m.length-1].path;
	}

	public static String anotherPath(String temp) {
		String ans="";
		for (int k = 0; temp.contains(","); k++) {
			int t=temp.indexOf(',');
			if(t!=-1) {
				ans+=temp.substring(0,t)+'r'+","+temp.substring(0,t)+"u,";
				temp=temp.substring(t+1);
			}
		}
		ans+=temp+'r'+","+temp+'u';
		return ans;
	}

	public static String morePath(String temp,char side) {
		String ans="";
		for (int k = 0; temp.contains(","); k++) {
			int t=temp.indexOf(',');
			if(side=='r'&&t!=-1) {
				ans+=temp.substring(0,t)+'r'+",";
				temp=temp.substring(t+1);
			}
			else {
				if(t!=-1) {
					ans+=temp.substring(0,t)+'u'+",";
					temp=temp.substring(t+1);
				}
			}
		}
		if(side=='r') {
			ans+=temp+'r';
		}
		else {
			ans+=temp+'u';
		}

		return ans;
	}

	public static void main(String[] args) {
		//Node [][]m=initialMtrx(2);
		Node [][]m=new Node[4][4];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j]=new Node();
			}
		}
		m[0][0].right=2;


		m[1][0].right=100;
		m[1][0].up=100;


		m[2][0].right=5;
		m[2][0].up=100;

		m[3][0].right=1;
		m[3][0].up=3;

		m[0][1].right=100;
		m[0][2].right=2;


		m[1][1].right=3;
		m[1][1].up=100;

		m[1][2].right=8;
		m[1][2].up=10;

		m[1][3].up=1;

		m[2][1].right=2;
		m[2][1].up=1;
		m[2][2].right=100;
		m[2][2].up=2;

		m[2][3].up=4;

		m[3][1].right=5;
		m[3][1].up=7;

		m[3][2].right=7;
		m[3][2].up=100;

		m[3][3].up=3;



		System.out.println(allDetailsPath(m));

	}

}
