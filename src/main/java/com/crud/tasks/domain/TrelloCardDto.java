package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TrelloCardDto {
    private String name;
    private String description;
    private String pos;
    private String listId;

    public TrelloCardDto() {
        super();
    }
}
