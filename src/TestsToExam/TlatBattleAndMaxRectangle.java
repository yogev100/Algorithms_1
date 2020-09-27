package TestsToExam;



public class TlatBattleAndMaxRectangle {

	public static int TlatBattle(boolean p[]) {
		int num=(int)(Math.random()*3);
		if(num==0) {
			p[1]=false;

			int x=(int)(Math.random()*10);
			if(x<5) {
				p[0]=false;
				return 2;
			}
			else {
				return 0;
			}
		}
		else if(num==1) {
			int x=(int)(Math.random()*10);
			if(x<8) {
				p[0]=false;

				int y=(int)(Math.random()*10);
				int z=10;
				while(y>=5&&z>=8) {
					z=(int)(Math.random()*10);
					if(z<8) {
						return 1;
					}
					else {
						y=(int)(Math.random()*10);
					}
				}
				return 2;
			}
			else {
				p[1]=false;
				int t=(int)(Math.random()*10);
				if(t<5) {
					return 2;
				}
				else {
					return 0;
				}
			}
		}
		else {
			int y=(int)(Math.random()*2);
			if(y==0) {
				p[1]=false;
				int z=(int)(Math.random()*10);
				if(z<5) {
					return 2;
				}
				else {
					return 0;
				}
			}
			else {
				int t=(int)(Math.random()*10);
				if(t<8) {
					p[0]=false;

					int e=(int)(Math.random()*10);
					int z=10;
					while(e>=5&&z>=8) {
						z=(int)(Math.random()*10);
						if(z<8) {
							return 1;
						}
						else {
							e=(int)(Math.random()*10);
						}
					}
					return 2;

				}
				else {
					p[1]=false;
					int n=(int)(Math.random()*10);
					if(n<5) {
						return 2;
					}
					else {
						return 0;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		boolean p[]=new boolean[3];
		p[0]=true;
		p[1]=true;
		p[2]=true;

		int A=0;
		int B=0;
		int C=0;
		int err=0;
		for (int i = 0; i < 1000000; i++) {
			int res=TlatBattle(p);
			if(res==0) {
				A++;
			}
			else if(res==1) {
				B++;
			}
			else if(res==2) {
				C++;
			}
			else {
				System.out.println(res);
				err++;
			}
		}
		//System.out.println("A:"+A+" ,B:"+B+" ,C:"+C+" ,err:"+err);

		int m[][]= {{1,1,1,1,1},
					{1,1,1,0,1},
					{1,1,1,1,1},
					{1,1,1,0,0},
					{1,1,0,1,0}};
		System.out.println(maxRectangle(m));
		
		
	}



	public static int maxRectangle(int a[][]) {
		int size=0;
		int help[]=new int[a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if(a[i][j]==1) {
					help[j]=help[j]+1;
				}
				else {
					help[j]=0;
				}
			}
			int area=maxArea(help);
			if(area>size) {
				size=area;
			}
		}
		return size;
	}

	private static int maxArea(int help[]) {
		int size=0;
		int min;
		for (int i = 0; i < help.length; i++) {
			if(help[i]!=0) {
				min=help[i];
				if(size<help[i]) {
					size=help[i];
				}
				for (int j = i+1; j < help.length; j++) {
					if(help[j]!=0) {
						if(min>help[j]) {
							min=help[j];
						}
						if(size<min*(j-i+1)) {
							size=min*(j-i+1);
						}
					}
					else {
						break;
					}
				}
			}
		}
		return size;
	}
}
