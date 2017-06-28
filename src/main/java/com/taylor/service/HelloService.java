package com.taylor.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.taylor.SearchBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/28 15:22
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public SearchBean helloService() {
        return restTemplate.getForObject("http://SPC-TEST-CLIENT/test/hi?name=123213", SearchBean.class);

    }

    public SearchBean helloFallback() {
        return new SearchBean();
    }

}
