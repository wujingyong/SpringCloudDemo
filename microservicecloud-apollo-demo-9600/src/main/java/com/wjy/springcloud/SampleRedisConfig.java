package com.wjy.springcloud;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

@ConfigurationProperties
@Data
public class SampleRedisConfig {
    @ApolloConfig
    private Config config;
    private int timeout;

    @ApolloConfigChangeListener
    private void anotherOnChange(ConfigChangeEvent changeEvent) {
        if (changeEvent.isChanged("timeout")) {
            this.timeout = config.getIntProperty("timeout",200);
        }

    }
}
