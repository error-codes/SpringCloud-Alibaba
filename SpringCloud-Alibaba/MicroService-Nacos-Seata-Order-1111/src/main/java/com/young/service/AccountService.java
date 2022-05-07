package com.young.service;

import com.young.entity.YoungResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/7 18:30
 */
@FeignClient("MicroService-Nacos-Seata-Account-3333")
public interface AccountService {

    @PostMapping("/account/decrease")
    YoungResult<?> decrease(Long userId, BigDecimal money);
}
