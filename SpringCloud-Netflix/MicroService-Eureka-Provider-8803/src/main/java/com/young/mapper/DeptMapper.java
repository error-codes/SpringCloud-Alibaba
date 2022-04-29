package com.young.mapper;

import com.young.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/25 14:29
 */
@Mapper
public interface DeptMapper {

    Dept selectByPrimaryKey(Integer deptNo);

    List<Dept> selectAll();
}
