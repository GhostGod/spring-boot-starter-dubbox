package com.hiersun.boot.autoconfigure.dubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.alibaba.dubbo.config.spring.AnnotationBean;

/**
 * 向spring注入dubbo的AnnotationBean，然后扫描dubbo服务所在的包
 * @author liuyang
 * @email y_liu@hiersun.com | 745089707@qq.com
 */
public class DubboConfigurationApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	private final static Logger logger = LoggerFactory.getLogger(DubboConfigurationApplicationContextInitializer.class);

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		Environment env = applicationContext.getEnvironment();
		String scan = env.getProperty("spring.dubbo.scan.package");
		logger.info("spring.dubbo.scan.package={}", scan);
		if (scan != null) {
			AnnotationBean scanner = BeanUtils.instantiate(AnnotationBean.class);
			scanner.setPackage(scan);
			scanner.setApplicationContext(applicationContext);
			applicationContext.addBeanFactoryPostProcessor(scanner);
			applicationContext.getBeanFactory().addBeanPostProcessor(scanner);
			applicationContext.getBeanFactory().registerSingleton("annotationBean", scanner);
		}

	}

}
