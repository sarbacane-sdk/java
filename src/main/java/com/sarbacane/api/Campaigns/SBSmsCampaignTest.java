package com.sarbacane.api.Campaigns;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sarbacane.api.Base.BaseManager;


@JsonIgnoreProperties({"id"})
public class SBSmsCampaignTest extends BaseManager {
    private String id;
    private String identifier;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

}
