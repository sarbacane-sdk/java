package com.sarbacane.api.Contacts;

import com.sarbacane.api.Lists.ListsManager;

public class SBSmsIdentifier extends ListsManager{

    public boolean international;
    public String rawIdentifier;
    public String formattedIdentifier;
    public String status;

    public boolean isInternational() {
        return international;
    }

    public void setInternational(boolean international) {
        this.international = international;
    }

    public String getRawIdentifier() {
        return rawIdentifier;
    }

    public void setRawIdentifier(String rawIdentifier) {
        this.rawIdentifier = rawIdentifier;
    }

    public String getFormattedIdentifier() {
        return formattedIdentifier;
    }

    public void setFormattedIdentifier(String formattedIdentifier) {
        this.formattedIdentifier = formattedIdentifier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SBSmsIdentifier{" +
                "international=" + international +
                ", rawIdentifier='" + rawIdentifier + '\'' +
                ", formattedIdentifier='" + formattedIdentifier + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
