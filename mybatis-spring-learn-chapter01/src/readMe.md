## 一、SpringMvc 工程搭建主要流程
- 1.pom.xml 引入依赖的jar
- 2.添加基础配置文件
    - jdbc.properties
    - app.properties
    
- 3.配置applicationContext.xml 包含下面子文件
  - dataSource: applicationDataSource.xml
  - service: applicationService.xml
  - web: applicationWeb.xml
  - configuration: applicationConfig.xml
- 4.配置web.xml
- 5.书写Controller、Service、Domain相关信息


## 二、扫描mybatis mapper 接口方式
- xml文件中进行配置
```xml
<bean id="mapperScannerConfigurer" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="sqlSessionFactoryBeanName" value="sqlSessionFactoryBean" />
    <property name="basePackage" value="com.ityongman.dao.mapper" />
</bean>
```
- 引入 mybatis-spring xsd 配置 http://mybatis.org/schema/mybatis-spring
```xml
<mybatis:scan base-package="com.ityongman.dao.mapper" />
```

- 注解驱动, @MapperScan 、@MapperScans
```java
@Configuration
@MapperScan("com.ityongman.dao.mapper")
    public class MapperConfig {
}
```