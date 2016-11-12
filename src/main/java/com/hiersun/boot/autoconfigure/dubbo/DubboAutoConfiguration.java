package com.hiersun.boot.autoconfigure.dubbo;

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

	@Autowired
	private DubboBaseProperties properties;

	@Bean
	public ApplicationConfig application() {
		return properties.getApplication();
	}

	@Bean
	public RegistryConfig registry() {
		return properties.getRegistry();
	}

	@Bean
	public ProtocolConfig protocol() {
		return properties.getProtocol();
	}
}
