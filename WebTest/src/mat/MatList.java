package mat;

import java.util.ArrayList;
import java.util.List;

public class MatList {
	
	public List getJips(String gu) {
		
		ArrayList<String> jip = new ArrayList<String>();
		
		if(gu.equals("���빮��")) {
			jip.add("����¯");
			jip.add("Ȧ�η�ġŲ");
		}else if(gu.equals("������")) {
			jip.add("������");
			jip.add("����");
		}else if(gu.equals("������")) {
			jip.add("������");
		}
		
		return jip;
	}
}
