package com.example.sec02;

import com.example.models.sec02.Person;
import com.example.sec01.SimpleProtoDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {
    private static final Logger log = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(String[] args) {

        // create person
        var person1 = createPerson();

        // create another instance with some values
        var person2 = createPerson();

        // compare
        log.info("equals {}", person1.equals(person2)); // compares by values: true
        log.info("== {}", person1.equals(person2)); // compares by reference: false

        // mutable? No

        // create another instance with different values
        var person3 = person1.toBuilder().setName("Mike").build();
        log.info("person3 {}", person3);

        // compare
        log.info("equals {}", person1.equals(person3));
        log.info("== {}", person1.equals(person3));

        // null ?
        var person4 = person1.toBuilder().clearName().build();
        log.info("person4 {}", person4);

    }

    private static Person createPerson() {
        return Person.newBuilder()
                .setName("Andy")
                .setAge(12)
                .build();
    }
}
