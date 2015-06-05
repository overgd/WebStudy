package myhome;

import java.util.ArrayList;

public class BBSList {
	
	private ArrayList<Integer> seqNoList = new ArrayList<Integer>();
	private ArrayList<String> titleList = new ArrayList<String>();
	private ArrayList<String> writerList = new ArrayList<String>();
	
	
	public void setSeqNo(int index, Integer seqno) {
		this.seqNoList.add(index, seqno);
	}
	public void setTitle(int index, String seqno) {
		this.titleList.add(index, seqno);
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