package com.sarbacane.api.Account;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "date",
        "campaignId"
})
public class PTHistory {

    @JsonProperty("date")
    private Long date;
    @JsonProperty("campaignId")
    private String campaignId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public PTHistory() {
    }

    /**
     *
     * @param campaignId
     * @param date
     */
    public PTHistory(Long date, String campaignId) {
        this.date = date;
        this.campaignId = campaignId;
    }

    /**
     *
     * @return
     * The date
     */
    @JsonProperty("date")
    public Long getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    @JsonProperty("date")
    public void setDate(Long date) {
        this.date = date;
    }

    public PTHistory withDate(Long date) {
        this.date = date;
        return this;
    }

    /**
     *
     * @return
     * The campaignId
     */
    @JsonProperty("campaignId")
    public String getCampaignId() {
        return campaignId;
    }

    /**
     *
     * @param campaignId
     * The campaignId
     */
    @JsonProperty("campaignId")
    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public PTHistory withCampaignId(String campaignId) {
        this.campaignId = campaignId;
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

    public PTHistory withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "PTHistory{" +
                "date=" + date +
                ", campaignId='" + campaignId + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}