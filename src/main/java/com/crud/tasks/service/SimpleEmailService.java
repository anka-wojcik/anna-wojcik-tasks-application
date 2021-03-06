package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
public class SimpleEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailCreatorService mailCreatorService;

    public void send(final Mail mail, MailMessageType mailMessageType) {
        LOGGER.info("Starting email preparation...");
       try{
           if (mailMessageType.equals(MailMessageType.CREATED_NEW_CARD_EMAIL)) {
               javaMailSender.send(createMimeMessage(mail, MailMessageType.CREATED_NEW_CARD_EMAIL));
           } else {
               javaMailSender.send(createMimeMessage(mail, MailMessageType.SCHEDULED_EMAIL));
           }
           LOGGER.info("Email has been sent.");
       } catch (MailException e) {
           LOGGER.error("Failed to process email sending: ", e.getMessage(), e);
       }
    }

    private MimeMessagePreparator createMimeMessage(final Mail mail, MailMessageType mailMessageType) {
        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(mail.getMailTo());
            messageHelper.setSubject(mail.getSubject());
            messageHelper.setText(chooseMessageTemplate(mail.getMessage(), mailMessageType), true);
        };
    }

    private String chooseMessageTemplate(String message, MailMessageType mailMessageType) {
        switch (mailMessageType) {
            case CREATED_NEW_CARD_EMAIL:
                return mailCreatorService.buildTrelloCardEmail(message);
            case SCHEDULED_EMAIL:
                return mailCreatorService.buildScheduledEmail(message);
                default:
                    return message;
        }
    }

    private SimpleMailMessage createMailMessage(Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        ofNullable(mail.getToCc()).ifPresent(mailMessage::setCc);
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        return mailMessage;
    }
}
