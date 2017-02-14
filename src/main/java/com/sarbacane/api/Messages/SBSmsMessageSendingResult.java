package com.sarbacane.api.Messages;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "snapshotId",
        "id",
        "creditsUsed"
})
public class SBSmsMessageSendingResult {

    @JsonProperty("snapshotId")
    private Long snapshotId;
    @JsonProperty("id")
    private String id;
    @JsonProperty("creditsUsed")
    private String creditsUsed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public SBSmsMessageSendingResult() {
    }


    public SBSmsMessageSendingResult(Long snapshotId, String id, String creditsUsed) {
        this.snapshotId = snapshotId;
        this.id = id;
        this.creditsUsed = creditsUsed;
    }


    @JsonProperty("snapshotId")
    public Long getsnapshotId() {
        return snapshotId;
    }


    @JsonProperty("snapshotId")
    public void setsnapshotId(Long snapshotId) {
        this.snapshotId = snapshotId;
    }

    public SBSmsMessageSendingResult withsnapshotId(Long snapshotId) {
        this.snapshotId = snapshotId;
        return this;
    }


    @JsonProperty("id")
    public String getId() {
        return id;
    }


    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public SBSmsMessageSendingResult withId(String id) {
        this.id = id;
        return this;
    }


    @JsonProperty("creditsUsed")
    public String getCreditsUsed() {
        return creditsUsed;
    }


    @JsonProperty("creditsUsed")
    public void setCreditsUsed(String creditsUsed) {
        this.creditsUsed = creditsUsed;
    }

    public SBSmsMessageSendingResult withCreditsUsed(String creditsUsed) {
        this.creditsUsed = creditsUsed;
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

    public SBSmsMessageSendingResult withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "PTResult{" +
                "snapshotId='" + snapshotId + '\'' +
                ", id='" + id + '\'' +
                ", creditsUsed='" + creditsUsed + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}