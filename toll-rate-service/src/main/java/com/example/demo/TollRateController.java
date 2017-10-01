package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Created by nasir on 30/9/17.
 */
@RestController
public class TollRateController {

    @GetMapping("/tollrate/{stationId}")
    public TollRate GetTollRate(@PathVariable int stationId) {

        TollRate tollRate;

        switch (stationId) {
            case 1:
                tollRate = new TollRate(stationId, new BigDecimal("0.05"), Instant.now().toString());
                break;
            case 2:
                tollRate = new TollRate(stationId, new BigDecimal("1.05"), Instant.now().toString());
                break;
            case 3:
                tollRate = new TollRate(stationId, new BigDecimal("0.60"), Instant.now().toString());
                break;
            default:
                tollRate = new TollRate(stationId, new BigDecimal("1.00"), Instant.now().toString());
                break;
        }

        return tollRate;
    }
}
