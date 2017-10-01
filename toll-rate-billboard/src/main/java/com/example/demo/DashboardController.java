package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Created by nasir on 30/9/17.
 */
@RestController
public class DashboardController {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getTollRateBackup")
    @GetMapping("/dashboard")
    public TollRate GetTollRate(@RequestParam int stationId) {

        TollRate tr = restTemplate.getForObject("http://toll-rate-service/tollrate/" + stationId, TollRate.class);
        System.out.println("stationId: " + stationId);
        return tr;
    }

    public TollRate getTollRateBackup(int sectionId) {
        return new TollRate(100, new BigDecimal("0.56"), Instant.now().toString());
    }
}
