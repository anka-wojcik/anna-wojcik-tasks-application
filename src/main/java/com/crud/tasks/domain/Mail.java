package com.crud.tasks.domain;

import com.crud.tasks.service.MailMessageType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Mail {
    private String mailTo;
    private String toCc;
    private String subject;
    private String message;

    public Mail() {
        super();
    }
}
