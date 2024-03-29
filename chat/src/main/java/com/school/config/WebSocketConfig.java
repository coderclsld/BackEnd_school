package com.school.config;

import com.school.util.RedisUtil;
import com.school.controller.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.annotation.Resource;

@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

    @Resource
    public void setRedisUtil (RedisUtil redisUtil){
        WebSocketServer.redisUtil = redisUtil;
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String,Object> redisTemplate){
        WebSocketServer.redisTemplate = redisTemplate;
    }
}
