package com.example.template;

import java.io.BufferedReader;
import java.io.IOException;

public interface BuffedReaderCallback {
    Integer doSomethingWithReader(BufferedReader br) throws IOException;
}
