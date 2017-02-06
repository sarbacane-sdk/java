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

    public static SBSmsField fieldsCreate (SBSmsField newSBSmsField) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(newSBSmsField.getType())) {
            throw new RuntimeException("Error: field type is required: STRING, DATE or NUMBER.\n");
        } else if (! "string".equals(newSBSmsField.getType().toLowerCase()) &&! "date".equals(newSBSmsField.getType().toLowerCase()) && ! "number".equals(newSBSmsField.getType().toLowerCase()))  {
            throw new RuntimeException("Error: field type is required: STRING, DATE or NUMBER.\n");
        } else if ("date".equals(newSBSmsField.getType().toLowerCase()) && !isSet(newSBSmsField.getFormat())) {
            throw new RuntimeException("Error: date format is required: dd/MM/yyyy, dd/MM or MM/yyyy.\n");
        } else {
            newSBSmsField.setType(newSBSmsField.getType().toUpperCase());
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(newSBSmsField);
            //Map<String, String> result = mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/lists/" + newPTField.getListId() + "/fields", json), new TypeReference<Map<String, String>>() {});
            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/lists/" + newSBSmsField.getListId() + "/fields", json), SBSmsField.class);
            //return result.get("id");
        }

    }

    public static String fieldsDelete (SBSmsField newSBSmsField) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(newSBSmsField.getId())) {
            throw new RuntimeException("Error: Please define a FieldId.");
        } else {
            return BaseManager.httpDelete(BaseManager.baseURL + "/lists/" + newSBSmsField.getListId() + "/fields/" + newSBSmsField.getId());
        }
    }

    public static List<SBSmsField> fieldsGet (String listId) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(listId)) {
            throw new RuntimeException("Error: Please define a ListId.");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/lists/" + listId + "/fields/"), new TypeReference<List<SBSmsField>>(){});
        }
    }
}
