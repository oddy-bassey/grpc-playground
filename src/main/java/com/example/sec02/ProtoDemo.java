package com.example.sec02;

import com.example.models.sec02.Person;
import com.example.sec01.SimpleProtoDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {
    private static final Logger logger = LoggerFactory.getLogger(SimpleProtoDemo.class);

    public static void main(String[] args) {
        Person person = Person.newBuilder()
                .setName("Andy")
                .setAge(12)
                .build();

        logger.info("{}", person);
    }
}
