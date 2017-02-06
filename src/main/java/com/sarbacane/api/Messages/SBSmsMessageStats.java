package com.sarbacane.api.Messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by guru on 08/04/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SBSmsMessageStats {
    private Integer sent;
    private Integer submitted;
    private Integer delivered;
    private Integer openers;
    private Integer clicks;
    private Integer clickers;
    private Integer opens;
    private Integer replies;
    private Integer unsubscribers;
    private Integer errors;
    private Integer bounced;
    private Integer complaint;
    private Integer timespent;

    public Integer getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Integer submitted) {
        this.submitted = submitted;
    }

    public Integer getSent() {
        return sent;
    }

    public void setSent(Integer sent) {
        this.sent = sent;
    }

    public Integer getDelivered() {
        return delivered;
    }

    public void setDelivered(Integer delivered) {
        this.delivered = delivered;
    }

    public Integer getOpeners() {
        return openers;
    }

    public void setOpeners(Integer openers) {
        this.openers = openers;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public Integer getClickers() {
        return clickers;
    }

    public void setClickers(Integer clickers) {
        this.clickers = clickers;
    }

    public Integer getOpens() {
        return opens;
    }

    public void setOpens(Integer opens) {
        this.opens = opens;
    }

    public Integer getReplies() {
        return replies;
    }

    public void setReplies(Integer replies) {
        this.replies = replies;
    }

    public Integer getUnsubscribers() {
        return unsubscribers;
    }

    public void setUnsubscribers(Integer unsubscribers) {
        this.unsubscribers = unsubscribers;
    }

    public Integer getErrors() {
        return errors;
    }

    public void setErrors(Integer errors) {
        this.errors = errors;
    }

    public Integer getBounced() {
        return bounced;
    }

    public void setBounced(Integer bounced) {
        this.bounced = bounced;
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

    @Override
    public String toString() {
        return "PTMessageStatsResponse{" +
                "sent=" + sent +
                ", submitted=" + submitted +
                ", delivered=" + delivered +
                ", openers=" + openers +
                ", clickers=" + clickers +
                ", clicks=" + clicks +
                ", opens=" + opens +
                ", replies=" + replies +
                ", unsubscribers=" + unsubscribers +
                ", errors=" + errors +
                ", bounced=" + bounced +
                ", complaint=" + complaint +
                ", timespent=" + timespent +
                '}';
    }
}

