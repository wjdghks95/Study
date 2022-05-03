package com.example.springIoc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class Encoder implements IEncoder {

    private IEncoder iEncoder;

//    public Encoder(@Qualifier("base64Encoder") IEncoder iEncoder) {
//        this.iEncoder = iEncoder;
//    }

    public Encoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public void setIEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public String encode(String message) {

        return iEncoder.encode(message);
    }
}
