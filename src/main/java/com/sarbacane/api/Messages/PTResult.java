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
public class PTResult {

    @JsonProperty("snapshotId")
    private Long snapshotId;
    @JsonProperty("id")
    private String id;
    @JsonProperty("creditsUsed")
    private String creditsUsed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public PTResult() {
    }

    /**
     *
     * @param id
     * @param snapshotId
     * @param creditsUsed
     */
    public PTResult(Long snapshotId, String id, String creditsUsed) {
        this.snapshotId = snapshotId;
        this.id = id;
        this.creditsUsed = creditsUsed;
    }

    /**
     *
     * @return
     * The snapshotId
     */
    @JsonProperty("snapshotId")
    public Long getsnapshotId() {
        return snapshotId;
    }

    /**
     *
     * @param snapshotId
     * The snapshotId
     */
    @JsonProperty("snapshotId")
    public void setsnapshotId(Long snapshotId) {
        this.snapshotId = snapshotId;
    }

    public PTResult withsnapshotId(Long snapshotId) {
        this.snapshotId = snapshotId;
        return this;
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

    public PTResult withId(String id) {
        this.id = id;
        return this;
    }

    /**
     *
     * @return
     * The creditsUsed
     */
    @JsonProperty("creditsUsed")
    public String getCreditsUsed() {
        return creditsUsed;
    }

    /**
     *
     * @param creditsUsed
     * The creditsUsed
     */
    @JsonProperty("creditsUsed")
    public void setCreditsUsed(String creditsUsed) {
        this.creditsUsed = creditsUsed;
    }

    public PTResult withCreditsUsed(String creditsUsed) {
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

    public PTResult withAdditionalProperty(String name, Object value) {
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