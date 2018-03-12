package org.gj.cv.operator;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.gj.context.AppContext;
import org.gj.util.WebAppConfig;
@Component
public abstract class Operator {
	@Autowired
    WebAppConfig webAppConfig;
	@Autowired
	AppContext appContext;
	String savePath;
	
	public abstract String getName();
	public String getSavePath() {
		return savePath;
	}
	public abstract Mat handle(Mat dst,int barPos);
	public Mat doOperator(Mat img,int barPos,OperatorChain chain) {
		//savePath=webAppConfig.getoperatorImagesPath()+"/"+chain.getPos()+".jpg";
		savePath="C:\\workplace\\img\\"+chain.getPos()+"-"+appContext.getVersion().get()+".jpg";
		Mat rep=handle(img,barPos);
		opencv_imgcodecs.imwrite(savePath,
				rep);
		System.out.println("图片保存到："+savePath);
		return chain.doOperator(rep);
	}

}
