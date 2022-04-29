package com.young.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.young.service.DeptService;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/27 17:36
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Override
    public String deptOk(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "  deptOk(), ID: " + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "deptCircuitBreakerFallBack",
            commandProperties = {
                    // 开启熔断器
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    // 统计时间窗
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "5000"),
                    // 统计时间窗内请求次数
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    // 休眠时间窗口期
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    // 熔断触发标准，在统计时间窗口期以内，请求失败率达到 60% 时进入熔断状态
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
            })
    public String deptCircuitBreaker(Integer id) {
        if (id <= 0) {
            throw new RuntimeException("Young.Net Tips: id 不能小于等于 0, 请查看您的 id 是否正确");
        }
        return Thread.currentThread().getName() + " 调用成功, 流水号为: " + UUID.randomUUID();
    }

    @Override
    @HystrixCommand(fallbackMethod = "deptTimeoutFallBack",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
            })
    public String deptTimeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + "  deptTimeout(), ID: " + id + ", 耗时: 4s";
    }

    public String deptCircuitBreakerFallBack(Integer id) {
        return "Young.Net 提醒您，输入参数有误，ID: " + id + "，请查看后重新输入！";
    }

    public String deptTimeoutFallBack(Integer id) {
        return "Young.Net 提醒您，系统繁忙请稍后再试！" + "线程池：" + Thread.currentThread().getName() + " deptTimeout(), ID: " + id;
    }
}
