package com.xgx.security.service.impl;

import java.util.HashSet;
import java.util.Set;
import com.xgx.security.model.User;
import com.xgx.security.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class SysUserServiceImpl implements UserService {

    @Override
    public User findByUsername(String username) {
        User user = new User();
        user.setId(1L);
        user.setUsername(username);
        String password = new BCryptPasswordEncoder().encode("123");
        user.setPassword(password);
        return user;
    }

    @Override
    public Set<String> findPermissions(String username) {
        Set<String> permissions = new HashSet<>();
        permissions.add("sys:user:view");
        permissions.add("sys:user:add");
        permissions.add("sys:user:edit");
        permissions.add("sys:user:delete");
        return permissions;
    }

}