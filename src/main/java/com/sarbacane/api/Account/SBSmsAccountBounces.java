package com.sarbacane.api.Account;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "id",
        "deleted",
        "identifier",
        "blacklistId",
        "history"
})
public class SBSmsAccountBounces {

    @JsonProperty("id")
    private String id;
    @JsonProperty("deleted")
    private Boolean deleted;
    @JsonProperty("identifier")
    private String identifier;
    @JsonProperty("blacklistId")
    private String blacklistId;
    @JsonProperty("history")
    private List<SBSmsBlacklistHistory> SBSmsBlacklistHistory = new ArrayList<SBSmsBlacklistHistory>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public SBSmsAccountBounces() {
    }


    public SBSmsAccountBounces(String id, Boolean deleted, String identifier, String blacklistId, List<SBSmsBlacklistHistory> SBSmsBlacklistHistory) {
        this.id = id;
        this.deleted = deleted;
        this.identifier = identifier;
        this.blacklistId = blacklistId;
        this.SBSmsBlacklistHistory = SBSmsBlacklistHistory;
    }


    @JsonProperty("id")
    public String getId() {
        return id;
    }


    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public SBSmsAccountBounces withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("deleted")
    public Boolean getDeleted() {
        return deleted;
    }


    @JsonProperty("deleted")
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public SBSmsAccountBounces withDeleted(Boolean deleted) {
        this.deleted = deleted;
        return this;
    }


    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }


    @JsonProperty("identifier")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public SBSmsAccountBounces withIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    @JsonProperty("blacklistId")
    public String getBlacklistId() {
        return blacklistId;
    }


    @JsonProperty("blacklistId")
    public void setBlacklistId(String blacklistId) {
        this.blacklistId = blacklistId;
    }

    public SBSmsAccountBounces withBlacklistId(String blacklistId) {
        this.blacklistId = blacklistId;
        return this;
    }


    @JsonProperty("history")
    public List<SBSmsBlacklistHistory> getSBSmsBlacklistHistory() {
        return SBSmsBlacklistHistory;
    }


    @JsonProperty("history")
    public void setSBSmsBlacklistHistory(List<SBSmsBlacklistHistory> SBSmsBlacklistHistory) {
        this.SBSmsBlacklistHistory = SBSmsBlacklistHistory;
    }

    public SBSmsAccountBounces withHistory(List<SBSmsBlacklistHistory> SBSmsBlacklistHistory) {
        this.SBSmsBlacklistHistory = SBSmsBlacklistHistory;
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

    public SBSmsAccountBounces withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "PTBounce{" +
                "id='" + id + '\'' +
                ", deleted=" + deleted +
                ", identifier='" + identifier + '\'' +
                ", blacklistId='" + blacklistId + '\'' +
                ", PTHistory=" + SBSmsBlacklistHistory +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}