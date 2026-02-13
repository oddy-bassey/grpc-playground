package com.example.sec04;

import com.example.models.common.Address;
import com.example.models.common.Car;
import com.example.models.sec04.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Import {
    private static final Logger log = LoggerFactory.getLogger(Lec01Import.class);

    public static void main(String[] args) {
        var address = Address.newBuilder().setCity("Abuja").build();
        var car = Car.newBuilder().setMake("Benz").build();
        var person = Person.newBuilder()
                .setName("Demi")
                .setAge(32)
                .setAddress(address)
                .setCar(car)
                .build();

        log.info("Person has age: {}", person.hasAge());
        log.info("Person has been created: {}", person);
    }
}
