package com.crud.tasks.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class MailTest {
    @Test
    public void testGettersWhenAllArgsConstructor() {
        //Given
        Mail mail = new Mail("test address", null, "test subject", "test message");
        //When&Then
        assertEquals("test address", mail.getMailTo());
        assertEquals(null, mail.getToCc());
        assertEquals("test subject", mail.getSubject());
        assertEquals("test message", mail.getMessage());
    }

    @Test
    public void testGettersWhenNoArgsConstructor() {
        //Given
        Mail mail = new Mail();
        //When&Then
        assertNull(mail.getMailTo());
        assertNull(mail.getToCc());
        assertNull(mail.getSubject());
        assertNull(mail.getMessage());
    }

}