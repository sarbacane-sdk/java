package com.sarbacane.api.Fields;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "id",
        "name",
        "type",
        "listId",
        "format"
})
public class SBSmsField {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("listId")
    private String listId;
    @JsonProperty("format")
    private String format;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public SBSmsField() {
    }


    public SBSmsField(String id, String name, String type, String listId, String format) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.listId = listId;
        this.format = format;
    }


    @JsonProperty("id")
    public String getId() {
        return id;
    }


    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public SBSmsField withId(String id) {
        this.id = id;
        return this;
    }


    @JsonProperty("name")
    public String getName() {
        return name;
    }


    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public SBSmsField withName(String name) {
        this.name = name;
        return this;
    }


    @JsonProperty("type")
    public String getType() {
        return type;
    }


    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public SBSmsField withType(String type) {
        this.type = type;
        return this;
    }


    @JsonProperty("listId")
    public String getListId() {
        return listId;
    }


    @JsonProperty("listId")
    public void setListId(String listId) {
        this.listId = listId;
    }

    public SBSmsField withListId(String listId) {
        this.listId = listId;
        return this;
    }


    @JsonProperty("format")
    public String getFormat() {
        return format;
    }


    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    public SBSmsField withFormat(String format) {
        this.format = format;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public SBSmsField withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "PTField{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", listId='" + listId + '\'' +
                ", format='" + format + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
