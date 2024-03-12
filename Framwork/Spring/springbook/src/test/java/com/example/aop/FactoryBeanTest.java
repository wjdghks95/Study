package com.example.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-applicationContext.xml")
public class FactoryBeanTest {
    @Autowired
    ApplicationContext context;

    @Test
    public void getMessageFromFactoryBean() {
        Object message = context.getBean("message");
        assertTrue(message instanceof Message);
        assertThat(((Message) message).getText(), is("Factory Bean"));

        Object factory = context.getBean("&message"); // &가 붙고 안붙고에 따라 getBean() 메소드가 돌려주는 오브젝트가 달라진다.
        assertTrue(factory instanceof MessageFactoryBean);
    }
}
