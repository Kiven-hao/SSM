package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.OrdersDao;
import com.itheima.domain.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    public List<Orders> findAll(Integer page, Integer pageSize)throws Exception {
        PageHelper.startPage(page, pageSize);
        System.out.println("service 查询所有");
        return ordersDao.findAll();
    }

    public List<Orders> findAllByPage(Integer page, Integer pageSize) throws Exception {

        return ordersDao.findAll();
    }

    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
