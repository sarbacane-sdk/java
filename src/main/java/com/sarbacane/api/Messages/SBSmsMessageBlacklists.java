package com.sarbacane.api.Messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guru on 08/04/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class SBSmsMessageBlacklists {

    private Bounces bounces;
    private Unsubscribers unsubscribers;

    public Bounces getBounces() {
        return bounces;
    }

    public void setBounces(Bounces bounces) {
        this.bounces = bounces;
    }

    public Unsubscribers getUnsubscribers() {
        return unsubscribers;
    }

    public void setUnsubscribers(Unsubscribers unsubscribers) {
        this.unsubscribers = unsubscribers;
    }

    @Override
    public String toString() {
        return "PTMessageBlacklistsResponse{" +
                "bounces=" + bounces +
                ", unsubscribers=" + unsubscribers +
                '}';
    }


    public static class Bounces {

        private Integer number;
        private List<Object> identifiers = new ArrayList<Object>();

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public List<Object> getIdentifiers() {
            return identifiers;
        }

        public void setIdentifiers(List<Object> identifiers) {
            this.identifiers = identifiers;
        }

        @Override
        public String toString() {
            return "PTBounces{" +
                    "number=" + number +
                    ", identifiers=" + identifiers +
                    '}';
        }
    }

    public static class Unsubscribers {

        private Integer number;
        private List<Object> identifiers = new ArrayList<Object>();

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public List<Object> getIdentifiers() {
            return identifiers;
        }

        public void setIdentifiers(List<Object> identifiers) {
            this.identifiers = identifiers;
        }

        @Override
        public String toString() {
            return "PTUnsubscribers{" +
                    "number=" + number +
                    ", identifiers=" + identifiers +
                    '}';
        }
    }

}
