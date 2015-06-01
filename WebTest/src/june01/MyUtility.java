package june01;

import java.util.TreeSet;

public class MyUtility {
	
	public static TreeSet getLotto() {
		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int i = 0; ts.size() < 6; i++) {
			int rnd = (int)(Math.random()*45+1);
			ts.add(rnd);
			
		}
		return ts;
		
	}

	public static int diceRandom() {
		
		int rnd = (int)(Math.random()*6+1);
		return rnd;
				
	}
	
	public static String diceGame() {
		
		int com = diceRandom();
		int human = diceRandom();
		String result = null;
		if(com > human) {
			result = "ÄÄ ½Â : "+com+" vs "+human;
		}
		else if(com < human) {
			result = "ÀÎ°£ ½Â : "+com+" vs "+human;
		}
		else{
			result = "¹«½ÂºÎ : "+com+" vs "+human;
		}
		return result;
	}
	
	public static int rangeRandom(int from, int to) {
		
		int rnd = (int)(Math.random()*(to-from+1)+from);
		return rnd;
		
	}
	
}