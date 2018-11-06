package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    /*@RequestMapping("/findAll.do")
    public ModelAndView findAll(*//*@RequestParam(name = "page", required = true, defaultValue =
            "1") Integer page, @RequestParam(name = "pageSize", required = true, defaultValue = "10")
            Integer pageSize*//*) throws Exception {
        System.out.println("查询所有");
        List<Orders> ordersList = ordersService.findAll();
        for (Orders orders : ordersList) {
            System.out.println(orders);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("ordersList", ordersList);
        mv.setViewName("orders-list");
        return mv;
    }*/
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue =
            "1") Integer page, @RequestParam(name = "pageSize", required = true, defaultValue = "4")
            Integer pageSize) throws Exception {

        List<Orders> ordersList = ordersService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }


    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
