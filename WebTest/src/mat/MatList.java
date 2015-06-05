package mat;

import java.util.ArrayList;
import java.util.List;

public class MatList {
	
	public List getJips(String gu) {
		
		ArrayList<String> jip = new ArrayList<String>();
		
		if(gu.equals("서대문구")) {
			jip.add("여기짱");
			jip.add("홀로로치킨");
		}else if(gu.equals("마포구")) {
			jip.add("아하하");
			jip.add("맛남");
		}else if(gu.equals("강남구")) {
			jip.add("오오오");
		}
		
		return jip;
	}
}
