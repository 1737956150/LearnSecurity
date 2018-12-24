package com.zzg.validate.code;

import com.zzg.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @classname ValidateCodeFilter
 * @desc TODO
 * @author: zzg
 * @date: 2018/12/21 9:21
 * InitializingBean: 实现这个接口的目的是 在其他参数组装完毕后 去初始化urls的值
 */
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean{

    private AuthenticationFailureHandler authenticationFailureHandler;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    private Set<String> urls = new HashSet<>();// 存储配置需要拦截的url

    private SecurityProperties securityProperties;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        String[] configUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCode().getImage().getUrl(),",");
        for(String configUrl : configUrls){
            urls.add(configUrl);
        }
        urls.add("/authentication/from");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        boolean action = false;
        for (String url : urls){
            if (antPathMatcher.match(url,httpServletRequest.getRequestURI())){
                action=true;
            }
        }
        if(action){
            try {
                vaidate(new ServletWebRequest(httpServletRequest));
            }catch (ValidateCodeException e){
                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
                return;
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    private void vaidate(ServletWebRequest servletWebRequest) throws ServletRequestBindingException {
        ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(servletWebRequest,
                ValidateCodeController.SESSION_KEY);
        String codeInRequest = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(), "imageCode");
        if(StringUtils.isBlank(codeInRequest)){
            throw new ValidateCodeException("验证码的值不能为空");
        }
        if(codeInSession==null){
            throw new ValidateCodeException("验证码不存在");
        }
        if(codeInSession.isExpried()){
            sessionStrategy.removeAttribute(servletWebRequest,ValidateCodeController.SESSION_KEY);
            throw new ValidateCodeException("验证码已过期");
        }
        if(!StringUtils.equals(codeInSession.getCode(),codeInRequest)){
            throw new ValidateCodeException("验证码不匹配");
        }
        sessionStrategy.removeAttribute(servletWebRequest,ValidateCodeController.SESSION_KEY);
    }

    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return authenticationFailureHandler;
    }

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    public SessionStrategy getSessionStrategy() {
        return sessionStrategy;
    }

    public void setSessionStrategy(SessionStrategy sessionStrategy) {
        this.sessionStrategy = sessionStrategy;
    }

    public Set<String> getUrls() {
        return urls;
    }

    public void setUrls(Set<String> urls) {
        this.urls = urls;
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
