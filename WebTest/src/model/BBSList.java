package model;

import java.io.Serializable;
import java.util.ArrayList;

public class BBSList implements Serializable{
	
	private int seqno;
	private String title;
	private String id;
	
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}