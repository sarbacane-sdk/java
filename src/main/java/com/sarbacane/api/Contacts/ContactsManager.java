package com.sarbacane.api.Contacts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sarbacane.api.Authentication.AuthenticationManager;
import com.sarbacane.api.Base.BaseManager;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by guru on 11/05/16.
 */
// CONTACTS
    // contactsCreate
    // contactsGet
    // contactsDelete

public class ContactsManager extends BaseManager {

    public static SBSmsContact contactsCreate(SBSmsContact newContact) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(newContact.getListId())) {
            throw new RuntimeException("Error: listId is required.\n");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(newContact);
            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/lists/" + newContact.getListId() + "/contacts", json),SBSmsContact.class);
        }
    }

    public static List<SBSmsContact> contactsGet(String listId) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if(!isSet(listId)) {
            throw new RuntimeException("Error: listId is required.\n");
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/lists/" + listId + "/contacts"), new TypeReference<List<SBSmsContact>>(){});
    }

    public static String contactsDelete (SBSmsContact newContact) throws IOException {
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
        return BaseManager.httpDelete(BaseManager.baseURL + request);
    }


}
