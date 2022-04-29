package com.young.controller;

import com.young.entity.Dept;
import com.young.service.DeptFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/27 14:25
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptFeignConsumerController {

    @Autowired
    private DeptFeignService deptFeignService;

    @RequestMapping(value = "/selectByPrimaryKey/{id}", method = RequestMethod.GET)
    public Dept selectByPrimaryKey(@PathVariable int id) {
        return deptFeignService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<Dept> selectAll() {
        return deptFeignService.selectAll();
    }

    @RequestMapping(value = "/timeout", method = RequestMethod.GET)
    public String timeout() {
        return deptFeignService.timeout();
    }
}
