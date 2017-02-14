package com.sarbacane.api.Account;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sarbacane.api.Authentication.AuthenticationManager;
import com.sarbacane.api.Base.BaseManager;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;


public class AccountManager extends BaseManager {

    private static ObjectMapper mapper = new ObjectMapper();

    public static SBSmsAccount accountStats() throws IOException {
        AuthenticationManager.ensureSmsTokens();
        return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/account/stats"), SBSmsAccount.class);
    }

    public static List<SBSmsAccountBounces> accountBouncesGet() throws IOException {
        AuthenticationManager.ensureSmsTokens();
        return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/bounces/default/contacts"), new TypeReference<List<SBSmsAccountBounces>>() {
        });
    }

    public static List<SBSmsAccountUnsubscribers> accountUnsubscribersGet() throws IOException {
        AuthenticationManager.ensureSmsTokens();
        return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/unsubscribers/default/contacts"), new TypeReference<List<SBSmsAccountUnsubscribers>>() {
        });
    }

    public static SBSmsAccountBounces accountBouncesCreate(String identifier) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        SBSmsAccountBounces ptb = new SBSmsAccountBounces();
        ptb.setIdentifier(identifier);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ptb);
        return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/bounces/default/contacts", json), SBSmsAccountBounces.class);
    }

    public static SBSmsAccountUnsubscribers accountUnsubscribersCreate(String identifier) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        SBSmsAccountBounces ptb = new SBSmsAccountBounces();
        ptb.setIdentifier(identifier);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ptb);
        return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/bounces/default/contacts", json), SBSmsAccountUnsubscribers.class);
    }

    public static String accountBouncesDeleteByIdentifier(String identifier) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(identifier)) {
            throw new RuntimeException("Error: identifier is required.");
        }
        return BaseManager.httpDelete(BaseManager.baseURL + "/bounces/default/contacts?identifier=" + URLEncoder.encode(identifier, "UTF-8"));
    }

    public static String accountUnsubscribersDeleteByIdentifier(String identifier) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(identifier)) {
            throw new RuntimeException("Error: identifier is required.");
        }
        return BaseManager.httpDelete(BaseManager.baseURL + "/unsubscribers/default/contacts?identifier=" + URLEncoder.encode(identifier, "UTF-8"));
    }

    public static String accountBouncesDeleteById(String id) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(id)) {
            throw new RuntimeException("Error: identifier is required.");
        }
        return BaseManager.httpDelete(BaseManager.baseURL + "/bounces/default/contacts?identifier=" + id);
    }

    public static String accountUnsubscribersDeleteById(String id) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(id)) {
            throw new RuntimeException("Error: identifier is required.");
        }
        return BaseManager.httpDelete(BaseManager.baseURL + "/unsubscribers/default/contacts/" + id);
    }
}
