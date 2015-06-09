package myhome;

import java.util.ArrayList;

public class GoodsList {

	private ArrayList<Integer> codeList = new ArrayList<Integer>();
	private ArrayList<String> nameList = new ArrayList<String>();
	private ArrayList<Integer> priceList = new ArrayList<Integer>();
	
	private int pageNum;
	private boolean firstPage = false;
	private boolean lastPage = false;
	
	public int getListSize() {
		return codeList.size();
	}
	
	public Integer[] getCodeList() {
		return codeList.toArray(new Integer[codeList.size()]);
	}
	public void setCodeList(int index, int code) {
		this.codeList.add(index, code);
	}
	public String[] getNameList() {
		return nameList.toArray(new String[nameList.size()]);
	}
	public void setNameList(int index, String name) {
		this.nameList.add(index, name);
	}
	public Integer[] getPriceList() {
		return priceList.toArray(new Integer[priceList.size()]);
	}
	public void setPriceList(int index, int price) {
		this.priceList.add(index, price);
	}
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
	
	
	
}
