package org.gj.cv.operator;

import static org.bytedeco.javacpp.opencv_imgproc.Canny;
import static org.bytedeco.javacpp.opencv_imgproc.blur;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Size;
import org.bytedeco.javacpp.opencv_imgproc;
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
		double lowThreshold=1;
		int ratio = 3;
		int kernel_size = 3;
		Mat src_gray=new Mat();
		Mat dst=new Mat();
		dst.create(res.size(), res.type());
		Mat detected_edges=new Mat();
		opencv_imgproc.cvtColor(res, src_gray, opencv_imgproc.COLOR_BGR2GRAY);  
		blur(src_gray, detected_edges, new Size(3, 3));
		Canny(detected_edges, detected_edges, lowThreshold, lowThreshold*ratio,kernel_size,false);
		res.copyTo(dst, detected_edges);
		return dst;
	}

}
