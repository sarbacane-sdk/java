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

    /**
     * No args constructor for use in serialization
     *
     */
    public SBSmsField() {
    }

    /**
     *
     * @param id
     * @param listId
     * @param name
     * @param format
     * @param type
     */
    public SBSmsField(String id, String name, String type, String listId, String format) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.listId = listId;
        this.format = format;
    }

    /**
     *
     * @return
     * The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public SBSmsField withId(String id) {
        this.id = id;
        return this;
    }

    /**
     *
     * @return
     * The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public SBSmsField withName(String name) {
        this.name = name;
        return this;
    }

    /**
     *
     * @return
     * The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public SBSmsField withType(String type) {
        this.type = type;
        return this;
    }

    /**
     *
     * @return
     * The listId
     */
    @JsonProperty("listId")
    public String getListId() {
        return listId;
    }

    /**
     *
     * @param listId
     * The listId
     */
    @JsonProperty("listId")
    public void setListId(String listId) {
        this.listId = listId;
    }

    public SBSmsField withListId(String listId) {
        this.listId = listId;
        return this;
    }

    /**
     *
     * @return
     * The format
     */
    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    /**
     *
     * @param format
     * The format
     */
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
