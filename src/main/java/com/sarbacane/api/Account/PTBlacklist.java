package com.sarbacane.api.Account;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by guru on 03/03/15.
 */
@JsonIgnoreProperties({"type"})
public class PTBlacklist extends AccountManager {
    private String type;
    private String identifier;


    public PTBlacklist(String type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public PTBlacklist() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}