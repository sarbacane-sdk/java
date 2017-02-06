package com.sarbacane.api.Messages;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sarbacane.api.Authentication.AuthenticationManager;
import com.sarbacane.api.Base.BaseManager;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;


/**
 * Created by guru on 12/11/14.
 */
// MESSAGES
    // messagesNotificationSend
    // messagesMarketingSend
    // messagesGetStatsByCategory
    // messagesGetRepliesByCategory
    // messagesGetStatusBySnapshotId
    // messagesGetStatusByIdentifier
    // messagesGetBlacklistsByCategory


public class MessagesManager extends BaseManager {

    private static Session session;
    private static ObjectMapper mapper = new ObjectMapper();

    public static String sendEmail(SBEmailMessage email) throws MessagingException {
        AuthenticationManager.ensureEmailTokens();
        if ((!isSet(email.getMailFrom())) || (!isSet(email.getRecipients().toString())) || !(isSet(email.getSubject())) || (!isSet(email.getMessage()))) {
            throw new RuntimeException("Error: missing params. sendEmail(mailFrom, rcptTo, subject, message");
        } else {
            return BaseManager.sendTransport(email);
        }
    }


    public static SBSmsMessageSendingResult sendSms(SBSmsMessage msg) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(msg.getNumber()) || !isSet(msg.getMessage()) || !isSet(msg.getType())) {
            throw new IllegalArgumentException("Error: SMS NOT SENT - message, number and type are required.\n");
        } else if (isSet(msg.getCategory()) && !isSet(msg.getCampaignName())) {
            throw new IllegalArgumentException("Error: Please define a campaignName for catagory\n");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(msg);
            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/" + msg.getType() + "/messages/send", json), SBSmsMessageSendingResult.class);
        }
    }

//    public static PTResult sendMarketingSms(SBSms msg) throws IOException {
//        AuthenticationManager.ensureSmsTokens();
//        if (!isSet(msg.getNumber()) || !isSet(msg.getMessage())) {
//            throw new RuntimeException("Error: SMS NOT SENT - message and number are required.\n");
//        } else if (isSet(msg.getCategory()) && !isSet(msg.getCampaignName())) {
//            throw new RuntimeException("Error: Please define a campaignName for catagory\n");
//        } else {
//            ObjectMapper mapper = new ObjectMapper();
//            String json = mapper.writeValueAsString(msg);
//            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/marketing/messages/send", json), PTResult.class);
//        }
//    }

    public static SBSmsSnapshot smsStatusBySnapshotId(String snapshotId) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (snapshotId != null) {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/status?snapshotId=" + snapshotId), SBSmsSnapshot.class);
        } else {
            throw new RuntimeException("Error: snapshotId is required.\n");
        }
    }

    public static SBSmsSnapshot smsStatusByIdentifier(String identifier) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (identifier != null) {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/status?identifier=" + URLEncoder.encode(identifier, "UTF-8")), SBSmsSnapshot.class);
        } else {
            throw new RuntimeException("Error: identifier is required.\n");
        }
    }

    public static List<SBSmsMessageReplies> smsReplies(String category) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (category != null) {
            if (category.equals("")) {
                return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/replies" + URLEncoder.encode(category, "UTF-8") ), new TypeReference<List<SBSmsMessageReplies>>() {});
            } else {
                return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/replies?category=" + URLEncoder.encode(category, "UTF-8")), new TypeReference<List<SBSmsMessageReplies>>() {
                });
            }
        } else {
            throw new RuntimeException("Error: category is required.\n");
        }
    }

    public static SBSmsMessageStats smsStats(String category) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (category != null) {
            if (category.equals("")) {
                return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/stats" + URLEncoder.encode(category, "UTF-8")), SBSmsMessageStats.class);
            } else {
                return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/stats?category=" + URLEncoder.encode(category, "UTF-8")), SBSmsMessageStats.class);
            }
        } else {
            throw new RuntimeException("Error: Please define category");
        }
    }

    public static SBSmsMessageBlacklists smsBlacklists(String category) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (category != null) {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/blacklists?category=" + URLEncoder.encode(category, "UTF-8")), SBSmsMessageBlacklists.class);
        } else {
            throw new RuntimeException("Error: Please define category");
        }
    }
}