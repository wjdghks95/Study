package com.example.template;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalcSumTest {

    Calculator calculator;
    String numFilePath;

    @Before
    public void setUp() throws URISyntaxException {
        this.calculator = new Calculator();
        this.numFilePath = this.getClass().getResource("numbers.txt").getPath();
    }

    @Test
    public void sumOfNumbers() throws IOException, URISyntaxException {
//        Calculator calculator = new Calculator();
//        Integer sum = calculator.calcSum(getClass().getResource("numbers.txt").getPath());
//        assertThat(sum, is(10));

        assertThat(calculator.calcSum(this.numFilePath), is(10));
    }

    @Test
    public void concatenateStrings() throws IOException {
        assertThat(calculator.concatenate(this.numFilePath), is("1234"));
    }
}
