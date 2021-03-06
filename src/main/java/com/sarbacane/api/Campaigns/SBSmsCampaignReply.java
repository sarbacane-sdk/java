package com.sarbacane.api.Campaigns;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "id",
        "identifier",
        "message"
})
public class SBSmsCampaignReply {

    @JsonProperty("id")
    private String id;
    @JsonProperty("identifier")
    private String identifier;
    @JsonProperty("message")
    private String message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public SBSmsCampaignReply() {
    }


    public SBSmsCampaignReply(String id, String identifier, String message) {
        this.id = id;
        this.identifier = identifier;
        this.message = message;
    }


    @JsonProperty("id")
    public String getId() {
        return id;
    }


    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public SBSmsCampaignReply withId(String id) {
        this.id = id;
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

    public SBSmsCampaignReply withIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }


    @JsonProperty("message")
    public String getMessage() {
        return message;
    }


    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    public SBSmsCampaignReply withMessage(String message) {
        this.message = message;
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

    public SBSmsCampaignReply withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "PTCampaignReply{" +
                "id='" + id + '\'' +
                ", identifier='" + identifier + '\'' +
                ", message='" + message + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}