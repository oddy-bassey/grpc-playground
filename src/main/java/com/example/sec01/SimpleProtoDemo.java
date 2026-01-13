package com.example.sec01;

import com.example.models.sec01.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProtoDemo {
    private static final Logger logger = LoggerFactory.getLogger(SimpleProtoDemo.class);

    public static void main(String[] args) {
        var person = Person.person.newBuilder()
                .setName("John")
                .setAge(23)
                .build();

        logger.info("{}", person);
    }
}
