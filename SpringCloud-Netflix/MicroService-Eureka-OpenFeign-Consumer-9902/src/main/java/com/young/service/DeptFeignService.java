package com.young.service;

import com.young.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/27 14:22
 */
@Component
@FeignClient("MICROSERVICE-EUREKA-PROVIDER")
public interface DeptFeignService {

    @RequestMapping(value = "/dept/selectByPrimaryKey/{id}", method = RequestMethod.GET)
    Dept selectByPrimaryKey(@PathVariable int id);

    @RequestMapping(value = "/dept/selectAll", method = RequestMethod.GET)
    List<Dept> selectAll();

    @RequestMapping(value = "/dept/timeout", method = RequestMethod.GET)
    String timeout();
}
