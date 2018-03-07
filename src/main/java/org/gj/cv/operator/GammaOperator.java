package org.gj.cv.operator;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacpp.annotation.Namespace;
import org.bytedeco.javacpp.opencv_highgui;
import org.bytedeco.javacpp.opencv_highgui.CvTrackbarCallback;

@Namespace(value = "cv")
/**
 * 图像校正
 * 
 * @author gaojun
 *
 */
public class GammaOperator {
	public void gammaCorrection(Mat dst, double gamma) {
		Mat img_gamma_corrected = new Mat(dst.rows(), dst.cols() * 2, dst.type());
		Mat lookUpTable = new Mat(1, 256, opencv_core.CV_8U);
		BytePointer p = lookUpTable.ptr();
		for (int i = 0; i < 256; ++i) {
			byte pi = p.get(i);
			pi = opencv_core.ucharSaturateCast(Math.pow(i / 255.0, gamma) * 255.0);
			p.put(i, pi);
		}
		Mat res = dst.clone();
		// lookUpTable相当于一个像素索引 1-255、2-254
		// 遍历dst获得像素，从lookUpTable中获得对应的像素值，赋值给res
		opencv_core.LUT(dst, lookUpTable, res);
		// ![changing-contrast-brightness-gamma-correction]
		opencv_core.hconcat(dst, res, img_gamma_corrected);
		opencv_highgui.imshow("gamma", img_gamma_corrected);
		// opencv_imgcodecs.imwrite("C:\\workplace\\im\\kk\\img_gamma_corrected.jpg",
		// img_gamma_corrected);
	}

	public void handle(Mat dst) {
		opencv_highgui.namedWindow("gamma");
		IntPointer gamma_cor = new IntPointer();//无用参数
		opencv_highgui.cvCreateTrackbar("gamma", "gamma", gamma_cor, 200, new CvTrackbarCallback() {
			public void call(int pos) {
				gammaCorrection(dst, pos / 100.0);
				System.out.println(pos);
			}
		});
		gammaCorrection(dst, 0);
		opencv_highgui.waitKey(0);
	}
}
