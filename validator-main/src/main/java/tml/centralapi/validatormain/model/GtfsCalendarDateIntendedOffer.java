package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.annotation.*;
import org.mobilitydata.gtfsvalidator.table.GtfsCalendarDateExceptionType;
import org.mobilitydata.gtfsvalidator.table.GtfsHoliday;
import org.mobilitydata.gtfsvalidator.table.GtfsPeriod;
import org.mobilitydata.gtfsvalidator.type.GtfsDate;

public class GtfsCalendarDateIntendedOffer {

    private String serviceId;
    private String calendarName;
    private GtfsHoliday holiday;
    private GtfsPeriod period;
    private GtfsDate date;
    private GtfsCalendarDateExceptionType exceptionType;

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

    public GtfsHoliday getHoliday() {
        return holiday;
    }

    public void setHoliday(GtfsHoliday holiday) {
        this.holiday = holiday;
    }

    public GtfsPeriod getPeriod() {
        return period;
    }

    public void setPeriod(GtfsPeriod period) {
        this.period = period;
    }

    public GtfsDate getDate() {
        return date;
    }

    public void setDate(GtfsDate date) {
        this.date = date;
    }

    public GtfsCalendarDateExceptionType getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(GtfsCalendarDateExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

}
