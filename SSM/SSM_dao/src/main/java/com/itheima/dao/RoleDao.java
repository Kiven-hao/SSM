package com.itheima.dao;

import com.itheima.domain.Member;
import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {

    @Select("select * from member where id=#{id}")
    public Member findById(String id) throws Exception;
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,
                    many = @Many(select = "com.itheima.dao.PermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;


    @Select("select * from role")
    public List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public void save(Role role);


    List findOtherRole(String id);
}