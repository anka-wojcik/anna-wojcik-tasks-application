package com.crud.tasks.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CreatedTrelloCardDtoTestSuite {
    @Test
    public void testGettersWhenAllArgsConstructor() {
        //Given
        CreatedTrelloCardDto trelloCardDto = new CreatedTrelloCardDto("1", "Card no. 1", "https://testing.com");
        //When&Then
        assertEquals("1", trelloCardDto.getId());
        assertEquals("Card no. 1", trelloCardDto.getName());
        assertEquals("https://testing.com", trelloCardDto.getShortUrl());
    }

    @Test
    public void testGettersWhenNoArgsConstructor() {
        //Given
        CreatedTrelloCardDto trelloCardDto = new CreatedTrelloCardDto();
        //When&Then
        assertNull(trelloCardDto.getId());
        assertNull(trelloCardDto.getName());
        assertNull(trelloCardDto.getShortUrl());
    }
}
