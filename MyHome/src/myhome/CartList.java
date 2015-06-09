package myhome;

import java.util.ArrayList;

public class CartList {
	
	private ArrayList<Integer> codeList = new ArrayList<Integer>();//�ڵ�
	private ArrayList<String> nameList = new ArrayList<String>();//�̸�
	private ArrayList<Integer> priceList = new ArrayList<Integer>();//����
	private ArrayList<Integer> numberList = new ArrayList<Integer>();//����

	private int pageNum;
	private boolean firstPage = false;
	private boolean lastPage = false;
	
	
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public void setCode(int index, Integer code) {
		this.codeList.add(index, code);
	}
	
	public Integer[] getCode() {
		return codeList.toArray(new Integer[codeList.size()]);
	}
	
	public void setname(int index, String code) {
		this.nameList.add(index, code);
	}
	
	public String[] getname() {
		return nameList.toArray(new String[nameList.size()]);
	}
	
	public void setPrice(int index, Integer price) {
		this.priceList.add(index, price);
	}
	
	public Integer[] getPrice() {
		return priceList.toArray(new Integer[priceList.size()]);
	}
	
	public void setNumber(int index, Integer number) {
		this.numberList.add(index, number);
	}
	
	public Integer[] getNumber() {
		return numberList.toArray(new Integer[numberList.size()]);
	}
	
	public int getTotalAmount() {//��ٱ����� �Ѿ��� ��ȯ
		int total = 0;
		for(int i = 0; i < codeList.size(); i++) {
			total = total + priceList.get(i) * numberList.get(i);
		}
		return total;
	}
	
	public int getSize() { //��ٱ����� �׸��� ���� ��ȯ
		return codeList.size();
	}
	
}
