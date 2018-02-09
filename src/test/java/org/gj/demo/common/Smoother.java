package org.gj.demo.common;
import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;

import org.junit.Test;

import static org.bytedeco.javacpp.opencv_imgcodecs.*;
import static org.bytedeco.javacpp.opencv_highgui.*;

public class Smoother {
	@Test
    public void smooth() { 
        Mat image = imread("C:\\Users\\gaojun\\Pictures\\Camera Roll\\e.jpg");
        if (image != null) {
            imshow("hello",image);
            waitKey(0);
        }
    }
}