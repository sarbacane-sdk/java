package com.sarbacane.api.Messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by guru on 08/04/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PTReplies {
    private String id;
    private String identifier;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PTMessageRepliesResponse{" +
                "id='" + id + '\'' +
                ", identifier='" + identifier + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
