package lec9Implement;

public class PrisonersProblem {
	/**
	 * the strategic is - just the counter prisoner turn off the lamp, so when other prisoner will enter the room -
	 * he will turn on the lamp only when the lamp are turn off and then when the counter prisoner will enter the room
	 * and see the lamp turn on - he will know that someone new was here and add 1 to his count.
	 * @param num = the number of the prisoners
	 * @return the number of all entry of all the prisoners till the count is finish.
	 */
	public static String LampIsON(int num) {
		boolean isOn=true;
		boolean WasInRoom[]=new boolean[num];
		for (int i = 0; i < WasInRoom.length; i++) {
			WasInRoom[i]=false;
		}
		int averageEntryOfAllPrisoners=0;
		WasInRoom[0]=true;//this is the count prisoner
		int count=1;
		while(count<num) {
			int prisonerNum=(int)(Math.random()*(num));//number between 0-99 (because prisoner number 0 is the counter
			averageEntryOfAllPrisoners++;
			if(WasInRoom[prisonerNum]==false&&prisonerNum!=0) {//if the prisoner dont was yet in room and its not the counter
				if(isOn) {
					isOn=false;//turn off the lamp for counter prisoner count you
					WasInRoom[prisonerNum]=true;
				}
				else {
					isOn=false;//dont turn the lamp, wait for the counter prisoner
				}
			}
			if(prisonerNum==0) {
				if(!isOn) {//if the lamp is turn off - the counter prisoner turn it on and add 1 to the count
					count++;
					isOn=true;
				}
				else {//there was no new prisoner for count
					isOn=true;
				}
			}
		}
		return "the number entry of all the prisoners till all of the was count is:"+averageEntryOfAllPrisoners;
	}
	
	/**
	 * the strategic is that now the prisoners should turn on the lamp 2 times - because now we don't know
	 * the position of the lamp, so when the counter prisoner will count 2*(num-1) - he will know that all the
	 * prisoners are counted.
	 * @param num - the numbers of the prisoners
	 * @return the number entry of all the prisoners till the count is finish.
	 */
	public static String UnknownPositionOfLamp(int num) {
		boolean isOn;
		int flag=(int)(Math.random()*2);
		isOn=(flag==0)?false:true;
		int WasInRoom[]=new int[num];
		int averageEntryOfAllPrisoners=0;
		WasInRoom[0]=2;//this is the count prisoner
		int count=1;
		while(count<2*(num-1)) {
			int prisonerNum=(int)(Math.random()*(num));//number between 0-99 
			averageEntryOfAllPrisoners++;
			if(WasInRoom[prisonerNum]<2) {//because now the prisoners should turn on the lamp 2 times
				if(isOn) {
					WasInRoom[prisonerNum]++;
					isOn=false;//turn on the lamp for counter prisoner will count you
				}
				else {
					isOn=false;//dont touch the lamp
				}
			}
			if(prisonerNum==0) {
				if(!isOn) {//if the lamp are turn off
					isOn=true;
					count++;
				}
				else {//if the lamp are turn on
					isOn=true;//there was no new prisoner for count
				}
			}
		}
		return "the number entry of all the prisoners till all of the was count is:"+averageEntryOfAllPrisoners;
	}
	
	public static void main(String[] args) {
		System.out.println(UnknownPositionOfLamp(100));
	}
}
