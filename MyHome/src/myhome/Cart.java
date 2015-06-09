package myhome;

import java.util.LinkedList;

public class Cart {

		private LinkedList<String> codeList = new LinkedList<String>(); 	//상품코드
		private LinkedList<Integer> numberList = new LinkedList<Integer>(); 	//상품갯수
		
		public void deleteItem(String code) {
			for(int cnt = 0; cnt < codeList.size(); cnt++) {
				if(codeList.get(cnt).equals(code)) {
					codeList.remove(cnt);
					numberList.remove(cnt);
					return;
				}
			}
		}
		
		public void modifyItem(String code, int num) {
			for(int cnt = 0; cnt < codeList.size(); cnt++) {
				if(codeList.get(cnt).equals(code)) {
					numberList.set(cnt, num);
					return;
				}
			}
			
		}
		
		public void addItem(String code, int num) { 	//상품을 담는 메서드
			
			for(int i = 0; i < codeList.size(); i++) { 
				if(codeList.get(i).equals(code)) {
					numberList.set(i, numberList.get(i)+1);
					return; //메서드 종료
				}
			}
			
			codeList.add(code);
			numberList.add(num);
			
		}
		public String getCode(int index) { //장바구니의 상품코드
			return codeList.get(index);
		}
		public int getNumber(int index) { //장바구니의 상품 갯수
			return numberList.get(index);
		}
		public int getSize(){ //장바구니에 담긴 상품의 종류 갯수
			return codeList.size();
		}
	
}
