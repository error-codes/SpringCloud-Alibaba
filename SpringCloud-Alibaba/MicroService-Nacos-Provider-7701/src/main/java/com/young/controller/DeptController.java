package com.young.controller;

import com.young.entity.Dept;
import com.young.entity.YoungResult;
import com.young.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/5 10:15
 */
@Slf4j
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DeptService deptService;

    @GetMapping("/nacos/{id}")
    public String getPayment(@PathVariable Integer id) {
        return "<h2>Young.Net 提醒您, 服务访问成功!<h2>服务名: MicroService-Nacos-Provider<br/>端口号: "
                + serverPort + "<br/>传入参数: " + id;
    }
}
