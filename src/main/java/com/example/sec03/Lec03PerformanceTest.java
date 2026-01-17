package com.example.sec03;

import com.example.models.sec03.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Lec03PerformanceTest {
    private static final Logger log = LoggerFactory.getLogger(Lec03PerformanceTest.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        var protoPerson = Person.newBuilder()
                .setName("Abu")
                .setAge(18)
                .setEmail("abu@gmail.com")
                .setEmployed(true)
                .setSalary(500.43)
                .setBankAccountNumber(1234567890L)
                .setBalance(1000)
                .build();

        var jsonPerson = new JsonPerson("Abu", 18, "abu@gmail.com", true,
                500.43, 1234567890L, 1000);

        for (int i = 0; i < 5; i++) {
            runTest("json", () -> json(jsonPerson));
            runTest("proto", () -> proto(protoPerson));
        }

//        proto(protoPerson);
//        json(jsonPerson);
    }

    public static void proto(Person person) {

        try {
            var bytes = person.toByteArray();
//            log.info("proto person bytes length: {}", bytes.length);
            Person.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    public static void json(JsonPerson jsonPersonq) {
        try {
            var bytes = mapper.writeValueAsBytes(jsonPersonq);
//            log.info("json person bytes length: {}", bytes.length);
            mapper.readValue(bytes, JsonPerson.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void runTest(String testName, Runnable runnable) {
        var startTime = System.currentTimeMillis();
        for (int i = 0; i < 5_000_000; i++) {
            runnable.run();
        }
        var endTime = System.currentTimeMillis();
        log.info("time taken for {} - {} ms", testName, (endTime - startTime));
    }
}
