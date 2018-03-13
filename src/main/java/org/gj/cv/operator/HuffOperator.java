package org.gj.cv.operator;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.springframework.stereotype.Component;
import org.opencv.imgcodecs.Imgcodecs;
@Component("huff")
public class HuffOperator extends Operator {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "huff";
	}

	@Override
	public Mat handle(Mat res, int barPos) {
		// TODO Auto-generated method stub
		Mat gray = new Mat(res.rows(), res.cols(), CvType.CV_8SC1);	
		Imgproc.cvtColor(res, gray, Imgproc.COLOR_RGB2GRAY); 		// グレースケール変換
		Imgproc.Canny(gray, gray, 70, 110);										// 輪郭線検出
		Mat lines = new Mat();
		// 古典的ハフ変換で直線検出
		Imgproc.HoughLines(gray, lines, 1, 2*Math.PI/180, 20);
		Mat result = new Mat(res.rows(), res.cols(), CvType.CV_8SC1);	
		// 検出した直線上を赤線で塗る
		for (int i = 0; i < lines.cols(); i++){
			double data[] = lines.get(0, i);
			double rho = data[0];
			double theta = data[1];
			double cosTheta = Math.cos(theta);
			double sinTheta = Math.sin(theta);
			double x0 = cosTheta * rho;
			double y0 = sinTheta * rho;
			Point pt1 = new Point(x0 + 10000 * (-sinTheta), y0 + 10000 * cosTheta);
			Point pt2 = new Point(x0 - 10000 * (-sinTheta), y0 - 10000 * cosTheta);
			Imgproc.line(result, pt1, pt2, new Scalar(255, 255, 255), 3);
		}
		return null;
	}

}
