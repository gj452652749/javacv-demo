package org.gj.cv.operator;

import java.util.ArrayList;
import java.util.List;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.gj.demo.vo.OperatorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class OperatorChain {
	@Autowired
	OperatorFactory operatorFactory;
	private int pos = 0;
	//将此元素序列化到json输出
	List<OperatorRequest> operatorReqs = new ArrayList<>();

	public int getPos() {
		return pos;
	}

	public void setOperators(List<OperatorRequest> operatorReqs) {
		this.operatorReqs = operatorReqs;
	}

	public void add(OperatorRequest opReq) {
		operatorReqs.add(opReq);
	}

	public void add(int index, OperatorRequest opReq) {
		operatorReqs.add(index, opReq);
	}

	public void remove(int index) {
		operatorReqs.remove(index);
	}

	public void set(int index, OperatorRequest opReq) {
		operatorReqs.set(index, opReq);
	}

	public Mat doOperator(Mat res) {
		Mat dst=res.clone();
		if(pos<=(operatorReqs.size()-1)) {
			Operator op=operatorFactory.getBean(operatorReqs.get(pos).getName(),Operator.class);
			pos++;
			return op.doOperator(dst,this);
			
		}
		Mat rep=new Mat();
		opencv_core.hconcat(dst, res, rep);
		return rep;
	}

}