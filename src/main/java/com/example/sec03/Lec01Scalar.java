package com.example.sec03;

import com.example.models.sec03.Person;
import com.example.sec01.SimpleProtoDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Scalar {
    private static final Logger log = LoggerFactory.getLogger(Lec01Scalar.class);

    public static void main(String[] args) {
        var person = Person.newBuilder()
                .setName("Abu")
                .setAge(18)
                .setEmail("abu@gmail.com")
                .setEmployed(true)
                .setSalary(500.43)
                .setBankAccountNumber(1234567890L)
                .setBalance(1000)
                .build();

        log.info("person={}", person);
    }
}
