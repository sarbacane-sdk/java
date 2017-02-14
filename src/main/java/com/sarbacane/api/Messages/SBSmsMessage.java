package com.sarbacane.api.Messages;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)

public class SBSmsMessage extends MessagesManager {

    private long snapshotId;
    private long creditsUsed;
    private String type;
    private String number;
    private String message;
    private String sender;
    private String campaignName;
    private String category;

    public SBSmsMessage() {
    }

    @JsonCreator
    public SBSmsMessage(@JsonProperty("creditsUsed") long creditsUsed, @JsonProperty("snapshotId") long snapshotId) {
        this.creditsUsed = creditsUsed;
        this.snapshotId = snapshotId;
    }

    public long getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(long snapshotId) {
        this.snapshotId = snapshotId;
    }

    public long getCreditsUsed() {
        return creditsUsed;
    }

    public void setCreditsUsed(long creditsUsed) {
        this.creditsUsed = creditsUsed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "PTMessage{" +
                "snapshotId=" + snapshotId +
                ", creditsUsed=" + creditsUsed +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", message='" + message + '\'' +
                ", sender='" + sender + '\'' +
                ", campaignName='" + campaignName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
