package myhome;

import java.util.LinkedList;

public class Cart {

		private LinkedList<String> codeList = new LinkedList<String>(); 	//��ǰ�ڵ�
		private LinkedList<Integer> numberList = new LinkedList<Integer>(); 	//��ǰ����
		
		public void addItem(String code, int num) { 	//��ǰ�� ��� �޼���
			
			for(int i = 0; i < codeList.size(); i++) { 
				if(codeList.get(i).equals(code)) {
					numberList.set(i, numberList.get(i)+1);
					return; //�޼��� ����
				}
			}
			
			codeList.add(code);
			numberList.add(num);
			
		}
		public String getCode(int index) { //��ٱ����� ��ǰ�ڵ�
			return codeList.get(index);
		}
		public int getNumber(int index) { //��ٱ����� ��ǰ ����
			return numberList.get(index);
		}
		public int getSize(){ //��ٱ��Ͽ� ��� ��ǰ�� ���� ����
			return codeList.size();
		}
	
}
