package com.zzg.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzg.properties.LoginType;
import com.zzg.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @classname MyAuthenticationFailure
 * @desc TODO
 * @author: zzg
 * @date: 2018/12/20 15:23
 */
@Component("myAuthenticationFailureHandler")
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{

    private Logger log = LoggerFactory.getLogger(MyAuthenticationFailureHandler.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        AuthenticationException e) throws IOException, ServletException {
        log.info("登录失败");

        if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(e));
        }else{
            super.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
        }
    }
}
