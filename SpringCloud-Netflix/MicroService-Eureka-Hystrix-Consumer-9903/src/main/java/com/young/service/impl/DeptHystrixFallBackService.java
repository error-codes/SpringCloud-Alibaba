package com.young.service.impl;

import com.young.service.DeptHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/28 11:06
 */
@Component
public class DeptHystrixFallBackService implements DeptHystrixService {

    @Override
    public String deptOk(Integer id) {
        return "Young.Net 提醒您：服务端系统繁忙，请稍后再试！（客户端 deptOk 专属的【解耦降级】回退方法触发）";
    }

    @Override
    public String deptTimeout(Integer id) {
        return "Young.Net 提醒您：服务端系统繁忙，请稍后再试！（客户端 deptTimeout 专属【解耦降级】的回退方法触发）";
    }
}
