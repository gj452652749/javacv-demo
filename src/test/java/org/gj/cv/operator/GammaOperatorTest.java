package org.gj.cv.operator;

import static org.bytedeco.javacpp.opencv_imgcodecs.imread;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.junit.Test;

public class GammaOperatorTest {
	GammaOperator gammaOperator=new GammaOperator();
	@Test
	public void gamma() {
		Mat matL = imread("C:\\Users\\gaojun\\Pictures\\Camera Roll\\a.jpg");
		gammaOperator.handle(matL);
	}

}
