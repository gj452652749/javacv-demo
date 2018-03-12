package org.gj.util;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
	@Value("${operatorImagesPath}")
	private String operatorImagesPath;

	public String getoperatorImagesPath() {
		return operatorImagesPath;
	}
	public void setoperatorImagesPath(String operatorImagesPath) {
		this.operatorImagesPath = operatorImagesPath;
	}

	// 访问图片方法
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (operatorImagesPath.equals("") || operatorImagesPath.equals("${sougou.imagesPath}")) {
			String imagesPath = WebAppConfig.class.getClassLoader().getResource("").getPath();
			if (imagesPath.indexOf(".jar") > 0) {
				imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
			} else if (imagesPath.indexOf("classes") > 0) {
				imagesPath = "file:" + imagesPath.substring(0, imagesPath.indexOf("classes"));
			}
			imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/")) + "/images/";
			operatorImagesPath = imagesPath;
		}
		LoggerFactory.getLogger(WebAppConfig.class).info("imagesPath=" + operatorImagesPath+"/");
		registry.addResourceHandler("/images/**").addResourceLocations(operatorImagesPath+"/");
		super.addResourceHandlers(registry);
	}
}