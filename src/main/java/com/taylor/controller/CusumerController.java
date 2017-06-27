package com.taylor.controller;

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

    @GetMapping("/ribbon-consumer")
    public String helloConsumer() {
        return restTemplate.getForEntity("http://SPC-TEST-CLIENT", String.class).getBody();

    }
}
