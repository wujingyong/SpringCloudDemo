package com.wjy.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @Autowired
    SampleRedisConfig sampleRedisConfig;

    @RequestMapping("/test")
    public String test() {
        int timeout = sampleRedisConfig.getTimeout();
        System.out.println(timeout);
        return "success";
    }
}
