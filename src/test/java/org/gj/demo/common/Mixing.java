package org.gj.demo.common;
import static org.bytedeco.javacpp.opencv_core.addWeighted;
import static org.bytedeco.javacpp.opencv_core.split;
import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_highgui.imshow;
import static org.bytedeco.javacpp.opencv_highgui.waitKey;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.MatVector;
import org.junit.Test;

public class Mixing {
	@Test
    public void mixRB() { 
		Mat matDst = new Mat();
        Mat matL = imread("C:\\Users\\gaojun\\Pictures\\Camera Roll\\a.jpg");
        MatVector channelsL=new MatVector();
		split(matL, channelsL);//分离色彩通道  
        Mat red=channelsL.get(0);
        Mat matR = imread("C:\\Users\\gaojun\\Pictures\\Camera Roll\\a.jpg");
        MatVector channelsR=new MatVector();
        split(matR, channelsR);//分离色彩通道  
        Mat blue=channelsR.get(2);
        addWeighted(red,1.0,blue,1.0,0.0,matDst);
        imshow( "Linear Blend", matDst );
        waitKey(0);
    }
	@Test
    public void mixL_rAndR_bg() { 
		MatVector l_gAndR_bg=new MatVector();
		Mat matDst = new Mat();
        Mat matL = imread("C:\\Users\\gaojun\\Pictures\\Camera Roll\\l2.jpg");
        MatVector channelsL=new MatVector();
        //BGR
		split(matL, channelsL);//分离色彩通道  		
        Mat matR = imread("C:\\Users\\gaojun\\Pictures\\Camera Roll\\r2.jpg");
        MatVector channelsR=new MatVector();
        split(matR, channelsR);//分离色彩通道  
        //添加通道要按顺序来
        l_gAndR_bg.push_back(channelsR.get(0));
        l_gAndR_bg.push_back(channelsR.get(1));
        l_gAndR_bg.push_back(channelsL.get(2));
        //OR:l_gAndR_bg.push_back(channelsL.get(1));?http://blog.csdn.net/zebar01/article/details/54669584
        merge(l_gAndR_bg,matDst);
        imshow( "Linear Blend", matDst );
        waitKey(0);
    }
	@Test
    public void mixL_bgAndR_gr() { 
		MatVector l_gAndR_bg=new MatVector();
		Mat matDst = new Mat();
        Mat matL = imread("C:\\Users\\gaojun\\Pictures\\Camera Roll\\a.jpg");
        MatVector channelsL=new MatVector();
        //BGR
		split(matL, channelsL);//分离色彩通道  
		l_gAndR_bg.push_back(channelsL.get(0));
		//l_gAndR_bg.push_back(channelsL.get(1));
        Mat matR = imread("C:\\Users\\gaojun\\Pictures\\Camera Roll\\a.jpg");
        MatVector channelsR=new MatVector();
        split(matR, channelsR);//分离色彩通道  
        l_gAndR_bg.push_back(channelsR.get(1));
        l_gAndR_bg.push_back(channelsR.get(2));
        merge(l_gAndR_bg,matDst);
        imshow( "Linear Blend", matDst );
        waitKey(0);
    }
}