package com.young.controller;

import com.young.entity.Dept;
import com.young.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/25 15:24
 */
@RestController
@RequestMapping("/dept")
@Slf4j
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/selectByPrimaryKey/{id}", method = RequestMethod.GET)
    public Dept selectByPrimaryKey(@PathVariable int id) {
        return deptService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<Dept> selectAll() {
        return deptService.selectAll();
    }

    @RequestMapping(value = "/timeout", method = RequestMethod.GET)
    public String timeout() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "服务提供者超时 5 秒后，请求成功";
    }
}
