package com.example.sec03;

import com.example.models.sec03.BodyStyle;
import com.example.models.sec03.Car;
import com.example.models.sec03.Dealer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec06Map {
    private static final Logger log = LoggerFactory.getLogger(Lec06Map.class);

    public static void main(String[] args) {
        var car1 = Car.newBuilder()
                .setMake("Honda")
                .setModel("civic")
                .setYear(2000)
                .setBodyStyle(BodyStyle.SEDAN)
                .build();
        var car2 = Car.newBuilder()
                .setMake("Benz")
                .setModel("C300")
                .setYear(2002)
                .setBodyStyle(BodyStyle.SUV)
                .build();

        var dealer = Dealer.newBuilder()
                .putInventory(car1.getYear(), car1)
                .putInventory(car2.getYear(), car2)
                .build();

        log.info("2000 ? : {}", dealer.containsInventory(2000));
        log.info("2002 ? : {}", dealer.containsInventory(2002));

        log.info("2002 model : {}", dealer.getInventoryOrThrow(2002).getModel());
        log.info("{}", car1);
    }
}
