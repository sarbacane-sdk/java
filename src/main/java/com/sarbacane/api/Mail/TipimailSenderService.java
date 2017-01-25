package com.sarbacane.api.Mail;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

/**
 * Created by guru on 25/01/17.
 */
public class TipimailSenderService {

    @PostConstruct
    public void init() {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", String.valueOf(port));
        props.put("mail.smtp.port", String.valueOf(port));
        props.put("mail.smtp.connectiontimeout", 60000);
        session = Session.getInstance(props);
    }

    public void send(Job job) throws MessagingException, JsonProcessingException {
        try {
            smtpTransport = generateTransport();
            Message msg = new MimeMessage(session);
            msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(job.getRecipient().getEmail()));
            msg.setSentDate(Date.from(Instant.now()));
            msg.setContent("", TYPE);
            msg.setSubject("");
            msg.setFrom(new InternetAddress(job.getRecipient().getEmail()));
            msg.setHeader("X-TM-SUB", jsonObjectMapper.writeValueAsString(Arrays.asList(job.getRecipient())));
            msg.setHeader("X-TM-TAGS", "[\"tag avec espace\", \"tag2\"]");
            msg.setHeader("X-TM-TEMPLATE", "\"template-scenar-1\"");
            smtpTransport.sendMessage(msg, msg.getAllRecipients());
            smtpTransport.close();
        } catch (MessagingException e) {
            logger.error("Exception generating transport for object : " + job);
            throw e;
        } catch (JsonProcessingException e) {
            logger.error("Exception processing json for object : " + job);
            throw e;
        }
    }

    private SMTPTransport generateTransport() throws MessagingException {
        smtpTransport = (SMTPTransport) session.getTransport("smtp");
        smtpTransport.connect(host, port, login, mdp);
        return smtpTransport;
    }
}
