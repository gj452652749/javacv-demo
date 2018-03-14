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
		Mat gray = new Mat();	
		//Imgproc.Canny(res, gray, 50, 200);	
		Imgproc.cvtColor(res,gray, Imgproc.COLOR_RGB2GRAY); //灰度化
		Mat lines = new Mat();
		Imgproc.HoughLinesP(gray, lines, 1, Math.PI/180, 50, 50 ,10);
		Mat result = new Mat(res.rows(), res.cols(), CvType.CV_8SC1);	
		int[] a = new int[(int)lines.total()*lines.channels()]; //数组a存储检测出的直线端点坐标
		lines.get(0,0,a);  
        for (int i = 0; i < a.length; i += 4)
        {
        	Imgproc.line(result, new Point(a[i], a[i+1]), new Point(a[i+2], a[i+3]), new Scalar(255, 0, 255),1);
        }
		return result;
	}

}
