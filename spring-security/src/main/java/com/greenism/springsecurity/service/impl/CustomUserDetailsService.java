package com.greenism.springsecurity.service.impl;

import com.greenism.springsecurity.bean.TUser;
import com.greenism.springsecurity.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private TUserService tUserService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        List<TUser> tUsers = tUserService.getUser(username);
        if(tUsers.size()==0)
        {
            throw new UsernameNotFoundException("用户名密码错误");
        }
        TUser tUser = tUsers.get(0);
        String role = tUser.getRole();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role));

        return new User(
                tUser.getUsername(),
                tUser.getPassword(),
                grantedAuthorities
        );
    }
}
