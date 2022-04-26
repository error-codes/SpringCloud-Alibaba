package com.young.config;

import com.netflix.eureka.registry.rule.InstanceStatusOverrideRule;
import com.young.rule.YoungBalancer;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/25 17:22
 */
@Configuration
public class YoungConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ReactorServiceInstanceLoadBalancer getMyBalancer(Environment environment,
                                                            ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider) {
        String property = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new YoungBalancer(serviceInstanceListSupplierProvider, property);
    }
}
