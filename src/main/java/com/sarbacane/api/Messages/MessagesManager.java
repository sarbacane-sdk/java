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

    public static String sendEmail(SBEmail email) throws MessagingException {
        AuthenticationManager.ensureEmailTokens();
        if ((!isSet(email.getMailFrom())) || (!isSet(email.getRecipients().toString())) || !(isSet(email.getSubject())) || (!isSet(email.getMessage()))) {
            throw new RuntimeException("Error: missing params. sendEmail(mailFrom, rcptTo, subject, message");
        } else {
            return BaseManager.sendTransport(email);
        }
    }


    public static PTResult sendSms(SBSms msg) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(msg.getNumber()) || !isSet(msg.getMessage()) || !isSet(msg.getType())) {
            throw new RuntimeException("Error: SMS NOT SENT - message, number and type are required.\n");
        } else if (isSet(msg.getCategory()) && !isSet(msg.getCampaignName())) {
            throw new RuntimeException("Error: Please define a campaignName for catagory\n");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(msg);
            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/" + msg.getType() + "/messages/send", json), PTResult.class);
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

    public static PTSnapshot messagesGetStatusBySnapshotId(String snapshotId) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (snapshotId != null) {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/status?snapshotId=" + snapshotId), PTSnapshot.class);
        } else {
            throw new RuntimeException("Error: snapshotId is required.\n");
        }
    }

    public static PTSnapshot messagesGetStatusByIdentifier(String identifier) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (identifier != null) {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/status?identifier=" + URLEncoder.encode(identifier, "UTF-8")), PTSnapshot.class);
        } else {
            throw new RuntimeException("Error: identifier is required.\n");
        }
    }

    public static List<PTReplies> messagesGetRepliesByCategory(String category) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (category != null) {
            if (category.equals("")) {
                return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/replies" + URLEncoder.encode(category, "UTF-8") ), new TypeReference<List<PTReplies>>() {});
            } else {
                return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/replies?category=" + URLEncoder.encode(category, "UTF-8")), new TypeReference<List<PTReplies>>() {
                });
            }
        } else {
            throw new RuntimeException("Error: category is required.\n");
        }
    }

    public static PTMessagesStats messagesGetStatsByCategory(String category) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (category != null) {
            if (category.equals("")) {
                return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/stats" + URLEncoder.encode(category, "UTF-8")), PTMessagesStats.class);
            } else {
                return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/stats?category=" + URLEncoder.encode(category, "UTF-8")), PTMessagesStats.class);
            }
        } else {
            throw new RuntimeException("Error: Please define category");
        }
    }

    public static PTMessagesBlacklists messagesGetBlacklists(String category) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (category != null) {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/blacklists?category=" + URLEncoder.encode(category, "UTF-8")), PTMessagesBlacklists.class);
        } else {
            throw new RuntimeException("Error: Please define category");
        }
    }
}