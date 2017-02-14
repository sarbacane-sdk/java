package com.sarbacane.api.Account;

public class SBSmsAccount extends AccountManager {
    private Long credits;
    private Long delivered;
    private Long sent;
    private Long submitted;
    private Long undelivered;
    private Long unsubscribers;
    private Long bounces;

    public Long getBounces() {
        return bounces;
    }

    public void setBounces(Long bounces) {
        this.bounces = bounces;
    }


    public Long getCredits() {
        return credits;
    }

    public void setCredits(Long credits) {
        this.credits = credits;
    }

    public Long getDelivered() {
        return delivered;
    }

    public void setDelivered(Long delivered) {
        this.delivered = delivered;
    }

    public Long getSent() {
        return sent;
    }

    public void setSent(Long sent) {
        this.sent = sent;
    }

    public Long getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Long submitted) {
        this.submitted = submitted;
    }

    public Long getUndelivered() {
        return undelivered;
    }

    public void setUndelivered(Long undelivered) {
        this.undelivered = undelivered;
    }

    public Long getUnsubscribers() {
        return unsubscribers;
    }

    public void setUnsubscribers(Long unsubscribers) {
        this.unsubscribers = unsubscribers;
    }


    @Override
    public String toString() {
        return "PTAccountStatsResponse{" +
                "credits=" + credits +
                ", delivered=" + delivered +
                ", sent=" + sent +
                ", submitted=" + submitted +
                ", undelivered=" + undelivered +
                ", unsubscribers=" + unsubscribers +
                '}';
    }
}
