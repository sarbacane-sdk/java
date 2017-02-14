package com.sarbacane.api.Lists;

import com.fasterxml.jackson.annotation.*;
import com.sarbacane.api.Fields.SBSmsField;

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
public class SBSmsList {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("fields")
    private List<SBSmsField> SBSmsFields = new ArrayList<SBSmsField>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public SBSmsList() {
    }


    public SBSmsList(String id, String name, List<SBSmsField> SBSmsFields) {
        this.id = id;
        this.name = name;
        this.SBSmsFields = SBSmsFields;
    }


    @JsonProperty("id")
    public String getId() {
        return id;
    }


    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public SBSmsList withId(String id) {
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

    public SBSmsList withName(String name) {
        this.name = name;
        return this;
    }


    @JsonProperty("fields")
    public List<SBSmsField> getSBSmsFields() {
        return SBSmsFields;
    }


    @JsonProperty("fields")
    public void setSBSmsFields(List<SBSmsField> SBSmsFields) {
        this.SBSmsFields = SBSmsFields;
    }

    public SBSmsList withFields(List<SBSmsField> SBSmsFields) {
        this.SBSmsFields = SBSmsFields;
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

    public SBSmsList withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "PTList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fields=" + SBSmsFields +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}