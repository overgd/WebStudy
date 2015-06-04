package june04;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
	
	public List getBrands(String color) {
		
		ArrayList<String> brands = new ArrayList<String>();
		
		if(color.equals("밝은 색")) {
			brands.add("오비 라거");
			brands.add("크라운 맥주");
		}else if(color.equals("갈색")) {
			brands.add("기린 맥주");
			brands.add("상하이 옐로우");
		}else if(color.equals("무색")) {
			brands.add("멕시칸 화이트");
		}else if(color.equals("어두운 색")) {
			brands.add("스타우트");
			brands.add("블랙얔");
		}
		
		return brands;
	}
	
}
