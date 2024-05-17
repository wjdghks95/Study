package com.example.springbook2.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-applicationContext.xml")
public class Test1 {

    @Autowired Bean bean;
    @Resource Bean myBean;
    Bean bean1;
    Bean bean2;

    @Autowired
    public void setBean(Bean bean) {this.bean1 = bean;}

    @Autowired
    public void init(Bean bean) {this.bean2 = bean;}

    @Test
    @DirtiesContext
    public void testMethod1() {}

    @Test
    public void testMethod2() {}

}
