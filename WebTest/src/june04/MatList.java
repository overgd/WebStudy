package june04;

import java.util.ArrayList;
import java.util.List;

public class MatList {
	
	public List getJips(String gu) {
		
		ArrayList<String> jip = new ArrayList<String>();
		
		if(gu.equals("���빮��")) {
			jip.add("���� ���");
			jip.add("ũ��� ����");
		}else if(gu.equals("������")) {
			jip.add("�⸰ ����");
			jip.add("������ ���ο�");
		}else if(gu.equals("������")) {
			jip.add("�߽�ĭ ȭ��Ʈ");
		}
		
		return jip;
	}
}
