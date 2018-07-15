package com.crud.tasks.domain.CardBadges;
//
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttachementsByTypeDto {

    @JsonProperty("trello")
    private TrelloDto trello;

    public AttachementsByTypeDto() {
        super();
    }
}
