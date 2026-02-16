package com.example.sec05;

import com.example.models.sec05.Television;
import com.example.sec05.Parser.V1Parser;
import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V1VersionCompatibility {

    private static final Logger log = LoggerFactory.getLogger(V1VersionCompatibility.class);

    public static void main(String[] args) throws InvalidProtocolBufferException {
        var tv = Television.newBuilder()
                .setBrand("Samsung")
                .setYear(2015)
                .build();

        V1Parser.parse(tv.toByteArray());
    }
}
