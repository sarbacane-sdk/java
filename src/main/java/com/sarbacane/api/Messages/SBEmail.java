package com.sarbacane.api.Messages;

/**
 * Created by guru on 30/01/17.
 */
public class SBEmail extends MessagesManager {
    private String mailFrom;
    private String rcptTo;

    public SBEmail() {

    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getRcptTo() {
        return rcptTo;
    }

    public void setRcptTo(String rcptTo) {
        this.rcptTo = rcptTo;
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

    private String subject;
    private String message;


}
