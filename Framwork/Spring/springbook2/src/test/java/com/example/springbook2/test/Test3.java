package com.example.springbook2.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/test-applicationContext.xml", "/subContext.xml"})
public class Test3 {

    @Test
    public void testMethod1() {}

    @Test
    public void testMethod2() {}
}
