package com.example.sec03;

import com.example.models.sec03.Address;
import com.example.models.sec03.School;
import com.example.models.sec03.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Lec04Composition {
    private static final Logger log = LoggerFactory.getLogger(Lec04Composition.class);

    public static void main(String[] args)
    {

        // create student
        var address = Address.newBuilder()
                .setStreet("123 main srt")
                .setCity("Atlanta")
                .setState("CA")
                .build();

        var student = Student.newBuilder()
                .setName("John")
                .setAddress(address)
                .build();

        // create school
        var school = School.newBuilder()
                .setId(1)
                .setName("Oxford")
                .setAddress(address.toBuilder().setStreet("234 noxshire"))
                .build();

        log.info("school: {}", school);
        log.info("student: {}", student);
    }
}
