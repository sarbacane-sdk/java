package com.sarbacane.api.Messages;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guru on 30/01/17.
 */
public class SBEmail extends MessagesManager {
    private String mailFrom;
    private String subject;
    private String message;


    private List<String> recipients = new ArrayList<String>();

    public SBEmail() {

    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
