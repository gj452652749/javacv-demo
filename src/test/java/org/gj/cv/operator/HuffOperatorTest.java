package org.gj.cv.operator;


import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class HuffOperatorTest {
	HuffOperator operator=new HuffOperator();
	@Test
	public void huff() {
		 System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		 Mat matL = Imgcodecs.imread("C:\\Users\\gaojun\\Pictures\\Camera Roll\\college.jpg");
		 Mat result=operator.handle(matL,50);
		 Imgcodecs.imwrite("C:\\Users\\gaojun\\Pictures\\Camera Roll\\houghline.jpg",result);
	}
}
