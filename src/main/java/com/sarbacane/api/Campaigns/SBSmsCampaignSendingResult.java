package com.sarbacane.api.Campaigns;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "campaignId",
        "id",
        "creditsUsed"
})
public class SBSmsCampaignSendingResult {

    @JsonProperty("campaignId")
    private String campaignId;
    @JsonProperty("id")
    private String id;
    @JsonProperty("creditsUsed")
    private String creditsUsed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public SBSmsCampaignSendingResult() {
    }


    public SBSmsCampaignSendingResult(String campaignId, String id, String creditsUsed) {
        this.campaignId = campaignId;
        this.id = id;
        this.creditsUsed = creditsUsed;
    }


    @JsonProperty("campaignId")
    public String getCampaignId() {
        return campaignId;
    }


    @JsonProperty("campaignId")
    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public SBSmsCampaignSendingResult withCampaignId(String campaignId) {
        this.campaignId = campaignId;
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

    public SBSmsCampaignSendingResult withId(String id) {
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

    public SBSmsCampaignSendingResult withCreditsUsed(String creditsUsed) {
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

    public SBSmsCampaignSendingResult withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "PTResult{" +
                "campaignId='" + campaignId + '\'' +
                ", id='" + id + '\'' +
                ", creditsUsed='" + creditsUsed + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}