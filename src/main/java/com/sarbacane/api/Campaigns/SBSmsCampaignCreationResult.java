package com.sarbacane.api.Campaigns;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "id"
})
public class SBSmsCampaignCreationResult {

    @JsonProperty("id")
    private String id;

    public SBSmsCampaignCreationResult() {
    }


    public SBSmsCampaignCreationResult(String campaignId, String id, String creditsUsed) {
           this.id = id;
       }




    @JsonProperty("id")
    public String getId() {
        return id;
    }


    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public SBSmsCampaignCreationResult withId(String id) {
        this.id = id;
        return this;
    }




    @Override
    public String toString() {
        return "PTResult{" +
                ", id='" + id + '\'' +
                '}';
    }
}