package com.sarbacane.api.Account;


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
// ACCOUNT
    // acountStats
    // accountBouncesGet
    // accountUnsubscribersGet
    // accountUnsubscribersCreate
    // accountBouncesCreate
    // accountBouncesDeleteByIdentifier
    // accountBouncesDeleteById
    // accountUnsubscribersDeleteByIdentifier
    // accountUnsubscribersDeleteById

public class AccountManager extends BaseManager {

    private static ObjectMapper mapper = new ObjectMapper();

    public static PTAccount accountStats() throws IOException {
        AuthenticationManager.ensureLogin();
        return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/account/stats"), PTAccount.class);
    }

    public static List<PTBounce> accountBouncesGet() throws IOException {
        AuthenticationManager.ensureLogin();
        return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/bounces/default/contacts"), new TypeReference<List<PTBounce>>() {});
    }

    public static List<PTUnsubscriber> accountUnsubscribersGet() throws IOException {
        AuthenticationManager.ensureLogin();
        return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/unsubscribers/default/contacts"), new TypeReference<List<PTUnsubscriber>>() {});
    }

    public static PTBounce accountBouncesCreate(String identifier) throws IOException {
        AuthenticationManager.ensureLogin();
        PTBounce ptb = new PTBounce();
        ptb.setIdentifier(identifier);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ptb);
        return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/bounces/default/contacts", json), PTBounce.class);
    }

    public static PTUnsubscriber accountUnsubscribersCreate(String identifier) throws IOException {
        AuthenticationManager.ensureLogin();
        PTBounce ptb = new PTBounce();
        ptb.setIdentifier(identifier);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ptb);
        return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/bounces/default/contacts", json), PTUnsubscriber.class);
    }

    public static String accountBouncesDeleteByIdentifier(String identifier) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(identifier)) {
            throw new RuntimeException("Error: identifier is required.");
        }
        return BaseManager.httpDelete(BaseManager.baseURL + "/bounces/default/contacts?identifier=" + URLEncoder.encode(identifier, "UTF-8"));
    }

    public static String accountUnsubscribersDeleteByIdentifier(String identifier) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(identifier)) {
            throw new RuntimeException("Error: identifier is required.");
        }
        return BaseManager.httpDelete(BaseManager.baseURL + "/unsubscribers/default/contacts?identifier=" + URLEncoder.encode(identifier, "UTF-8"));
    }

    public static String accountBouncesDeleteById(String id) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(id)) {
            throw new RuntimeException("Error: identifier is required.");
        }
        return BaseManager.httpDelete(BaseManager.baseURL + "/bounces/default/contacts?identifier=" + id);
    }

    public static String accountUnsubscribersDeleteById(String id) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(id)) {
            throw new RuntimeException("Error: identifier is required.");
        }
        return BaseManager.httpDelete(BaseManager.baseURL + "/unsubscribers/default/contacts/" + id);
    }
}
