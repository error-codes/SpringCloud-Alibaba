package com.young.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/7 16:34
 */
@FeignClient("MicroService-Nacos-Seata-Order-1111")
public interface StorageService {
}
