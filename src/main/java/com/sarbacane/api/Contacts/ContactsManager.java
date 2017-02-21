package com.sarbacane.api.Contacts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sarbacane.api.Authentication.AuthenticationManager;
import com.sarbacane.api.Base.BaseManager;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;


public class ContactsManager extends BaseManager {

    public static SBSmsIdentifier checkIdentifier(String identifier) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(identifier)) {
            throw new RuntimeException("Error: identifier is required.\n");
        } else {

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(BaseManager.httpGet(BaseManager.smsUrl + "/check?identifier=" + URLEncoder.encode(identifier, "UTF-8")), SBSmsIdentifier.class);
        }
    }

    public static SBSmsContact contactsCreate(SBSmsContact newContact) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(newContact.getListId())) {
            throw new RuntimeException("Error: listId is required.\n");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(newContact);
            return mapper.readValue(BaseManager.httpPost(BaseManager.smsUrl + "/lists/" + newContact.getListId() + "/contacts", json), SBSmsContact.class);
        }
    }

    public static List<SBSmsContact> contactsGet(String listId) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(listId)) {
            throw new RuntimeException("Error: listId is required.\n");
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(BaseManager.httpGet(BaseManager.smsUrl + "/lists/" + listId + "/contacts"), new TypeReference<List<SBSmsContact>>() {
        });
    }

    public static String contactsDelete(SBSmsContact newContact) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(newContact.getListId())) {
            throw new RuntimeException("Error: listId is required.\n");
        }
        if ((!isSet(newContact.getId())) && (!isSet(newContact.getIdentifier()))) {
            throw new RuntimeException("Error: id or identifier is required.\n");
        }
        String request = null;
        if (isSet(newContact.getId())) {
            request = "/lists/" + newContact.getListId() + "/contacts/" + newContact.getId();
        } else if (isSet(newContact.getIdentifier())) {
            request = "/lists/" + newContact.getListId() + "/contacts?identifier=" + URLEncoder.encode(newContact.getIdentifier(), "UTF-8");
        }
        return BaseManager.httpDelete(BaseManager.smsUrl + request);
    }


}
