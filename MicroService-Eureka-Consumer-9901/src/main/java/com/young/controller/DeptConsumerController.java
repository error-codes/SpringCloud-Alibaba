package com.young.controller;

import com.young.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/25 17:42
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {

    // 这种方式是直调用服务方的方法，根本没有用到 Spring Cloud
//    private static final String REST_URL_PROVIDER_PREFIX = "http://localhost:8001/";

    // 面向微服务编程，即通过微服务的名称来获取调用地址
    private static final String REST_URL_PROVIDER_PREFIX = "http://MICROSERVICE-EUREKA-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/selectByPrimaryKey/{id}")
    public Dept selectByPrimaryKey(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/dept/selectByPrimaryKey/" + id, Dept.class);
    }

    @RequestMapping(value = "/selectAll")
    public List<Dept> selectAll() {
        return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/dept/selectAll", List.class);
    }
}
