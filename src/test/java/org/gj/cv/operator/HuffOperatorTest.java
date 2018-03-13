package org.gj.cv.operator;


import org.junit.Test;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class HuffOperatorTest {
	HuffOperator operator=new HuffOperator();
	@Test
	public void huff() {
		 Mat matL = Imgcodecs.imread("C:\\Users\\gaojun\\Pictures\\Camera Roll\\a.jpg");
		 Mat result=operator.handle(matL,50);
		 Imgcodecs.imwrite("C:\\Users\\gaojun\\Pictures\\Camera Roll\\houghline.jpg",result);
	}
}
