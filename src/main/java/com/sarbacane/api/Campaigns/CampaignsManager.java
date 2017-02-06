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

    public static SBSmsCampaignSendingResult campaignsMarketingCreate(SBSmsCampaign campaign) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(campaign.getName()) || (!isSet(campaign.getMessage())) || ("null".equals(campaign.getSBSmsCampaignSendList()))) {
            throw new RuntimeException("Error: name, message and sendList are required.\n");
        } else {
            if (!isSet(campaign.getType())) {
                campaign.setType("STANDARD");
            }
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(campaign);
            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/marketing/campaigns", json), SBSmsCampaignSendingResult.class);
        }
    }

    public static SBSmsCampaignSendingResult campaignsNotificationCreate(SBSmsCampaign campaign) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(campaign.getName()) || (!isSet(campaign.getMessage())) || ("null".equals(campaign.getSBSmsCampaignSendList()))) {
            throw new RuntimeException("Error: name, message and sendList are required.\n");
        } else {
            if (!isSet(campaign.getType())) {
                campaign.setType("STANDARD");
            }
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(campaign);
            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/marketing/campaigns", json), SBSmsCampaignSendingResult.class);
        }
    }

    public static SBSmsCampaign campaignsGet(String campaignId) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(campaignId)) {
            throw new RuntimeException("Error: You need to specify the campaignId.\n");
        } else {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/campaigns/" + campaignId), SBSmsCampaign.class);
        }
    }

    public static List<SBSmsCampaign> campaignsGet() throws IOException {
        AuthenticationManager.ensureSmsTokens();
        return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/campaigns/"), new TypeReference<List<SBSmsCampaign>>() {});
    }

    public static SBSmsCampaignSendingResult campaignsTest(String campaignId, String identifier) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(campaignId) || (!isSet(identifier))) {
            throw new RuntimeException("Error: campaignId and identifierare required.\n");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String json = "{\"identifier\": \"" + identifier + "\"}" ;
            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/campaigns/" + campaignId + "/test", json), SBSmsCampaignSendingResult.class);
        }
    }

    public static SBSmsCampaignSendingResult campaignsSend(String campaignId) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(campaignId)) {
            throw new RuntimeException("Error: campaignId is required.\n");
        } else {
            return mapper.readValue(BaseManager.httpPost(BaseManager.baseURL + "/campaigns/" + campaignId + "/send", "SEND"), SBSmsCampaignSendingResult.class);
        }
    }

    public static SBSmsCampaignStats campaignsStats(String campaignId) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(campaignId)) {
            throw new RuntimeException("Error: You need to specify the campaignId.\n");
        } else {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/campaigns/" + campaignId + "/status"), SBSmsCampaignStats.class);
        }
    }

    public static List<SBSmsCampaignReply> campaignsReplies(String campaignId) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(campaignId)) {
            throw new RuntimeException("Error: You need to specify the campaignId.\n");
        } else {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/campaigns/" + campaignId + "/replies"), new TypeReference<List<SBSmsCampaignReply>>() {});
        }
    }

    public static SBSmsCampaignBlacklists campaignsBlacklists(String campaignId) throws IOException {
        AuthenticationManager.ensureSmsTokens();
        if (!isSet(campaignId)) {
            throw new RuntimeException("Error: You need to specify the campaignId.\n");
        } else {
            return mapper.readValue(BaseManager.httpGet(BaseManager.baseURL + "/campaigns/" + campaignId + "/blacklists"), SBSmsCampaignBlacklists.class);
        }
    }
}
