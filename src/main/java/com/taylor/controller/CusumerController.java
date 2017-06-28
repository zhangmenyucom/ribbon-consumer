package com.taylor.controller;

import com.taylor.SearchBean;
import com.taylor.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/27 11:42
 */
@RestController
public class CusumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HelloService helloService;

    @GetMapping("/ribbon-consumer")
    public String helloConsumer() {
        return restTemplate.getForEntity("http://SPC-TEST-CLIENT", String.class).getBody();

    }

    @GetMapping("/test")
    public SearchBean test() {
        return restTemplate.getForObject("http://SPC-TEST-CLIENT/test/hi?name=123213", SearchBean.class);

    }

    @GetMapping("/testhy")
    public SearchBean testHy() {
       return helloService.helloService();
    }
}
