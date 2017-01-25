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
public class PTCampaign {

    @JsonProperty("id")
    private String id;
    @JsonProperty("campaignId")
    private String campaignId;
    @JsonProperty("message")
    private String message;
    @JsonProperty("sendList")
    private PTSendList PTSendList;
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

    /**
     * No args constructor for use in serialization
     *
     */
    public PTCampaign() {
    }

    /**
     *
     * @param flash
     * @param keepList
     * @param state
     * @param cleanUnsubscribers
     * @param cleanBounces
     * @param type
     * @param date
     * @param totalCredits
     * @param id
     * @param campaignId
     * @param message
     * @param PTSendList
     * @param name
     * @param sourceAddress
     */
    public PTCampaign(String id, String campaignId, String message, PTSendList PTSendList, String state, String name, String type, String sourceAddress, Long date, Boolean flash, Boolean cleanBounces, Boolean cleanUnsubscribers, Boolean keepList, Double totalCredits) {
        this.id = id;
        this.campaignId = campaignId;
        this.message = message;
        this.PTSendList = PTSendList;
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

    public PTCampaign withId(String id) {
        this.id = id;
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

    public PTCampaign withCampaignId(String campaignId) {
        this.campaignId = campaignId;
        return this;
    }


    /**
     *
     * @return
     * The message
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    public PTCampaign withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     *
     * @return
     * The sendList
     */
    @JsonProperty("sendList")
    public PTSendList getPTSendList() {
        return PTSendList;
    }

    /**
     *
     * @param PTSendList
     * The sendList
     */
    @JsonProperty("sendList")
    public void setPTSendList(PTSendList PTSendList) {
        this.PTSendList = PTSendList;
    }

    public PTCampaign withSendList(PTSendList PTSendList) {
        this.PTSendList = PTSendList;
        return this;
    }

    /**
     *
     * @return
     * The state
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     * The state
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    public PTCampaign withState(String state) {
        this.state = state;
        return this;
    }

    /**
     *
     * @return
     * The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public PTCampaign withName(String name) {
        this.name = name;
        return this;
    }

    /**
     *
     * @return
     * The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public PTCampaign withType(String type) {
        this.type = type;
        return this;
    }

    /**
     *
     * @return
     * The sourceAddress
     */
    @JsonProperty("sourceAddress")
    public String getSourceAddress() {
        return sourceAddress;
    }

    /**
     *
     * @param sourceAddress
     * The sourceAddress
     */
    @JsonProperty("sourceAddress")
    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public PTCampaign withSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
        return this;
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

    public PTCampaign withDate(Long date) {
        this.date = date;
        return this;
    }

    /**
     *
     * @return
     * The flash
     */
    @JsonProperty("flash")
    public Boolean getFlash() {
        return flash;
    }

    /**
     *
     * @param flash
     * The flash
     */
    @JsonProperty("flash")
    public void setFlash(Boolean flash) {
        this.flash = flash;
    }

    public PTCampaign withFlash(Boolean flash) {
        this.flash = flash;
        return this;
    }

    /**
     *
     * @return
     * The cleanBounces
     */
    @JsonProperty("cleanBounces")
    public Boolean getCleanBounces() {
        return cleanBounces;
    }

    /**
     *
     * @param cleanBounces
     * The cleanBounces
     */
    @JsonProperty("cleanBounces")
    public void setCleanBounces(Boolean cleanBounces) {
        this.cleanBounces = cleanBounces;
    }

    public PTCampaign withCleanBounces(Boolean cleanBounces) {
        this.cleanBounces = cleanBounces;
        return this;
    }

    /**
     *
     * @return
     * The cleanUnsubscribers
     */
    @JsonProperty("cleanUnsubscribers")
    public Boolean getCleanUnsubscribers() {
        return cleanUnsubscribers;
    }

    /**
     *
     * @param cleanUnsubscribers
     * The cleanUnsubscribers
     */
    @JsonProperty("cleanUnsubscribers")
    public void setCleanUnsubscribers(Boolean cleanUnsubscribers) {
        this.cleanUnsubscribers = cleanUnsubscribers;
    }

    public PTCampaign withCleanUnsubscribers(Boolean cleanUnsubscribers) {
        this.cleanUnsubscribers = cleanUnsubscribers;
        return this;
    }

    /**
     *
     * @return
     * The keepList
     */
    @JsonProperty("keepList")
    public Boolean getKeepList() {
        return keepList;
    }

    /**
     *
     * @param keepList
     * The keepList
     */
    @JsonProperty("keepList")
    public void setKeepList(Boolean keepList) {
        this.keepList = keepList;
    }

    public PTCampaign withKeepList(Boolean keepList) {
        this.keepList = keepList;
        return this;
    }

    /**
     *
     * @return
     * The totalCredits
     */
    @JsonProperty("totalCredits")
    public Double getTotalCredits() {
        return totalCredits;
    }

    /**
     *
     * @param totalCredits
     * The totalCredits
     */
    @JsonProperty("totalCredits")
    public void setTotalCredits(Double totalCredits) {
        this.totalCredits = totalCredits;
    }

    public PTCampaign withTotalCredits(Double totalCredits) {
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

    public PTCampaign withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "PTCampaign{" +
                "id='" + id + '\'' +
                ", campaignId='" + campaignId + '\'' +
                ", message='" + message + '\'' +
                ", PTSendList=" + PTSendList +
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