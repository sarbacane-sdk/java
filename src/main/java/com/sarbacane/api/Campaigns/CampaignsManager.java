package com.sarbacane.api.Campaigns;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sarbacane.api.Authentication.AuthenticationManager;
import com.sarbacane.api.Base.BaseManager;

import java.io.IOException;
import java.util.List;

/**
 * Created by guru on 06/10/15.
 */
// CAMPAIGNS
    // campaignsCreate
    // campaignsTest
    // campaignsSend
    // campaignsStats
    // campaignsBlacklists
public class CampaignsManager extends BaseManager {

    private static ObjectMapper mapper = new ObjectMapper();

    public static PTResult campaignsMarketingCreate(PTCampaign campaign) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(campaign.getName()) || (!isSet(campaign.getMessage())) || ("null".equals(campaign.getPTSendList()))) {
            throw new RuntimeException("Error: name, message and sendList are required.\n");
        } else {
            if (!isSet(campaign.getType())) {
                campaign.setType("STANDARD");
            }
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(campaign);
            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/marketing/campaigns", json), PTResult.class);
        }
    }

    public static PTResult campaignsNotificationCreate(PTCampaign campaign) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(campaign.getName()) || (!isSet(campaign.getMessage())) || ("null".equals(campaign.getPTSendList()))) {
            throw new RuntimeException("Error: name, message and sendList are required.\n");
        } else {
            if (!isSet(campaign.getType())) {
                campaign.setType("STANDARD");
            }
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(campaign);
            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/marketing/campaigns", json), PTResult.class);
        }
    }

    public static PTCampaign campaignsGet(String campaignId) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(campaignId)) {
            throw new RuntimeException("Error: You need to specify the campaignId.\n");
        } else {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/campaigns/" + campaignId), PTCampaign.class);
        }
    }

    public static List<PTCampaign> campaignsGet() throws IOException {
        AuthenticationManager.ensureLogin();
        return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/campaigns/"), new TypeReference<List<PTCampaign>>() {});
    }

    public static PTResult campaignsTest(String campaignId, String identifier) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(campaignId) || (!isSet(identifier))) {
            throw new RuntimeException("Error: campaignId and identifierare required.\n");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String json = "{\"identifier\": \"" + identifier + "\"}" ;
            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/campaigns/" + campaignId + "/test", json), PTResult.class);
        }
    }

    public static PTResult campaignsSend(String campaignId) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(campaignId)) {
            throw new RuntimeException("Error: campaignId is required.\n");
        } else {
            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/campaigns/" + campaignId + "/send", "SEND"), PTResult.class);
        }
    }

    public static PTCampaignStats campaignsStats(String campaignId) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(campaignId)) {
            throw new RuntimeException("Error: You need to specify the campaignId.\n");
        } else {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/campaigns/" + campaignId + "/status"), PTCampaignStats.class);
        }
    }

    public static List<PTCampaignReply> campaignsReplies(String campaignId) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(campaignId)) {
            throw new RuntimeException("Error: You need to specify the campaignId.\n");
        } else {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/campaigns/" + campaignId + "/replies"), new TypeReference<List<PTCampaignReply>>() {});
        }
    }

    public static PTCampaignBlacklists campaignsBlacklists(String campaignId) throws IOException {
        AuthenticationManager.ensureLogin();
        if (!isSet(campaignId)) {
            throw new RuntimeException("Error: You need to specify the campaignId.\n");
        } else {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/campaigns/" + campaignId + "/blacklists"), PTCampaignBlacklists.class);
        }
    }
}
