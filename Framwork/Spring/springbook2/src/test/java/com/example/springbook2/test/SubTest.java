package com.example.springbook2.test;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(value = "/sub-context.xml", inheritLocations = false)
public class SubTest {
}
