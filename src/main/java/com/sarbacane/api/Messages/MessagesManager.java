package com.sarbacane.api.Messages;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sarbacane.api.Authentication.AuthenticationManager;
import com.sarbacane.api.Base.BaseManager;

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

    private static ObjectMapper mapper = new ObjectMapper();

    public static PTResult messagesNotificationSend(PTMessage msg) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(msg.getNumber()) || !isSet(msg.getMessage())) {
            throw new RuntimeException("Error: SMS NOT SENT - message and number are required.\n");
        } else if (isSet(msg.getCategory()) && !isSet(msg.getCampaignName())) {
            throw new RuntimeException("Error: Please define a campaignName for catagory\n");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(msg);
            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/notification/messages/send", json), PTResult.class);
        }
    }

    public static PTResult messagesMarketingSend(PTMessage msg) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(msg.getNumber()) || !isSet(msg.getMessage())) {
            throw new RuntimeException("Error: SMS NOT SENT - message and number are required.\n");
        } else if (isSet(msg.getCategory()) && !isSet(msg.getCampaignName())) {
            throw new RuntimeException("Error: Please define a campaignName for catagory\n");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(msg);
            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/marketing/messages/send", json), PTResult.class);
        }
    }

    public static PTSnapshot messagesGetStatusBySnapshotId(String snapshotId) throws IOException {
        AuthenticationManager.ensureLogin();
        if (snapshotId != null) {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/status?snapshotId=" + snapshotId), PTSnapshot.class);
        } else {
            throw new RuntimeException("Error: snapshotId is required.\n");
        }
    }

    public static PTSnapshot messagesGetStatusByIdentifier(String identifier) throws IOException {
        AuthenticationManager.ensureLogin();
        if (identifier != null) {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/status?identifier=" + URLEncoder.encode(identifier, "UTF-8")), PTSnapshot.class);
        } else {
            throw new RuntimeException("Error: identifier is required.\n");
        }
    }

    public static List<PTReplies> messagesGetRepliesByCategory(String category) throws IOException {
        AuthenticationManager.ensureLogin();
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
        AuthenticationManager.ensureLogin();
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
        AuthenticationManager.ensureLogin();
        if (category != null) {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/messages/blacklists?category=" + URLEncoder.encode(category, "UTF-8")), PTMessagesBlacklists.class);
        } else {
            throw new RuntimeException("Error: Please define category");
        }
    }
}