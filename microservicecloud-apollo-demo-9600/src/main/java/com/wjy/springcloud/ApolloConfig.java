package com.wjy.springcloud;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author root
 */
@Getter
@Configuration
public class ApolloConfig {
    @Bean
    public SampleRedisConfig config() {
        return new SampleRedisConfig();
    }
}
