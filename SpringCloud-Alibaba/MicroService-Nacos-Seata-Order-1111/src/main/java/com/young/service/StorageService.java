package com.young.service;

import com.young.entity.YoungResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/7 16:34
 */
@FeignClient("MicroService-Nacos-Seata-Storage-2222")
public interface StorageService {

    @PostMapping("/storage/decrease")
    YoungResult<?> decrease(Long productId, Integer count);
}
