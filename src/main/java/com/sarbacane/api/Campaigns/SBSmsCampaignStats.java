package com.sarbacane.api.Campaigns;

/**
 * Created by guru on 08/04/15.
 */


public class SBSmsCampaignStats {
    private String id;
    private String name;
    private String state;
    private Integer sent;
    private Integer submitted;
    private Integer delivered;
    private Integer undelivered;
    private Integer bounces;
    private Integer unsubscribers;
    private Integer creditsUsed;
    private Integer clickers;
    private Integer clicks;
    private Integer opens;
    private Integer openers;
    private Integer errors;
    private Integer complaint;
    private Integer timespent;
    private Integer replies;

    public String getId() { return id;}

    public void setId(String id) { this.id = id; }

    public String getName() { return name;}

    public void setName(String name) { this.name = name;}

    public String getState() { return state;}

    public void setState(String state) { this.state = state;}

    public Integer getSent() {
        return sent;
    }

    public void setSent(Integer sent) {
        this.sent = sent;
    }

    public Integer getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Integer submitted) {
        this.submitted = submitted;
    }

    public Integer getDelivered() {
        return delivered;
    }

    public void setDelivered(Integer delivered) {
        this.delivered = delivered;
    }

    public Integer getUndelivered() {
        return undelivered;
    }

    public void setUndelivered(Integer undelivered) {
        this.undelivered = undelivered;
    }

    public Integer getBounces() {
        return bounces;
    }

    public void setBounces(Integer bounces) {
        this.bounces = bounces;
    }

    public Integer getUnsubscribers() {
        return unsubscribers;
    }

    public void setUnsubscribers(Integer unsubscribers) {
        this.unsubscribers = unsubscribers;
    }

    public Integer getCreditsUsed() {
        return creditsUsed;
    }

    public void setCreditsUsed(Integer creditsUsed) {
        this.creditsUsed = creditsUsed;
    }

    public Integer getClickers() {
        return clickers;
    }

    public void setClickers(Integer clickers) {
        this.clickers = clickers;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public Integer getOpens() {
        return opens;
    }

    public void setOpens(Integer opens) {
        this.opens = opens;
    }

    public Integer getOpeners() {
        return openers;
    }

    public void setOpeners(Integer openers) {
        this.openers = openers;
    }

    public Integer getErrors() {
        return errors;
    }

    public void setErrors(Integer errors) {
        this.errors = errors;
    }

    public Integer getComplaint() {
        return complaint;
    }

    public void setComplaint(Integer complaint) {
        this.complaint = complaint;
    }

    public Integer getTimespent() {
        return timespent;
    }

    public void setTimespent(Integer timespent) {
        this.timespent = timespent;
    }

    public Integer getReplies() {
        return replies;
    }

    public void setReplies(Integer replies) {
        this.replies = replies;
    }

    @Override
    public String toString() {
        return "PTCampaignStats{" +
                "id=" + id +
                ", name=" + name +
                ", state=" + state +
                ", creditsUsed=" + creditsUsed +
                ", sent=" + sent +
                ", submitted=" + submitted +
                ", delivered=" + delivered +
                ", undelivered=" + undelivered +
                ", openers=" + openers +
                ", clickers=" + clickers +
                ", clicks=" + clicks +
                ", opens=" + opens +
                ", replies=" + replies +
                ", unsubscribers=" + unsubscribers +
                ", errors=" + errors +
                ", bounces=" + bounces +
                ", complaint=" + complaint +
                ", timespent=" + timespent +
                '}';
    }
}

