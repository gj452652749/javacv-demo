package org.gj.cv.operator;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.gj.util.WebAppConfig;
@Component
public abstract class Operator {
	@Autowired
    WebAppConfig webAppConfig;
	String savePath;
	
	public abstract String getName();
	public String getSavePath() {
		return savePath;
	}
	public abstract Mat handle(Mat dst);
	public Mat doOperator(Mat img,OperatorChain chain) {
		savePath=webAppConfig.getoperatorImagesPath()+"/"+chain.getPos()+".jpg";
		Mat rep=handle(img);
		opencv_imgcodecs.imwrite(savePath,
				rep);
		return chain.doOperator(rep);
	}

}
