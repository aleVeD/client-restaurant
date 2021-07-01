package com.example.clientrestaurant.config;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

public class MyRule implements IRule {
    private ILoadBalancer lb;

    @Override
    public Server choose(Object o) {
        List<Server> servers = lb.getAllServers();
        Random r = new Random();
        int rand = r.nextInt(12);
        if(rand > 6){
            return getServerByPort(servers, 8081);
        }else{
            return getServerByPort(servers, 8080);
        }
    }

    private Server getServerByPort(List<Server> servers, int i) {
        for(Server s: servers){
            if(s.getPort() == i){
                return s;
            }
        }
        return null;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.lb = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.lb;
    }
}
