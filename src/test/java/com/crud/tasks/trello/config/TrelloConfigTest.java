package com.crud.tasks.trello.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {
        "trello.api.endpoint.prod=endpoint_test",
        "trello.app.key=key_test",
        "trello.app.token=token_test",
})
public class TrelloConfigTest {
    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    public void getTrelloApiEndpoint() {
        // Given & When & Then
        assertEquals("endpoint_test", trelloConfig.getTrelloApiEndpoint());
    }

    @Test
    public void getTrelloAppKey() {
        // Given & When & Then
        assertEquals("key_test", trelloConfig.getTrelloAppKey());
    }

    @Test
    public void getTrelloToken() {
        // Given & When & Then
        assertEquals("token_test", trelloConfig.getTrelloToken());
    }
}