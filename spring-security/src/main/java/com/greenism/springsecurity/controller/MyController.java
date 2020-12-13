package com.greenism.springsecurity.controller;

import com.greenism.springsecurity.bean.TUser;
import com.greenism.springsecurity.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class MyController {
    @Autowired
    private TUserService tUserService;

    @RequestMapping(value = "/getUser")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<TUser> getUser(String username)
    {
        return tUserService.getUser(username);
    }

    @RequestMapping(value = "getUserInfo")
    public String getUserInfo(){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails)principal;
            return userDetails.toString();
        }
        else {
            return principal.toString();
        }
    }
}
