package org.gj.cv.operator;

import static org.bytedeco.javacpp.opencv_imgproc.Canny;
import static org.bytedeco.javacpp.opencv_imgproc.blur;

import java.awt.Point;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_imgproc;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Size;
import org.springframework.stereotype.Component;

@Component("huff")
public class HuffOperator extends Operator {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "huff";
	}

	@Override
	public Mat handle(Mat res, int barPos) {
		// TODO Auto-generated method stub
		// 临时变量和目标图的定义
		Mat midImage = new Mat();
		Mat edge = new Mat();
		// 【2】进行边缘检测和转化为灰度图
		Canny(res, midImage, 50, 200, 3, false);// 进行一此canny边缘检测
		opencv_imgproc.cvtColor(midImage, edge, opencv_imgproc.COLOR_GRAY2BGR);// 转化边缘检测后的图为灰度图

		// 【3】进行霍夫线变换
		Mat lines = new Mat();// 定义一个矢量结构lines用于存放得到的线段矢量集合
		opencv_imgproc.HoughLines(midImage, lines, 1, Math.PI / 180, 150);
		int[] a = new int[(int) lines.total() * lines.channels()]; // 数组a存储检测出的直线端点坐标
		//lines.data().g
		for (int i = 0; i < a.length; i += 4)

		{
			opencv_core.line(midImage, new Point(a[i], a[i + 1]), new Point(a[i + 2], a[i + 3]), new Scalar(255, 0, 255), 4);
		}
		Mat result = new Mat();
		opencv_core.hconcat(res, lines, result);
		return result;
	}

}
