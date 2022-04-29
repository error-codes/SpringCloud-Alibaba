package com.young.service;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/27 17:35
 */
public interface DeptService {

    String deptOk(Integer id);

    String deptCircuitBreaker(Integer id);

    String deptTimeout(Integer id);
}
