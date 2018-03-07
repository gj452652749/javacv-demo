package org.gj.demo.common;

import static org.bytedeco.javacpp.opencv_highgui.imshow;
import static org.bytedeco.javacpp.opencv_highgui.waitKey;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgproc.*;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.junit.Test;

public class Segmentor {
	@Test
	public void seg() {
		Mat gray=new Mat();
		Mat image = imread("C:\\Users\\gaojun\\Pictures\\Camera Roll\\garden.jpg");
        if (image == null) {
            return;
        }
        cvtColor(image, gray, COLOR_BGR2GRAY);
        imshow( "gray", gray );
        waitKey(0);
	}

}
