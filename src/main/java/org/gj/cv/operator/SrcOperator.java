package org.gj.cv.operator;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.springframework.stereotype.Component;
@Component("src")
public class SrcOperator extends Operator{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "src";
	}

	@Override
	public Mat handle(Mat dst, int barPos) {
		// TODO Auto-generated method stub
		return dst;
	}

}
