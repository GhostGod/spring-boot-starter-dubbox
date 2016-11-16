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
		logger.info("{}", properties.getApplication());
		return properties.getApplication();
	}

	@Bean
	public RegistryConfig registry() {
		logger.info("{}", properties.getRegistry());
		return properties.getRegistry();
	}

	@Bean
	public ProtocolConfig protocol() {
		logger.info("{}", properties.getProtocol());
		return properties.getProtocol();
	}
}
