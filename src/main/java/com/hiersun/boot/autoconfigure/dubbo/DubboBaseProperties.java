package com.hiersun.boot.autoconfigure.dubbo;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;

/**
 * dubbox基本配置属性 <br><br>
 * application : 应用配置，用于配置当前应用信息，不管该应用是提供者还是消费者。<br>
 * registry : 注册中心配置，用于配置连接注册中心相关信息。<br>
 * protocol : 协议配置，用于配置提供服务的协议信息，协议由提供方指定，消费方被动接受。<br>
 * @author liuyang
 * @email y_liu@hiersun.com | 745089707@qq.com
 */
@ConfigurationProperties("spring.dubbo")
public class DubboBaseProperties {

	/**
	 * 应用配置，用于配置当前应用信息，不管该应用是提供者还是消费者。
	 */
	private ApplicationConfig application;
	/**
	 * 注册中心配置，用于配置连接注册中心相关信息。
	 */
	private RegistryConfig registry;
	/**
	 * 协议配置，用于配置提供服务的协议信息，协议由提供方指定，消费方被动接受。
	 */
	private ProtocolConfig protocol;

	public ApplicationConfig getApplication() {
		return application;
	}

	public void setApplication(ApplicationConfig application) {
		this.application = application;
	}

	public RegistryConfig getRegistry() {
		return registry;
	}

	public void setRegistry(RegistryConfig registry) {
		this.registry = registry;
	}

	public ProtocolConfig getProtocol() {
		return protocol;
	}

	public void setProtocol(ProtocolConfig protocol) {
		this.protocol = protocol;
	}

}
