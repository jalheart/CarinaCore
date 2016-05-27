/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.objectlevel;

import carina.metacore.Event;
import carina.metacore.Profile;

/**
 *
 * @author jalheart
 */
public class ReasoningEvent extends Event{
    private Profile profile;
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
    /**
     * @return the profile
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * @param profile the profile to set
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    // </editor-fold>
}