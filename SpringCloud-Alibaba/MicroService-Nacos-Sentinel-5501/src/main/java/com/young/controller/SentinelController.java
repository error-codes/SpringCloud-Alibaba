package com.young.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/5 11:45
 */
@RestController
@Slf4j
public class SentinelController {

    @Value("${server.port}")
    private String serverPort;

    public static void initFlowRules() {
        List<FlowRule> ruleList = new ArrayList<>();
        FlowRule flowRule = new FlowRule();
        flowRule.setResource("testEResource");
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setCount(2);
        ruleList.add(flowRule);
        FlowRuleManager.loadRules(ruleList);
    }

    @GetMapping("/testA")
    public String testA() {
        return testABySphU();
    }

    @GetMapping("/testB")
    public String testB() {
        return testBBySphO();
    }

    @GetMapping("/testC")
    @SentinelResource("testCByAnnotation")
    public String testC() {
        log.info("Young.Net 提醒您, 服务访问成功 ------ testC: " + serverPort);
        return "Young.Net 提醒您, 服务访问成功 ------ testC: " + serverPort;
    }

    @GetMapping("/testD")
    @SentinelResource(value = "testDResource", blockHandler = "testDBlockHandler")
    public String testD() {
        log.info("Young.Net 提醒您, 服务访问成功 ------ testD: " + serverPort);
        return "Young.Net 提醒您, 服务访问成功 ------ testD: " + serverPort;
    }

    @GetMapping("/testE")
    @SentinelResource(value = "testEResource", blockHandler = "testEBlockHandler")
    public String testE() {
        initFlowRules();
        log.info("Young.Net 提醒您, 服务访问成功 ------ testD: " + serverPort);
        return "Young.Net 提醒您, 服务访问成功 ------ testD: " + serverPort;
    }

    public String testABySphU() {
        Entry entry = null;

        try {
            entry = SphU.entry("testABySphU");
            log.info("Young.Net 提醒您, 服务访问成功 ------ testA: " + serverPort);
            return "Young.Net 提醒您, 服务访问成功 ------ testA: " + serverPort;
        } catch (BlockException e) {
            log.info("Young.Net 提醒您, testA 服务被限流");
            return "Young.Net 提醒您, testA 服务被限流";
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }

    public String testBBySphO() {
        if (SphO.entry("testBBySphO")) {
            try {
                log.info("Young.Net 提醒您, 服务访问成功 ------ testB: " + serverPort);
                return "Young.Net 提醒您, 服务访问成功 ------ testB: " + serverPort;
            } finally {
                SphO.exit();
            }
        } else {
            log.info("Young.Net 提醒您, testB 服务被限流");
            return "Young.Net 提醒您, testB 服务被限流";
        }
    }

    public String testDBlockHandler(BlockException exception) {
        log.info(Thread.currentThread().getName() + " Young.Net 提醒您, testD 服务访问已经失败! 您当前已被限流, 请稍侯重试");
        return  " Young.Net 提醒您, testD 服务访问已经失败! 您当前已被限流, 请稍侯重试";
    }

    public String testEBlockHandler(BlockException exception) {
        log.info(Thread.currentThread().getName() + " Young.Net 提醒您, testE 服务访问已经失败! 您当前已被限流, 请稍侯重试");
        return  " Young.Net 提醒您, testE 服务访问已经失败! 您当前已被限流, 请稍侯重试";
    }
}
