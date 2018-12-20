package com.zzg;

import com.zzg.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @classname SecurityConfig
 * @desc TODO
 * @author: zzg
 * @date: 2018/12/20 14:22
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityConfig {

}
