package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.table.GtfsCalendarService;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "calendar")
public class Calendar {

    @Column(name = "FeedId")
    private String feedId;

    @Id
    @Column(name = "ServiceId")
    private String serviceId;

    @Column(name = "CalendarName")
    private String calendarName;

    @Column(name = "Period")
    private String period;

    @Column(name = "Monday")
    private GtfsCalendarService monday;

    @Column(name = "Tuesday")
    private GtfsCalendarService tuesday;

    @Column(name = "Wednesday")
    private GtfsCalendarService wednesday;

    @Column(name = "Thursday")
    private GtfsCalendarService thursday;

    @Column(name = "Friday")
    private GtfsCalendarService friday;

    @Column(name = "Saturday")
    private GtfsCalendarService saturday;

    @Column(name = "Sunday")
    private GtfsCalendarService sunday;

    @Column(name = "StartDate")
    private LocalDate startDate;

    @Column(name = "EndDate")
    private LocalDate endDate;

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getFeedId() { return feedId; }
    public void setFeedId(String feedId) { this.feedId = feedId; }
}
