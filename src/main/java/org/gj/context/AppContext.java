package org.gj.context;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Configuration;
@Configuration
public class AppContext {
	AtomicInteger version=new AtomicInteger(0);

	public AtomicInteger getVersion() {
		return version;
	}
	

}
