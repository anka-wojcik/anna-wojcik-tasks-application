package com.crud.tasks.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrelloCardTest {
    @Test
    public void testGettersWhenAllArgsConstructor() {
        //Given
        TrelloCard trelloCard = new TrelloCard("No. 1", "Desc. 1", "top", "1");
        //When&Then
        assertEquals("No. 1", trelloCard.getName());
        assertEquals("Desc. 1", trelloCard.getDescription());
        assertEquals("top", trelloCard.getPos());
        assertEquals("1", trelloCard.getListId());
    }

    @Test
    public void testGettersWhenNoArgsConstructor() {
        //Given
        TrelloCard trelloCard = new TrelloCard();
        //When&Then
        assertNull(trelloCard.getName());
        assertNull(trelloCard.getDescription());
        assertNull(trelloCard.getPos());
        assertNull(trelloCard.getListId());
    }

}