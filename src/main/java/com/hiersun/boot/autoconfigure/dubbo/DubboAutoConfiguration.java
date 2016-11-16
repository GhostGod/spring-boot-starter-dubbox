package com.hiersun.boot.autoconfigure.dubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;

/**
 * dubbo注解配置
 * @author liuyang
 * @email y_liu@hiersun.com | 745089707@qq.com
 */
@Configuration
@EnableConfigurationProperties({ DubboBaseProperties.class })
public class DubboAutoConfiguration {

	private final static Logger logger = LoggerFactory.getLogger(DubboAutoConfiguration.class);

	@Autowired
	private DubboBaseProperties properties;

	@Bean
	public ApplicationConfig application() {
		ApplicationConfig application = properties.getApplication();
		if (application == null) {
			application = new ApplicationConfig("dubbo");
			properties.setApplication(application);
		}
		logger.info("{}", properties.getApplication());
		return properties.getApplication();
	}

	@Bean
	public RegistryConfig registry() {
		RegistryConfig registry = properties.getRegistry();
		if (registry == null) {
			registry = new RegistryConfig("N/A");
			properties.setRegistry(registry);
		}
		logger.info("{}", properties.getRegistry());
		return properties.getRegistry();
	}

	@Bean
	public ProtocolConfig protocol() {
		ProtocolConfig protocol = properties.getProtocol();
		if (protocol == null) {
			protocol = new ProtocolConfig("dubbo", 20880);
			properties.setProtocol(protocol);
		}
		logger.info("{}", properties.getProtocol());
		return properties.getProtocol();
	}
}
