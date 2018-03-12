package org.gj.demo.vo;

public class OperatorRequest {
	String name;
	String dstUrl;
	int barPos=1;
	
	public OperatorRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OperatorRequest(String name, String dstUrl,int barPos) {
		super();
		this.name = name;
		this.dstUrl = dstUrl;
		this.barPos=barPos;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDstUrl() {
		return dstUrl;
	}
	public void setDstUrl(String dstUrl) {
		this.dstUrl = dstUrl;
	}
	public int getBarPos() {
		return barPos;
	}

	public void setBarPos(int barPos) {
		this.barPos = barPos;
	}

	@Override
	public String toString() {
		return "OperatorRequest [name=" + name + ", dstUrl=" + dstUrl + ", barPos=" + barPos + "]";
	}


}
