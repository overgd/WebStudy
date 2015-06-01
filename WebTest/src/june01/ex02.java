package june01;

public class ex02 {

	public static int[] goldnum(int gold) {
		
		int[] num = new int[10];
		for(int i = 0; i < num.length ;i++){		
			if(i%2 == 0) {
				num[i] = gold/ (5*(int)Math.pow(10, 5-(int)Math.round(((double)i+1)/2)));
				gold = gold% (5*(int)Math.pow(10, 5-(int)Math.round(((double)i+1)/2)));
			}
			else if(i%2 == 1) {
				num[i] = gold/ (int)Math.pow(10, 5-(int)Math.round(((double)i+1)/2));
				gold = gold% (int)Math.pow(10, 5-(int)Math.round(((double)i+1)/2));
			}
		}
		return num; 
	}
}

