package com.sarbacane.api.Fields;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sarbacane.api.Authentication.AuthenticationManager;
import com.sarbacane.api.Base.BaseManager;

import java.io.IOException;
import java.util.List;

/**
 * Created by guru on 11/05/16.
 */
// FIELDS
    // fieldsCreate
    // fieldsDelete
    // fieldsGet

public class FieldsManager extends BaseManager {

    public static PTField fieldsCreate (PTField newPTField) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(newPTField.getType())) {
            throw new RuntimeException("Error: field type is required: STRING, DATE or NUMBER.\n");
        } else if (! "string".equals(newPTField.getType().toLowerCase()) &&! "date".equals(newPTField.getType().toLowerCase()) && ! "number".equals(newPTField.getType().toLowerCase()))  {
            throw new RuntimeException("Error: field type is required: STRING, DATE or NUMBER.\n");
        } else if ("date".equals(newPTField.getType().toLowerCase()) && !isSet(newPTField.getFormat())) {
            throw new RuntimeException("Error: date format is required: dd/MM/yyyy, dd/MM or MM/yyyy.\n");
        } else {
            newPTField.setType(newPTField.getType().toUpperCase());
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(newPTField);
            //Map<String, String> result = mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/lists/" + newPTField.getListId() + "/fields", json), new TypeReference<Map<String, String>>() {});
            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/lists/" + newPTField.getListId() + "/fields", json), PTField.class);
            //return result.get("id");
        }

    }

    public static String fieldsDelete (PTField newPTField) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(newPTField.getId())) {
            throw new RuntimeException("Error: Please define a FieldId.");
        } else {
            return BaseManager.httpDelete(BaseManager.baseURL + "/lists/" + newPTField.getListId() + "/fields/" + newPTField.getId());
        }
    }

    public static List<PTField> fieldsGet (String listId) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(listId)) {
            throw new RuntimeException("Error: Please define a ListId.");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/lists/" + listId + "/fields/"), new TypeReference<List<PTField>>(){});
        }
    }
}
