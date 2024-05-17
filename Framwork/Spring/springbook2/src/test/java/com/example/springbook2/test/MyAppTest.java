package com.example.springbook2.test;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@ActiveProfiles("dev")
public class MyAppTest {

    @Configuration
    static class MyAppConfig {}

    @Configuration
    static class MyExtraConfig {}
}
