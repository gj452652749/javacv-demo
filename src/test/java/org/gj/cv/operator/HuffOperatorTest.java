package org.gj.cv.operator;

import static org.bytedeco.javacpp.opencv_highgui.imshow;
import static org.bytedeco.javacpp.opencv_highgui.waitKey;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.junit.Test;

public class HuffOperatorTest {
	HuffOperator operator=new HuffOperator();
	@Test
	public void huff() {
		 Mat matL = imread("C:\\Users\\gaojun\\Pictures\\Camera Roll\\a.jpg");
		 Mat result=operator.handle(matL,50);
		 imshow( "result", result );
		 waitKey(0);
	}
}
