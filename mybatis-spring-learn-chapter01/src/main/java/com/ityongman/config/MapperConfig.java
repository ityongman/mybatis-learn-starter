package com.ityongman.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author shedunze
 * @Date 2021/9/10 11:07 上午
 * @Description 方式三 扫描 dao层 mybatis mapper接口配置
 */
@Configuration
@MapperScan("com.ityongman.dao.mapper")
public class MapperConfig {
}
