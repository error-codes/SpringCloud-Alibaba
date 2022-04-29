package com.young.service;

import com.young.service.impl.DeptHystrixFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/27 18:36
 */
@Component
@FeignClient(value = "MicroService-Eureka-Hystrix-Provider", fallback = DeptHystrixFallBackService.class)
public interface DeptHystrixService {

    @RequestMapping(value = "/dept/hystrix/deptOk/{id}")
    String deptOk(@PathVariable("id") Integer id);

    @RequestMapping(value = "/dept/hystrix/deptTimeout/{id}")
    String deptTimeout(@PathVariable Integer id);
}
