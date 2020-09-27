package lec8Implement;

public class ThirdBattle {

	public static char winner(char arr[]) {
		int start=(int)(Math.random()*3);
		boolean a=true;
		boolean b=true;
		boolean c=true;
		int aTurn=-1;
		int bTurn=-1;
		int cTurn=-1;
		if(start==0) {//A start
			b=false;//B die
			cTurn=(int)(Math.random()*2)+1;
			if(cTurn==1) {//C missed
				c=false;//A winner
				return 'A';
			}
			else {//strike
				return 'C';
			}

		}
		else if(start==1) {//B start
			bTurn=(int)(Math.random()*10)+1;
			if(bTurn<=8) {//B strike A
				a=false;
				cTurn=(int)(Math.random()*2)+1;
				bTurn=(int)(Math.random()*10)+1;
				if(cTurn==2) {//C strike B
					return 'C';//C winner
				}
				else if(bTurn<=8) {//B strike
					return 'B';//B winner
				}
				while(bTurn>8&&cTurn==1) {//both missed
					cTurn=(int)(Math.random()*2)+1;
					bTurn=(int)(Math.random()*10)+1;
					if(cTurn==2) {
						return 'C';//C winner
					}
					if(bTurn<=8) {
						return 'B';//B winner
					}
				}
			}
			else {//B missed, C turn,C missed on perpuse ,A turn
				b=false;//B die
				cTurn=(int)(Math.random()*2)+1;
				if(cTurn==1) {//C missed
					c=false;//A winner
					return 'A';
				}
				else {//strike
					return 'C';
				}
			}
		}
		else {//C missed on perpose and the turn go to A
			b=false;//A strike B
			cTurn=(int)(Math.random()*2)+1;
			if(cTurn==2) {
				return 'C';//C winner
			}
			else {
				return 'A';//A winner
			}
		}
		return '0';
	}



	public static void main(String[] args) {
		char arr[]= {'A','B','C'};
		System.out.println(winner(arr));
		
		int sumA=0;
		int sumB=0;
		int sumC=0;
		
		for (int i = 0; i < 10000; i++) {
			char s= winner(arr);
			if(s=='A') {
				sumA++;
			}
			else if(s=='B') {
				sumB++;
			}
			else {
				sumC++;
			}
		}
		System.out.println("A winner: "+sumA+" , B winner: "+sumB+ " , C winner: "+sumC);
	}

}
