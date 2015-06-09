package myhome;

import java.util.ArrayList;

public class BBSList {
	
	private ArrayList<Integer> seqNoList = new ArrayList<Integer>();
	private ArrayList<String> titleList = new ArrayList<String>();
	private ArrayList<String> writerList = new ArrayList<String>();
	
	private int pageNum;
	private boolean firstPage = false;
	private boolean lastPage = false;
	
	public int getListSize(){
		return seqNoList.size();
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
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public void setSeqNo(int index, Integer seqno) {
		this.seqNoList.add(index, seqno);
	}
	public void setTitle(int index, String title) {
		this.titleList.add(index, title);
	}
	public void setWriter(int index, String writer) {
		this.writerList.add(index, writer);
	}
	
	public Integer[] getSeqNo() {
		return seqNoList.toArray(new Integer[seqNoList.size()]);
	}
	public String[] getTitle() {
		return titleList.toArray(new String[titleList.size()]);
	}
	public String[] getWriter() {
		return writerList.toArray(new String[writerList.size()]);
	}
	
}