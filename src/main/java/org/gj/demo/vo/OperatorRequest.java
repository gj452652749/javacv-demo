package org.gj.demo.vo;

public class OperatorRequest {
	String name;
	String dstUrl;
	
	public OperatorRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OperatorRequest(String name, String dstUrl) {
		super();
		this.name = name;
		this.dstUrl = dstUrl;
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
	public void setSavePath(String dstUrl) {
		this.dstUrl = dstUrl;
	}

}
