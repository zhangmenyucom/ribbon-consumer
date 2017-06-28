package com.taylor.service;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/28 17:21
 */
public class UserCommand extends HystrixCommand {
    private RestTemplate restTemplate;
    private long id;
    public UserCommand(Setter setter,RestTemplate restTemplate,long id){
        super(setter);
        this.restTemplate=restTemplate;
        this.id=id;
    }
    @Override
    protected String run() throws Exception {
        return restTemplate.getForObject("http://USER-SERVICE/users{1}",String.class,id);
    }
}
