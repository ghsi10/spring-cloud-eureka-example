package com.configs;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class LoadBalanceConfig {

    @Bean
    @LoadBalanced
    @Qualifier("loadBalance")
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public IRule ribbonRule() {
        //return new BestAvailableRule();
        return new AvailabilityFilteringRule();
    }

    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }

}