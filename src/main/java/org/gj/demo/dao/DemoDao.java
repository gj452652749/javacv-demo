package org.gj.demo.dao;


import java.io.IOException;
import java.util.List;

import org.gj.cv.operator.OperatorChain;
import org.gj.demo.vo.OperatorRequest;
import org.gj.img.ImgHandler;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class DemoDao {
	@Autowired
	OperatorChain operatorChain;
	@Autowired
	ImgHandler imgHandler;
	public OperatorChain getOperatorChain() {
		return operatorChain;
	}

	public void doOperator(List<OperatorRequest> operatorReqs) throws IOException {
		String imgPath="C:\\workplace\\img\\0.jpg";
		imgHandler.resave("http://images2017.cnblogs.com/blog/676383/201707/676383-20170726094353935-835577957.png"
				, imgPath,240,320);
		Mat res = Imgcodecs.imread(imgPath);
		operatorChain.setOperators(operatorReqs);
		operatorChain.doOperator(res);
	}

}
