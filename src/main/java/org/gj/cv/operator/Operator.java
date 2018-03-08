package org.gj.cv.operator;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_imgcodecs;
public abstract class Operator {
	String savePath;
	
	public abstract String getName();
	public String getSavePath() {
		return savePath;
	}
	public abstract Mat handle(Mat dst);
	public Mat doOperator(Mat img,OperatorChain chain) {
		savePath="C:\\workplace\\java\\project\\tmp\\img\\"+chain.getPos()+".jpg";
		Mat rep=handle(img);
		opencv_imgcodecs.imwrite(savePath,
				rep);
		return chain.doOperator(rep);
	}

}
