package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.table.GtfsCalendarDateExceptionType;
import org.mobilitydata.gtfsvalidator.table.GtfsHoliday;
import org.mobilitydata.gtfsvalidator.table.GtfsPeriod;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "calendar_dates")
@IdClass(CsvRowFeedIdCompositeKey.class)
public class CalendarDate {

    @Column(name = "ServiceId")
    private String serviceId;

    @Column(name = "CalendarName")
    private String calendarName;

    @Column(name = "Holiday")
    private GtfsHoliday holiday;

    @Column(name = "Period")
    private GtfsPeriod period;

    @Column(name = "Date")
    private LocalDate date;

    @Id
    @Column(name = "FeedId")
    private String feedId;

    @Id
    @Column(name = "CsvRowNumber")
    private long csvRowNumber;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public GtfsCalendarDateExceptionType getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(GtfsCalendarDateExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    public String getFeedId() { return feedId; }
    public void setFeedId(String feedId) { this.feedId = feedId; }

    public long getCsvRowNumber() { return csvRowNumber; }
    public void setCsvRowNumber(long csvRowNumber) { this.csvRowNumber = csvRowNumber; }
}
