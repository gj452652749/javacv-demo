package org.gj.demo.vo;

public class OperatorRequest {
	String name;
	String savePath;
	
	public OperatorRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OperatorRequest(String name, String savePath) {
		super();
		this.name = name;
		this.savePath = savePath;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

}
