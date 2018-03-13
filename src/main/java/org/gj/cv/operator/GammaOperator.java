package org.gj.cv.operator;

import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.springframework.stereotype.Component;

/**
 * 图像校正
 * 
 * @author gaojun
 *
 */
@Component("gamma")
public class GammaOperator extends Operator{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "gamma";
	}
	public Mat gammaCorrection(Mat dst, double gamma) {
		//Mat img_gamma_corrected = new Mat(dst.rows(), dst.cols() * 2, dst.type());
		Mat lookUpTable = new Mat(1, 256, CvType.CV_8UC1);
		lookUpTable.setTo(new Scalar(0));
		for (int i = 0; i < 256; ++i) {
			lookUpTable.put(0, i, Math.pow((double)(1.0 * i/255), 1/gamma) * 255);	
		}
		Mat res = dst.clone();
		// lookUpTable相当于一个像素索引 1-255、2-254
		// 遍历dst获得像素，从lookUpTable中获得对应的像素值，赋值给res
		Core.LUT(dst, lookUpTable, res);
		return res;
	}
	@Override
	public Mat handle(Mat dst,int barPos) {
		return gammaCorrection(dst, barPos/ 100.0);
	}
}
