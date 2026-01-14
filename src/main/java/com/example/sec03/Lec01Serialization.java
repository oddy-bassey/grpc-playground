package com.example.sec03;

import com.example.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lec01Serialization {
    private static final Logger log = LoggerFactory.getLogger(Lec01Serialization.class);
    private static final Path PATH = Path.of("person.ouput");

    public static void main(String[] args) throws IOException {
        var person = Person.newBuilder()
                .setName("Abu")
                .setAge(18)
                .setEmail("abu@gmail.com")
                .setEmployed(true)
                .setSalary(500.43)
                .setBankAccountNumber(1234567890L)
                .setBalance(1000)
                .build();

        serialize(person);
        log.info("{}", deserialize());
        log.info("{}", person.equals(deserialize()));
        log.info("bytes length {}", person.toByteArray().length);
    }

    public static void serialize(Person person) throws IOException {
        try (var outputStream = Files.newOutputStream(PATH)) {
            person.writeTo(outputStream);
        }
    }

    public static Person deserialize() throws IOException {
        try (var inputStream = Files.newInputStream(PATH)) {
            return Person.parseFrom(inputStream);
        }
    }
}
