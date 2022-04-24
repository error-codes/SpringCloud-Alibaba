package com.young.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/24 17:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {

    private Integer deptNo;

    private String deptName;

    private String dbSource;
}
