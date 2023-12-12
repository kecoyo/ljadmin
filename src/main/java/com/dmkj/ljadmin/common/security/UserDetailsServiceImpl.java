package com.dmkj.ljadmin.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dmkj.ljadmin.common.exception.BadRequestException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserCacheManager userCacheManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUserDetails userDetails = userCacheManager.getUserCache(username);
        if (userDetails == null) {
            throw new BadRequestException("账号未激活！");
        }
        return userDetails;
    }

}
