package com.wjy.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    private int total = 0;
    private int currentIndex = 0;

    @Override
    public Server choose(Object o) {
        ILoadBalancer lb = this.getLoadBalancer();
        if (lb == null) {
            return null;
        } else {
            Server server = null;


            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                if (total < 5) {
                    server = upList.get(currentIndex);
                    total ++;
                } else {
                    currentIndex ++;
                    total = 0;
                    if (currentIndex >= upList.size()) {
                        currentIndex = 0;
                    }
                }

                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

}
