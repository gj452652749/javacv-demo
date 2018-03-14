package org.gj.img;

import java.io.IOException;

import org.gj.file.FileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import net.coobird.thumbnailator.Thumbnails;
@Component
public class ImgHandler {
	@Autowired
	FileHandler fileHandler;
	/**
	 * 将图片下载下来resize，并保存
	 * @param url 图片地址
	 * @param filePath 保存图片的路径
	 * @throws IOException 
	 */
	public void resave(String resourceUrl,String filePath,int height,int weight) throws IOException {
		try {
			fileHandler.download(ResourceUtils.getFile(filePath), resourceUrl);
			Thumbnails.of(ResourceUtils.getFile(filePath))
            .forceSize(height, weight)
            .toFile(ResourceUtils.getFile(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 遍历数据库中的图片
	 */

}
