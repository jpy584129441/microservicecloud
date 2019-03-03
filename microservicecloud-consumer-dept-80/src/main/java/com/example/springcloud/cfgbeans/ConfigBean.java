package com.example.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//boot-->spring  applicationContext.xml---@Configuration配置  ConfigBean=applicationContext.xml
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        //return new RandomRule();//达到的目的，用我们重新选择的随机算法计算默认的轮询
        return new RetryRule();
    }
}
//    @Bean
//    public UserService getUserService(){
//        return new UserServiceImpl();
//    }
//    applicationContext.xml == ConfigBean(@Configuration)
//    <bean id="userService" class=""com.example.tmall.UserServiceImpl">
