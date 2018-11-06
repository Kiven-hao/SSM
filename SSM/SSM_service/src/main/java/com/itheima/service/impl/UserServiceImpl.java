package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            System.out.println("nihao");
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(userInfo.getUsername(),
                userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false : true, true, true,
                true, getAuthority(userInfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    public List<UserInfo> findAll() throws Exception{
        //System.out.println(userDao.findAll().size()+"-----------------=======");
        return userDao.findAll();
    }

    public void save(UserInfo userInfo) throws Exception{
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    public List<Role> findOtherRole(String id) {
        return userDao.findOtherRole(id);
    }

    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId, roleId);
        }
    }
}
