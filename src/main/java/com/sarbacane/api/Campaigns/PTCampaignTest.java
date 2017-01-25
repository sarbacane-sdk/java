package com.sarbacane.api.Campaigns;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sarbacane.api.Base.BaseManager;


/**
 * Created by guru on 06/10/15.
 */
@JsonIgnoreProperties({"id"})
public class PTCampaignTest extends BaseManager {
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
