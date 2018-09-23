package com.wjy.springcloud;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import com.wjy.myrule.MyRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class cfgbeans {
    /**
     * 也可以在SpringBootApplication中使用如下注解
     * @RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = MyRule.class)
     */
   /* @Bean
    public IRule iRule() {
        return new MyRule();
    }*/
}
