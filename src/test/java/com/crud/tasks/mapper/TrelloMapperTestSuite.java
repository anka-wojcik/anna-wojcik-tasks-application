package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {
    @InjectMocks
    private TrelloMapper mapper;

    @Test
    public void testTrelloMapperMapToBoards() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();

        List<TrelloBoardDto> trelloBoardDtos = Arrays.asList(
                new TrelloBoardDto("Board no. 1", "1", trelloListDto),
                new TrelloBoardDto("Board no. 2", "2", trelloListDto),
                new TrelloBoardDto("Board no. 3", "3", trelloListDto));
        //When
        List<TrelloBoard> trelloBoards = mapper.mapToBoards(trelloBoardDtos);
        //Then
        Assert.assertEquals(3, trelloBoards.size());
        Assert.assertEquals("Board no. 3", trelloBoards.get(2).getName());
    }

    @Test
    public void testTrelloMapperMapToBoardsDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();

        List<TrelloBoard> trelloBoards = Arrays.asList(
                new TrelloBoard("Board no. 1", "1", trelloLists),
                new TrelloBoard("Board no. 2", "2", trelloLists),
                new TrelloBoard("Board no. 3", "3", trelloLists));
        //When
        List<TrelloBoardDto> trelloBoardDto = mapper.mapToBoardsDto(trelloBoards);
        //Then
        Assert.assertEquals(3, trelloBoardDto.size());
        Assert.assertEquals("Board no. 3", trelloBoardDto.get(2).getName());
    }

    @Test
    public void testTrelloMapperMapToList() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("1", "List no. 1", true));
        trelloListDto.add(new TrelloListDto("2", "List no. 2", false));
        trelloListDto.add(new TrelloListDto("3", "List no. 3", true));
        //When
        List<TrelloList> trelloList = mapper.mapToList(trelloListDto);
        //Then
        Assert.assertEquals(3, trelloList.size());
        Assert.assertEquals("List no. 3", trelloList.get(2).getName());
    }

    @Test
    public void testTrelloMapperMapToListDto() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("1", "List no. 1", true));
        trelloList.add(new TrelloList("2", "List no. 2", false));
        trelloList.add(new TrelloList("3", "List no. 3", true));
        //When
        List<TrelloListDto> trelloListDto = mapper.mapToListDto(trelloList);
        //Then
        Assert.assertEquals(3, trelloListDto.size());
        Assert.assertEquals("List no. 3", trelloListDto.get(2).getName());
    }

    @Test
    public void testTrelloMapperMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("No. 1", "Description", "top", "1");
        //When
        TrelloCardDto trelloCardDto = mapper.mapToCardDto(trelloCard);
        //Then
        Assert.assertEquals("No. 1", trelloCardDto.getName());
        Assert.assertEquals("Description", trelloCardDto.getDescription());
        Assert.assertEquals("top", trelloCardDto.getPos());
        Assert.assertEquals("1", trelloCardDto.getListId());
    }

    @Test
    public void testTrelloMapperMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("No. 1", "Description", "top", "1");
        //When
        TrelloCard trelloCard = mapper.mapToCard(trelloCardDto);
        //Then
        Assert.assertEquals("No. 1", trelloCard.getName());
        Assert.assertEquals("Description", trelloCard.getDescription());
        Assert.assertEquals("top", trelloCard.getPos());
        Assert.assertEquals("1", trelloCard.getListId());
    }

}
