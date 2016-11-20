# 项目简介
基于dubbox 2.8.4和spring boot 1.4.2的自动配置module，dubbo服务全部基于注解配置，加快开发速度。

# 使用说明
### 1. clone 代码

```
git clone https://github.com/GhostGod/spring-boot-starter-dubbox.git
```

### 2. 编译安装

```
cd spring-boot-starter-dubbox
mvn clean install
```
### 3、在spring boot的pom.xml文件中加入以下依赖配置

~~~~~~~ {.xml}
    <dependency>
        <groupId>com.hiersun</groupId>
        <artifactId>spring-boot-starter-dubbox</artifactId>
        <version>1.0.RELEASE</version>
    </dependency>
~~~~~~~

### 4、然后在application.properties中加入以下配置即可

~~~~~~~ {.properties}
spring.dubbo.application.name=provider
spring.dubbo.registry.address=zookeeper://127.0.0.1:2181
spring.dubbo.protocol.name=dubbo
spring.dubbo.protocol.port=20880
#表示要扫描的package目录
spring.dubbo.scan=com.liuyang.service
~~~~~~~

详细配置可以参考com.hiersun.boot.autoconfigure.dubbo.DubboBaseProperties类的ApplicationConfig、RegistryConfig、ProtocolConfig属性

### 5、发布你的Dubbo服务,只需要添加要发布的服务实现上添加 @Service ,如下

~~~~~~~ {.java}
import com.liuyang.service.DubboxService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuyang
 * @email y_liu@hiersun.com | 745089707@qq.com
 */
@Service
@Transactional
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = DubboxService.class)
public class DubboxServiceImpl extends DubboxService {
    public void register();
}
~~~~~~~

### 6、消费你的Dubbo服务,只需要添加要发布的服务实现上添加 @Reference ,如下:

~~~~~~~ {.java}
import org.springframework.stereotype.Service;
import com.alibaba.dubbo.config.annotation.Reference;

/**
 * @author liuyang
 * @email y_liu@hiersun.com | 745089707@qq.com
 */
@Service
public class TestService {
    @Reference
    private DubboxService dubboService;
}
~~~~~~~

### 7、还看什么第七步，你已经搞定了！哥们儿！
