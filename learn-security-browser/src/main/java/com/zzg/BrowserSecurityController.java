package com.zzg;

import com.zzg.properties.SecurityProperties;
import com.zzg.support.SimpleResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @classname BrowserSecurityController
 * @desc TODO
 * @author: zzg
 * @date: 2018/12/20 8:53
 */
@RestController
public class BrowserSecurityController {

    private Logger log = LoggerFactory.getLogger(BrowserSecurityController.class);

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * @MethodName requireAuthentication
     * @Description //TODO  当需要身份认证的时候跳转到这里
     * @Param [request, response]
     * @Return java.lang.String
     * @Author zzg
     * @Date 8:55 2018/12/20
     **/
    @RequestMapping("/authentication/require")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if(savedRequest!=null){
            String redirectUrl = savedRequest.getRedirectUrl();
            log.info("引发跳转的请求Url:{}",redirectUrl);
            if(StringUtils.endsWithIgnoreCase(redirectUrl,".html")){
                System.out.println(securityProperties.getBrowser().getLoginPage());
                redirectStrategy.sendRedirect(request,response,securityProperties.getBrowser().getLoginPage());
            }
        }
        return new SimpleResponse("访问的服务需要身份认证。请引导用户到登录页");
    }

    @RequestMapping("/test")
    public String test(){
        return "learn-security-browser";
    }
}
