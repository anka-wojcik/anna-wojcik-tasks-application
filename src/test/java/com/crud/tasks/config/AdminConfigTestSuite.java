package com.crud.tasks.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"admin.mail=kodillatestowekonto@gmail.com"})
public class AdminConfigTestSuite {
    @Autowired
    private AdminConfig adminConfig = new AdminConfig();

    @Test
    public void testAdminMail() {
        //Given
        //When
        String adminMail = adminConfig.getAdminMail();
        //Then
        assertEquals("kodillatestowekonto@gmail.com", adminMail);
    }
}
