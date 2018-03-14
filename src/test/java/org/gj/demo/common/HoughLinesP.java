package org.gj.demo.common;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class HoughLinesP{
	public static void main(String[] args){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat im = Imgcodecs.imread("C:\\workplace\\img\\0.jpg",0);	// 入力画像の取得
		Mat cCanny=new Mat();
		Mat gray = new Mat();	
		Imgproc.Canny(im, gray, 50, 200);										// 輪郭線検出
		Imgproc.cvtColor(gray, cCanny, Imgproc.COLOR_GRAY2BGR); 		// グレースケール変換
		Mat lines = new Mat();
		// 確率的ハフ変換で直線検出
		Imgproc.HoughLinesP(gray, lines, 1, Math.PI/180, 50, 50 ,10);
		int[] a = new int[(int)lines.total()*lines.channels()]; //数组a存储检测出的直线端点坐标
		lines.get(0,0,a);  
        for (int i = 0; i < a.length; i += 4)
        {
        	Imgproc.line(cCanny, new Point(a[i], a[i+1]), new Point(a[i+2], a[i+3]), new Scalar(255, 0, 255),4);
        }
		Imgcodecs.imwrite("C:\\workplace\\img\\huffp.jpg", cCanny);								// 出力画像の保存
	}
}