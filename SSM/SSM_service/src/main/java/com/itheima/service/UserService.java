package com.itheima.service;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRole(String id);

    void addRoleToUser(String userId, String[] roleIds);
}
