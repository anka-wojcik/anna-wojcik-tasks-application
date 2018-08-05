package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloValidatorTestSuite {

    @InjectMocks
    private TrelloValidator trelloValidator;

    @Test
    public void testValidateTrelloBoard() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "Board no. 1", trelloLists));
        trelloBoards.add(new TrelloBoard("2", "test", trelloLists));
        //When
        List<TrelloBoard> validatedBoards = trelloValidator.validateTrelloBoards(trelloBoards);
        //Then
        Assert.assertEquals(1, validatedBoards.size());

        validatedBoards.forEach(trelloBoard -> {
            Assert.assertEquals("1", trelloBoard.getId());
            Assert.assertEquals("Board no. 1", trelloBoard.getName());
        });
    }

    @Test
    public void testValidateTrelloCard() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test", "", "top", "1");
        //When
        trelloValidator.validateCard(trelloCard);
        //Then
    }
}
