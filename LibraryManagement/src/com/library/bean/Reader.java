package com.library.bean;

public class Reader {
	int readerId;
	public int getReaderId() {
		return readerId;
	}

	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getReaderDesg() {
		return readerDesg;
	}

	public void setReaderDesg(String readerDesg) {
		this.readerDesg = readerDesg;
	}

	String readerName;

	String readerDesg;
	String readerPass;
	
	public String getReaderPass() {
		return readerPass;
	}

	public void setReaderPass(String readerPass) {
		this.readerPass = readerPass;
	}

	public int getId() {
		return readerId;
	}
	public String getName() {
		return readerName;
	}
	public String getPass()
	{
		return readerPass;
	}
	public String getDesignation()
	{
		return readerDesg;
		
	}
	
	@Override
	public String toString() {
		return "Reader [id=" + readerId + ", pass=" + readerPass + ", name=" + readerName + ", designation=" + readerDesg
				+ "]";
}
}
