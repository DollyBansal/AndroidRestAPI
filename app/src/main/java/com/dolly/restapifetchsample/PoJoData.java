package com.dolly.restapifetchsample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Dolly on 1/16/18.
 */

public class PoJoData {
    @SerializedName("contacts")
    @Expose
    private ArrayList<PoJoDataNext> contacts = new ArrayList<>();

    /**
     * @return The contacts
     */
    public ArrayList<PoJoDataNext> getContacts() {
        return contacts;
    }

    /**
     * @param contacts The contacts
     */
    public void setContacts(ArrayList<PoJoDataNext> contacts) {
        this.contacts = contacts;
    }
}

