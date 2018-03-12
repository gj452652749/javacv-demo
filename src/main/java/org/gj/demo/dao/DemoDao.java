package org.gj.demo.dao;

import static org.bytedeco.javacpp.opencv_imgcodecs.imread;

import java.util.List;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.gj.cv.operator.OperatorChain;
import org.gj.demo.vo.OperatorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class DemoDao {
	@Autowired
	OperatorChain operatorChain;
	
	public OperatorChain getOperatorChain() {
		return operatorChain;
	}

	public void doOperator(List<OperatorRequest> operatorReqs) {
		Mat res = imread("C:\\workplace\\img\\0.jpg");
		operatorChain.setOperators(operatorReqs);
		operatorChain.doOperator(res);
	}

}
