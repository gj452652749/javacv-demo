package org.gj.cv.operator;

import static org.bytedeco.javacpp.opencv_imgproc.Canny;
import static org.bytedeco.javacpp.opencv_imgproc.blur;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Size;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacpp.opencv_imgproc;

/**
 * 边缘提取
 * 
 * @author gaojun
 *
 */
public class CannyOperator {
	public void handle(Mat src) {
		double lowThreshold=1;
		int max_lowThreshold = 100;
		int ratio = 3;
		int kernel_size = 3;
		Mat src_gray=new Mat();
		Mat dst=new Mat();
		dst.create(src.size(), src.type());
		Mat detected_edges=new Mat();
		opencv_imgproc.cvtColor(src, src_gray, opencv_imgproc.COLOR_BGR2GRAY);  
		blur(src_gray, detected_edges, new Size(3, 3));
		Canny(detected_edges, detected_edges, lowThreshold, lowThreshold*ratio,kernel_size,false);
		src.copyTo(dst, detected_edges);
		opencv_imgcodecs.imwrite("C:\\workplace\\im\\kk\\a.jpg", dst);
	}

}