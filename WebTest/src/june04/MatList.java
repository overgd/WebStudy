package june04;

import java.util.ArrayList;
import java.util.List;

public class MatList {
	
	public List getJips(String gu) {
		
		ArrayList<String> jip = new ArrayList<String>();
		
		if(gu.equals("서대문구")) {
			jip.add("오비 라거");
			jip.add("크라운 맥주");
		}else if(gu.equals("마포구")) {
			jip.add("기린 맥주");
			jip.add("상하이 옐로우");
		}else if(gu.equals("강남구")) {
			jip.add("멕시칸 화이트");
		}
		
		return jip;
	}
}
