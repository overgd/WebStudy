package june04;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
	
	public List getBrands(String color) {
		
		ArrayList<String> brands = new ArrayList<String>();
		
		if(color.equals("���� ��")) {
			brands.add("���� ���");
			brands.add("ũ��� ����");
		}else if(color.equals("����")) {
			brands.add("�⸰ ����");
			brands.add("������ ���ο�");
		}else if(color.equals("����")) {
			brands.add("�߽�ĭ ȭ��Ʈ");
		}else if(color.equals("��ο� ��")) {
			brands.add("��Ÿ��Ʈ");
			brands.add("����");
		}
		
		return brands;
	}
	
}
