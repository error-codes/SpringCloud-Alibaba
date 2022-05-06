package com.young.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.degrade.circuitbreaker.CircuitBreaker;
import com.alibaba.csp.sentinel.slots.block.degrade.circuitbreaker.CircuitBreakerStrategy;
import com.alibaba.csp.sentinel.slots.block.degrade.circuitbreaker.EventObserverRegistry;
import com.alibaba.csp.sentinel.util.TimeUtil;
import com.young.entity.Dept;
import com.young.entity.YoungResult;
import com.young.service.DeptFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/5 10:36
 */
@RestController
@RequestMapping("/dept/consumer")
public class DeptConsumerController {

    @Resource
    private DeptFeignService deptFeignService;

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping("/nacos/feign/selectByPrimaryKey/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallBack")
    public YoungResult<Dept> selectByPrimaryKey(@PathVariable int id) {
        initDegradeRule();
        monitor();
        System.out.println("---------->>>> 主业务逻辑");
        YoungResult<Dept> deptYoungResult = deptFeignService.selectByPrimaryKey(id);

        if (id == 6) {
            System.err.println("---------->>>> 主业务逻辑，抛出非法参数异常");
            throw new IllegalArgumentException("IllegalArgumentException: 非法参数异常......");
        } else if (deptYoungResult.getData() == null) {
            System.err.println("---------->>>> 主业务逻辑，抛出空指针异常");
            throw new NullPointerException("NullPointerException: 该 ID 没有对应记录，空指针异常......");
        }
        return deptYoungResult;
    }

    @GetMapping("/nacos/feign/selectAll")
    public YoungResult<List<Dept>> selectAll() {
        return deptFeignService.selectAll();
    }

    public YoungResult<Dept> handlerFallBack(@PathVariable int id, Throwable throwable) {
        System.err.println("---------->>>> 服务降级逻辑");
        return new YoungResult<>(444, "Young.Net 提醒您，服务已被降级！异常信息: " + throwable.getMessage(),
                new Dept(id, null, null));
    }

    public void monitor() {
        EventObserverRegistry.getInstance().addStateChangeObserver("logging",
                (prevState, newState, rule, snapshotValue) -> {
                    if (newState == CircuitBreaker.State.OPEN) {
                        System.err.printf("%s -> OPEN at %s, 发送请求次数=%.2f%n", prevState.name(),
                                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), snapshotValue);
                    } else {
                        System.err.printf("%s -> %s at %s%n", prevState.name(), newState.name(),
                                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                    }
                });
    }

    private static void initDegradeRule() {
        List<DegradeRule> rules = new ArrayList<>();
        DegradeRule degradeRule = new DegradeRule("fallback");
        degradeRule.setGrade(CircuitBreakerStrategy.ERROR_RATIO.getType());
        degradeRule.setCount(0.7);
        degradeRule.setMinRequestAmount(100);
        degradeRule.setStatIntervalMs(30000);
        degradeRule.setTimeWindow(10);
        rules.add(degradeRule);
        DegradeRuleManager.loadRules(rules);
    }
}
