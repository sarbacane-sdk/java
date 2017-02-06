package com.sarbacane.api.Lists;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sarbacane.api.Authentication.AuthenticationManager;
import com.sarbacane.api.Base.BaseManager;

import java.io.IOException;
import java.util.List;


/**
 * Created by guru on 02/04/15.
 */
// LISTS
    // listsCreate
    // listsDelete
    // listsGet
    // listsGet

public class ListsManager extends BaseManager {

    private static ObjectMapper mapper = new ObjectMapper();

    public static SBSmsList listsCreate(String name) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(name)) {
            throw new RuntimeException("Error: name is required.\n");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String json = "{\"name\": \"" + name + "\"}" ;//mapper.writeValueAsString(obj)
            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/lists", json), SBSmsList.class);
        }
    }

    public static List<SBSmsList> listsGet () throws IOException {
        AuthenticationManager.ensureSmsTokens();
        return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/lists"), new TypeReference<List<SBSmsList>>(){});
    }

    public static SBSmsList listsGet (String listId) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(listId)) {
            throw new RuntimeException("Error: listId is required.\n");
        } else {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/lists/" + listId), SBSmsList.class);
        }
    }

    public static String bulkImport(String listId, String filePath) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if ( (!isSet(listId)) || (!isSet(filePath)) ) {
            throw new RuntimeException("Error: listId AND filePath are required.\n");
        } else {
            String json = BaseManager.readFile(filePath);
            return BaseManager.baseURL + BaseManager.httpPostH(BaseManager.baseURL + "/lists/" + listId + "/import", json);
        }
    }

    public static String operationStatus (String operationUrl) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(operationUrl)) {
            throw new RuntimeException("Error: operationId is required.\n");
        } else {
            return BaseManager.httpGet(operationUrl);
        }

    }

    public static String listsDelete (String listId) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(listId)) {
            throw new RuntimeException("Error: listId is required.\n");
        } else {
            return BaseManager.httpDelete(BaseManager.baseURL + "/lists/" + listId);
        }
    }
}
