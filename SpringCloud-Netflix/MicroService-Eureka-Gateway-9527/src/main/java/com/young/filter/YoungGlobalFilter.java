package com.young.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/29 11:28
 */
@Component
public class YoungGlobalFilter implements GlobalFilter, Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(YoungGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        LOGGER.info("进入 Young.Net 自定义全局过滤器 YoungGlobalFilter" + LocalDate.now());
        String lover = exchange.getRequest().getQueryParams().getFirst("lover");
        if(!StringUtils.hasText(lover) || !"YuanChengRan".equalsIgnoreCase(lover)) {
            LOGGER.info("参数 lover 不能为空, 且 lover 必须是袁诚然!");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // 过滤器顺序，0 表示第一个
        return 0;
    }
}
