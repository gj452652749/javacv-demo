package org.gj.cv.operator;


import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class GammaOperatorTest {
	GammaOperator gammaOperator=new GammaOperator();
	@Test
	public void gamma() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat matL =  Imgcodecs.imread("C:\\Users\\gaojun\\Pictures\\Camera Roll\\a.jpg");
		Mat result=gammaOperator.handle(matL,50);
		Imgcodecs.imwrite("C:\\Users\\gaojun\\Pictures\\Camera Roll\\gamma.jpg",result);
	}

}
