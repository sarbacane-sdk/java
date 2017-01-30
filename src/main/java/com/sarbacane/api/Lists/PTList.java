package com.sarbacane.api.Lists;

import com.fasterxml.jackson.annotation.*;
import com.sarbacane.api.Fields.PTField;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "id",
        "name",
        "fields"
})
public class PTList {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("fields")
    private List<PTField> PTFields = new ArrayList<PTField>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public PTList() {
    }

    /**
     *
     * @param id
     * @param name
     * @param PTFields
     */
    public PTList(String id, String name, List<PTField> PTFields) {
        this.id = id;
        this.name = name;
        this.PTFields = PTFields;
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

    public PTList withId(String id) {
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

    public PTList withName(String name) {
        this.name = name;
        return this;
    }

    /**
     *
     * @return
     * The fields
     */
    @JsonProperty("fields")
    public List<PTField> getPTFields() {
        return PTFields;
    }

    /**
     *
     * @param PTFields
     * The fields
     */
    @JsonProperty("fields")
    public void setPTFields(List<PTField> PTFields) {
        this.PTFields = PTFields;
    }

    public PTList withFields(List<PTField> PTFields) {
        this.PTFields = PTFields;
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

    public PTList withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "PTList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fields=" + PTFields +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}