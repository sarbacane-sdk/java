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
public class PTUnsubscriber {

    @JsonProperty("id")
    private String id;
    @JsonProperty("deleted")
    private Boolean deleted;
    @JsonProperty("identifier")
    private String identifier;
    @JsonProperty("blacklistId")
    private String blacklistId;
    @JsonProperty("history")
    private List<PTHistory> PTHistory = new ArrayList<PTHistory>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public PTUnsubscriber() {
    }

    /**
     *
     * @param PTHistory
     * @param id
     * @param blacklistId
     * @param identifier
     * @param deleted
     */
    public PTUnsubscriber(String id, Boolean deleted, String identifier, String blacklistId, List<PTHistory> PTHistory) {
        this.id = id;
        this.deleted = deleted;
        this.identifier = identifier;
        this.blacklistId = blacklistId;
        this.PTHistory = PTHistory;
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

    public PTUnsubscriber withId(String id) {
        this.id = id;
        return this;
    }

    /**
     *
     * @return
     * The deleted
     */
    @JsonProperty("deleted")
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     *
     * @param deleted
     * The deleted
     */
    @JsonProperty("deleted")
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public PTUnsubscriber withDeleted(Boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    /**
     *
     * @return
     * The identifier
     */
    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }

    /**
     *
     * @param identifier
     * The identifier
     */
    @JsonProperty("identifier")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public PTUnsubscriber withIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    /**
     *
     * @return
     * The blacklistId
     */
    @JsonProperty("blacklistId")
    public String getBlacklistId() {
        return blacklistId;
    }

    /**
     *
     * @param blacklistId
     * The blacklistId
     */
    @JsonProperty("blacklistId")
    public void setBlacklistId(String blacklistId) {
        this.blacklistId = blacklistId;
    }

    public PTUnsubscriber withBlacklistId(String blacklistId) {
        this.blacklistId = blacklistId;
        return this;
    }

    /**
     *
     * @return
     * The history
     */
    @JsonProperty("history")
    public List<PTHistory> getPTHistory() {
        return PTHistory;
    }

    /**
     *
     * @param PTHistory
     * The history
     */
    @JsonProperty("history")
    public void setPTHistory(List<PTHistory> PTHistory) {
        this.PTHistory = PTHistory;
    }

    public PTUnsubscriber withHistory(List<PTHistory> PTHistory) {
        this.PTHistory = PTHistory;
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

    public PTUnsubscriber withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "PTUnsubscriber{" +
                "id='" + id + '\'' +
                ", deleted=" + deleted +
                ", identifier='" + identifier + '\'' +
                ", blacklistId='" + blacklistId + '\'' +
                ", PTHistory=" + PTHistory +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}