package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo=userService.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show1");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<UserInfo> usersInfo=userService.findAll();
        System.out.println(usersInfo.size());
        mv.addObject("userList", usersInfo);
        mv.setViewName("user-list");
        return mv;
    }
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required=true) String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        List<Role> roleList = userService.findOtherRole(id);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public ModelAndView addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds) {
        userService.addRoleToUser(userId, roleIds);
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    //@RequestMapping("/addRoleToUser.do")

}
