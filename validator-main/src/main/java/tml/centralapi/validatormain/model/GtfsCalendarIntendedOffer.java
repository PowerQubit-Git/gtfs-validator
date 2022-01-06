package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.annotation.*;
import org.mobilitydata.gtfsvalidator.table.GtfsCalendarService;
import org.mobilitydata.gtfsvalidator.type.GtfsDate;

public class GtfsCalendarIntendedOffer {

    private String serviceId;
    private String calendarName;
    private String period;
    private GtfsCalendarService monday;
    private GtfsCalendarService tuesday;
    private GtfsCalendarService wednesday;
    private GtfsCalendarService thursday;
    private GtfsCalendarService friday;
    private GtfsCalendarService saturday;
    private GtfsCalendarService sunday;
    private GtfsDate startDate;
    private GtfsDate endDate;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public GtfsCalendarService getMonday() {
        return monday;
    }

    public void setMonday(GtfsCalendarService monday) {
        this.monday = monday;
    }

    public GtfsCalendarService getTuesday() {
        return tuesday;
    }

    public void setTuesday(GtfsCalendarService tuesday) {
        this.tuesday = tuesday;
    }

    public GtfsCalendarService getWednesday() {
        return wednesday;
    }

    public void setWednesday(GtfsCalendarService wednesday) {
        this.wednesday = wednesday;
    }

    public GtfsCalendarService getThursday() {
        return thursday;
    }

    public void setThursday(GtfsCalendarService thursday) {
        this.thursday = thursday;
    }

    public GtfsCalendarService getFriday() {
        return friday;
    }

    public void setFriday(GtfsCalendarService friday) {
        this.friday = friday;
    }

    public GtfsCalendarService getSaturday() {
        return saturday;
    }

    public void setSaturday(GtfsCalendarService saturday) {
        this.saturday = saturday;
    }

    public GtfsCalendarService getSunday() {
        return sunday;
    }

    public void setSunday(GtfsCalendarService sunday) {
        this.sunday = sunday;
    }

    public GtfsDate getStartDate() {
        return startDate;
    }

    public void setStartDate(GtfsDate startDate) {
        this.startDate = startDate;
    }

    public GtfsDate getEndDate() {
        return endDate;
    }

    public void setEndDate(GtfsDate endDate) {
        this.endDate = endDate;
    }
}
