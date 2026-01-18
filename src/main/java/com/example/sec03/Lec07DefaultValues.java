package com.example.sec03;

import com.example.models.sec03.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec07DefaultValues {
    private static final Logger log = LoggerFactory.getLogger(Lec07DefaultValues.class);

    public static void main(String[] args) {
        var school = School.newBuilder().build();

        log.info("{}", school.getId());
        log.info("{}", school.getName());
        log.info("{}", school.getAddress().getCity());

        log.info("is the school address default ? {}", school.getAddress().equals(Address.getDefaultInstance()));
        log.info("is school city empty ? {}", school.getAddress().getCity().isEmpty());

        log.info("does the school have an address ? {}", school.hasAddress());

        var library = Library.newBuilder().build();
        log.info("library {}", library.getBooksList());

        var dealer = Dealer.newBuilder().build();
        log.info("cars {}", dealer.getInventoryMap());

        var car = Car.newBuilder().build();
        log.info("car body style {}", car.getBodyStyle());
    }
}
