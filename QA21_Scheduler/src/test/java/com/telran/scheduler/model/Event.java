package com.telran.scheduler.model;

public class Event {
    private String eventTitle;
    private String eventType;
    private int breaks;
    private String wage;

    public Event setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
        return this;
    }

    public Event setEventType(String eventType) {
        this.eventType = eventType;
        return this;
    }

    public Event setBreaks(int breaks) {
        this.breaks = breaks;
        return this;
    }

    public Event setWage(String wage) {
        this.wage = wage;
        return this;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventType() {
        return eventType;
    }

    public int getBreaks() {
        return breaks;
    }

    public String getWage() {
        return wage;
    }
}
