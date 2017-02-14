package com.sarbacane.api.Campaigns;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "id",
        "campaignId",
        "message",
        "sendList",
        "state",
        "name",
        "type",
        "sourceAddress",
        "date",
        "flash",
        "cleanBounces",
        "cleanUnsubscribers",
        "keepList",
        "totalCredits"
})
public class SBSmsCampaign {

    @JsonProperty("id")
    private String id;
    @JsonProperty("campaignId")
    private String campaignId;
    @JsonProperty("message")
    private String message;
    @JsonProperty("sendList")
    private SBSmsCampaignSendList SBSmsCampaignSendList;
    @JsonProperty("state")
    private String state;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("sourceAddress")
    private String sourceAddress;
    @JsonProperty("date")
    private Long date;
    @JsonProperty("flash")
    private Boolean flash;
    @JsonProperty("cleanBounces")
    private Boolean cleanBounces;
    @JsonProperty("cleanUnsubscribers")
    private Boolean cleanUnsubscribers;
    @JsonProperty("keepList")
    private Boolean keepList;
    @JsonProperty("totalCredits")
    private Double totalCredits;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public SBSmsCampaign() {
    }


    public SBSmsCampaign(String id, String campaignId, String message, SBSmsCampaignSendList SBSmsCampaignSendList, String state, String name, String type, String sourceAddress, Long date, Boolean flash, Boolean cleanBounces, Boolean cleanUnsubscribers, Boolean keepList, Double totalCredits) {
        this.id = id;
        this.campaignId = campaignId;
        this.message = message;
        this.SBSmsCampaignSendList = SBSmsCampaignSendList;
        this.state = state;
        this.name = name;
        this.type = type;
        this.sourceAddress = sourceAddress;
        this.date = date;
        this.flash = flash;
        this.cleanBounces = cleanBounces;
        this.cleanUnsubscribers = cleanUnsubscribers;
        this.keepList = keepList;
        this.totalCredits = totalCredits;
    }


    @JsonProperty("id")
    public String getId() {
        return id;
    }


    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public SBSmsCampaign withId(String id) {
        this.id = id;
        return this;
    }


    @JsonProperty("campaignId")
    public String getCampaignId() {
        return campaignId;
    }


    @JsonProperty("campaignId")
    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public SBSmsCampaign withCampaignId(String campaignId) {
        this.campaignId = campaignId;
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

    public SBSmsCampaign withMessage(String message) {
        this.message = message;
        return this;
    }


    @JsonProperty("sendList")
    public SBSmsCampaignSendList getSBSmsCampaignSendList() {
        return SBSmsCampaignSendList;
    }


    @JsonProperty("sendList")
    public void setSBSmsCampaignSendList(SBSmsCampaignSendList SBSmsCampaignSendList) {
        this.SBSmsCampaignSendList = SBSmsCampaignSendList;
    }

    public SBSmsCampaign withSendList(SBSmsCampaignSendList SBSmsCampaignSendList) {
        this.SBSmsCampaignSendList = SBSmsCampaignSendList;
        return this;
    }


    @JsonProperty("state")
    public String getState() {
        return state;
    }


    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    public SBSmsCampaign withState(String state) {
        this.state = state;
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

    public SBSmsCampaign withName(String name) {
        this.name = name;
        return this;
    }


    @JsonProperty("type")
    public String getType() {
        return type;
    }


    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public SBSmsCampaign withType(String type) {
        this.type = type;
        return this;
    }


    @JsonProperty("sourceAddress")
    public String getSourceAddress() {
        return sourceAddress;
    }


    @JsonProperty("sourceAddress")
    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public SBSmsCampaign withSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
        return this;
    }


    @JsonProperty("date")
    public Long getDate() {
        return date;
    }


    @JsonProperty("date")
    public void setDate(Long date) {
        this.date = date;
    }

    public SBSmsCampaign withDate(Long date) {
        this.date = date;
        return this;
    }


    @JsonProperty("flash")
    public Boolean getFlash() {
        return flash;
    }


    @JsonProperty("flash")
    public void setFlash(Boolean flash) {
        this.flash = flash;
    }

    public SBSmsCampaign withFlash(Boolean flash) {
        this.flash = flash;
        return this;
    }


    @JsonProperty("cleanBounces")
    public Boolean getCleanBounces() {
        return cleanBounces;
    }


    @JsonProperty("cleanBounces")
    public void setCleanBounces(Boolean cleanBounces) {
        this.cleanBounces = cleanBounces;
    }

    public SBSmsCampaign withCleanBounces(Boolean cleanBounces) {
        this.cleanBounces = cleanBounces;
        return this;
    }


    @JsonProperty("cleanUnsubscribers")
    public Boolean getCleanUnsubscribers() {
        return cleanUnsubscribers;
    }


    @JsonProperty("cleanUnsubscribers")
    public void setCleanUnsubscribers(Boolean cleanUnsubscribers) {
        this.cleanUnsubscribers = cleanUnsubscribers;
    }

    public SBSmsCampaign withCleanUnsubscribers(Boolean cleanUnsubscribers) {
        this.cleanUnsubscribers = cleanUnsubscribers;
        return this;
    }


    @JsonProperty("keepList")
    public Boolean getKeepList() {
        return keepList;
    }


    @JsonProperty("keepList")
    public void setKeepList(Boolean keepList) {
        this.keepList = keepList;
    }

    public SBSmsCampaign withKeepList(Boolean keepList) {
        this.keepList = keepList;
        return this;
    }


    @JsonProperty("totalCredits")
    public Double getTotalCredits() {
        return totalCredits;
    }


    @JsonProperty("totalCredits")
    public void setTotalCredits(Double totalCredits) {
        this.totalCredits = totalCredits;
    }

    public SBSmsCampaign withTotalCredits(Double totalCredits) {
        this.totalCredits = totalCredits;
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

    public SBSmsCampaign withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "PTCampaign{" +
                "id='" + id + '\'' +
                ", campaignId='" + campaignId + '\'' +
                ", message='" + message + '\'' +
                ", PTSendList=" + SBSmsCampaignSendList +
                ", state='" + state + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", sourceAddress='" + sourceAddress + '\'' +
                ", date=" + date +
                ", flash=" + flash +
                ", cleanBounces=" + cleanBounces +
                ", cleanUnsubscribers=" + cleanUnsubscribers +
                ", keepList=" + keepList +
                ", totalCredits=" + totalCredits +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}