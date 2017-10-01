package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by nasir on 30/9/17.
 */
@RestController
public class FastPassController {

    List<FastPassCustomer> customerList =
            new ArrayList<>();

    public FastPassController() {
        FastPassCustomer fc1 = new FastPassCustomer("100", "Richard Seroter", "555-123-4567", new BigDecimal("19.50"));
        FastPassCustomer fc2 = new FastPassCustomer("101", "Jason Salmond", "555-321-7654", new BigDecimal("11.25"));
        FastPassCustomer fc3 = new FastPassCustomer("102", "Lisa Szpunar", "555-987-6543", new BigDecimal("35.00"));

        customerList.add(fc1);
        customerList.add(fc2);
        customerList.add(fc3);
    }

    @GetMapping(path="/fastpass", params={"fastpassid"})
    public FastPassCustomer getFastPassById(@RequestParam String fastpassid) {

        Predicate<FastPassCustomer> p = c-> c.getFastPassId().equals(fastpassid);
        FastPassCustomer customer = customerList.stream().filter(p).findFirst().get();
        System.out.println("customer details retrieved");
        return customer;
    }

    @GetMapping(path="/fastpass", params={"fastpassphone"})
    public FastPassCustomer getFastPassByPhone(@RequestParam String fastpassphone) {

        Predicate<FastPassCustomer> p = c-> c.getFastPassPhone().equals(fastpassphone);
        FastPassCustomer customer = customerList.stream().filter(p).findFirst().get();
        System.out.println("customer details retrieved");
        return customer;
    }
}
