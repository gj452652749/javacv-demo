package org.gj.cv.operator;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.springframework.stereotype.Component;

/**
 * 边缘提取
 * 
 * @author gaojun
 *
 */
@Component("canny")
public class CannyOperator extends Operator{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "canny";
	}
	@Override
	public Mat handle(Mat res,int barPos) {
		double lowThreshold=barPos;
		int ratio = 3;
		int kernel_size = 3;
		Mat src_gray=new Mat();
		Mat dst=new Mat();
		dst.create(res.size(), res.type());
		Mat detected_edges=new Mat();
		Imgproc.cvtColor(res, src_gray, Imgproc.COLOR_BGR2GRAY);  
		Imgproc.blur(src_gray, detected_edges, new Size(3, 3));
		Imgproc.Canny(detected_edges, detected_edges, lowThreshold, lowThreshold*ratio,kernel_size,false);
		res.copyTo(dst, detected_edges);
		return dst;
	}

}
