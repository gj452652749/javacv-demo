package org.gj.cv.operator;

import org.gj.util.ContextUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 享元模式算子工厂
 * @author gaojun
 *
 */
@Component
public class OperatorFactory implements ApplicationContextAware{


	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (OperatorFactory.applicationContext == null) {
			OperatorFactory.applicationContext = applicationContext;
		}
		System.out.println("---------------------------------------------------------------------");

		System.out.println("---------------------------------------------------------------------");

		System.out.println(
				"---------------me.shijunjie.util.SpringUtil------------------------------------------------------");

		System.out.println(
				"========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象,applicationContext="
						+ OperatorFactory.applicationContext + "========");

		System.out.println("---------------------------------------------------------------------");
	}

	// 获取applicationContext
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	// 通过name获取 Bean.
	public Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	// 通过class获取Bean.
	public <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	// 通过name,以及Clazz返回指定的Bean
	public <T> T getBean(String name, Class<T> clazz) {
		return getApplicationContext().getBean(name, clazz);
	}

}
