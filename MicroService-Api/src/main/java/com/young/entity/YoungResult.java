package com.young.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/5 14:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class YoungResult<T> {

    private Integer code;

    private String message;

    private T data;
}
