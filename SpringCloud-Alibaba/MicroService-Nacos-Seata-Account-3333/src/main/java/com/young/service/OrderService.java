package com.young.service;

import com.young.entity.Order;
import com.young.entity.YoungResult;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/7 16:26
 */
public interface OrderService {

    YoungResult create(Order order);
}
