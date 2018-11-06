package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    public List<com.itheima.domain.Role> findAll() {
        return roleDao.findAll();
    }

    public void save(com.itheima.domain.Role role) throws Exception {
        roleDao.save(role);
    }

    public List findOtherRole(String id) {
        return roleDao.findOtherRole(id);
    }


}
