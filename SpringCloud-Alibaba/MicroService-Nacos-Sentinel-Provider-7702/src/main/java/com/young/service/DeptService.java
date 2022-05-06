package com.young.service;

import com.young.entity.Dept;

import java.util.List;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/5 14:58
 */
public interface DeptService {

    Dept selectByPrimaryKey(Integer deptNo);

    List<Dept> selectAll();
}
