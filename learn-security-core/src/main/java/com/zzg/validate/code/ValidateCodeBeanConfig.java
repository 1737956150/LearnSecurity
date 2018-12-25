package com.zzg.validate.code;

import com.zzg.properties.SecurityProperties;
import com.zzg.validate.code.image.ImageCondeGenerator;
import com.zzg.validate.code.sms.DefaultSmsCodeSender;
import com.zzg.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @classname ValidateCodeBeanConfig
 * @desc TODO ConditionalOnMissingBean 当拥有这个bean时使用。没有就用下面的逻辑
 * @author: zzg
 * @date: 2018/12/24 14:02
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name="imageValidateCodeGenerator") // 不存在imageCodeGenerator的bean的时候才用下面的配置
    public ValidateCodeGenerator imageValidateCodeGenerator(){
        ImageCondeGenerator imageCondeGenerator = new ImageCondeGenerator();
        imageCondeGenerator.setSecurityProperties(securityProperties);
        return imageCondeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class) //和上面效果一样。 如果找到该接口的实现就不会调用下面的方法
    public SmsCodeSender smsCodeSender(){
        return new DefaultSmsCodeSender();
    }
}
