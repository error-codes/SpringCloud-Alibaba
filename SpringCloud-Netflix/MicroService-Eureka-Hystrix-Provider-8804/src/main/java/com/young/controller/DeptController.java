package com.young.controller;

import com.young.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/27 17:45
 */
@RestController
@Slf4j
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/dept/hystrix/deptOk/{id}")
    public String deptOk(@PathVariable Integer id) {
        String result = deptService.deptOk(id);
        log.info("端口号: " + serverPort + " result:" + result);
        return result + ", 端口号: " + serverPort;
    }

    @RequestMapping(value = "/dept/hystrix/deptCircuitBreaker/{id}")
    public String deptCircuitBreaker(@PathVariable Integer id) {
        String result = deptService.deptCircuitBreaker(id);
        log.info("端口号: " + serverPort + " result:" + result);
        return result + ", 端口号: " + serverPort;
    }

    @RequestMapping(value = "/dept/hystrix/deptTimeout/{id}")
    public String deptTimeout(@PathVariable Integer id) {
        String result = deptService.deptTimeout(id);
        log.info("端口号: " + serverPort + " result:" + result);
        return result + ", 端口号: " + serverPort;
    }
}
