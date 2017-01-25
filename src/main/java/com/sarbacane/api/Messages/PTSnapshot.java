package com.sarbacane.api.Messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by guru on 08/04/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PTSnapshot {
    private Long delivered;
    private Integer id;
    private Long sent;
    private String state;
    private Long stateDate;
    private Long submitted;
    private Long reply;
    private String test;

    public PTSnapshot(){}

    public Long getDelivered() {
        return delivered;
    }

    public void setDelivered(Long delivered) {
        this.delivered = delivered;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSent() {
        return sent;
    }

    public void setSent(Long sent) {
        this.sent = sent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getStateDate() {
        return stateDate;
    }

    public void setStateDate(Long stateDate) {
        this.stateDate = stateDate;
    }

    public Long getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Long submitted) {
        this.submitted = submitted;
    }

    public Long getReply() {
        return reply;
    }

    public void setReply(Long reply) {
        this.reply = reply;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "PTSnapshot{" +
                "delivered=" + delivered +
                ", id=" + id +
                ", sent=" + sent +
                ", state='" + state + '\'' +
                ", stateDate=" + stateDate +
                ", submitted=" + submitted +
                ", reply=" + reply +
                ", test='" + test + '\'' +
                '}';
    }
}
