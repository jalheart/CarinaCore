/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.modeloftheself;

import carina.metacore.Event;
import carina.metacore.Profile;
import java.util.List;

/**
 *
 * @author jalheart
 */
public class ModelOfTheSelf {
    private List<Profile> profiles;
    private List<Event> events;
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
    /**
     * @return the profiles
     */
    public List<Profile> getProfiles() {
        return profiles;
    }

    /**
     * @param profiles the profiles to set
     */
    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }
    /**
     * @return the profile
     */
    public Profile getProfile(int i) {
        return profiles.get(i);
    }

    /**
     * @param profiles the profile to set
     */
    public void addProfile(Profile profile,int i) {
        if(this.profiles.size()<i){
            this.profiles.add(profile);
        }else{
            this.profiles.set(i, profile);            
        }
    }

    /**
     * @return the events
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * @param events the events to set
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }
    /**
     * @return the event
     */
    public Event getEvent(int i) {
        return this.events.get(i);
    }
    /**
     * @param event the event to set
     */
    public void addEvent(Event event,int i) {
        if(this.events.size()<i){
            this.events.add(event);
        }else{
            this.events.set(i, event);
        }
    }
    // </editor-fold>
}