package org.gj.cv.operator;

import static org.bytedeco.javacpp.opencv_imgcodecs.imread;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.junit.Test;

public class CannyOperatorTest {
	CannyOperator operator=new CannyOperator();
	@Test
	public void canny() {
		 Mat matL = imread("C:\\Users\\gaojun\\Pictures\\Camera Roll\\a.jpg");
		 operator.handle(matL);
	}

}
