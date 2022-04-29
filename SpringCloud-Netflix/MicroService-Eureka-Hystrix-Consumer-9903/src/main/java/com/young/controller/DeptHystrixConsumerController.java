package com.young.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.young.service.DeptHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/26 18:00
 */
@Slf4j
@RestController
@RequestMapping("/consumer/dept")
@DefaultProperties(defaultFallback = "deptGlobalFallbackMethod")
public class DeptHystrixConsumerController {

    @Autowired
    private DeptHystrixService deptHystrixService;


    @RequestMapping(value = "/hystrix/deptOk/{id}")
    public String deptOk(@PathVariable Integer id) {
        return deptHystrixService.deptOk(id);
    }

    @RequestMapping(value = "/hystrix/deptTimeout/{id}")
    @HystrixCommand(fallbackMethod = "deptTimeoutHandler")
    public String deptTimeout(@PathVariable Integer id) {
        return deptHystrixService.deptTimeout(id);
    }

    @RequestMapping(value = "/hystrix/deptGlobalTimeout/{id}")
    @HystrixCommand
    public String deptGlobalTimeout(@PathVariable Integer id) {
        return deptHystrixService.deptTimeout(id);
    }

    public String deptTimeoutHandler(@PathVariable Integer id) {
        log.info("deptTimeout 出错，服务已被降级！");
        return "Young.Net 提醒您：服务端系统繁忙，请稍后再试！（客户端 deptTimeout 专属的回退方法触发）";
    }

    public String deptGlobalFallbackMethod() {
        return "Young.Net 提醒您，运行出错或服务端系统繁忙，请稍后再试！（客户端全局回退方法触发）";
    }
}
