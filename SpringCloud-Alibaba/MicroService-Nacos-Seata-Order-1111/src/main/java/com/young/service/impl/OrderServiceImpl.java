package com.young.service.impl;

import com.young.entity.Order;
import com.young.entity.YoungResult;
import com.young.mapper.OrderMapper;
import com.young.service.AccountService;
import com.young.service.OrderService;
import com.young.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/7 18:33
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    public YoungResult<?> create(Order order) {
        log.info(" ------>>> 开始新建订单");
        order.setUserId(1L);
        order.setStatus(0);
        orderMapper.create(order);

        log.info(" ------>>> 订单服务开始调用库存服务，开始扣减库存");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info(" ------>>> 订单服务调用库存服务，扣减库存结束");

        log.info(" ------>>> 订单服务开始调用账户服务，开始扣减账户余额");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info(" ------>>> 订单服务调用库存服务，扣减账户余额结束");

        log.info(" ------>>> 修改订单状态开始");
        orderMapper.update(order.getUserId(), 0);
        log.info(" ------>>> 修改订单状态结束");

        log.info(" ------>>> 订单创建完成");

        return new YoungResult<>(200, "订单创建成功");
    }
}
