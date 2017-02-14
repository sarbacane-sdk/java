package com.sarbacane.api.Account;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"type"})
public class SBSmsAccountBlacklists extends AccountManager {
    private String type;
    private String identifier;


    public SBSmsAccountBlacklists(String type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public SBSmsAccountBlacklists() {

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