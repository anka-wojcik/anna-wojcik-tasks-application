package com.crud.tasks.domain.CardBadges;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BadgesDto {

    private int votes;

    @JsonProperty("attachementsByType")
    private AttachementsByTypeDto attachements;

    public BadgesDto() {
        super();
    }
}
