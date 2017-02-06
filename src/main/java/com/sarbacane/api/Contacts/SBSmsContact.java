package com.sarbacane.api.Contacts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sarbacane.api.Lists.ListsManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guru on 02/04/15.
 */

@JsonIgnoreProperties({"listId","request"})
public class SBSmsContact extends ListsManager {
    public String id=null;
    public String listId=null;
    public String identifier=null;
    public Map<String, String> attributes = new HashMap<String, String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    @JsonIgnore
    public void setFieldValue(String fieldId, String fieldValue) {
        this.attributes.put(fieldId, fieldValue);
    }

    @Override
    public String toString() {
        return "PTContact{" +
                "id='" + id + '\'' +
                //", listId='" + listId + '\'' +
                ", identifier='" + identifier + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}