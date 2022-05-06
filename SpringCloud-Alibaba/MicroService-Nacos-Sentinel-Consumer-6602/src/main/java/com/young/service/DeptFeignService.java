package com.young.service;

import com.young.entity.Dept;
import com.young.entity.YoungResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/5 15:49
 */
@Component
@FeignClient(value = "MicroService-Nacos-Sentinel-Provider")
public interface DeptFeignService {

    @GetMapping("/dept/selectByPrimaryKey/{id}")
    YoungResult<Dept> selectByPrimaryKey(@PathVariable int id);

    @GetMapping("/dept/selectAll")
    YoungResult<List<Dept>> selectAll();
}
