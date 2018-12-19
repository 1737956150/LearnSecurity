package com.zzg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @classname MyUserDetailsService
 * @desc TODO
 * @author: zzg
 * @date: 2018/12/19 16:13
 */
@Component
public class MyUserDetailsService implements UserDetailsService{

    private Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("传入的用户名字是userName:{}",username);
        return new User(username,passwordEncoder.encode("123456")
                ,true,true,true,true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

}
