package tml.centralapi.validatormain.model;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Document(collection = "IntendedOfferUploads")
public class IntendedOfferUpload {

    @Transient
    public static final String SEQUENCE_NAME = "raw_input_sequence";

    @Id
    private String id;

    private String publisherName;

    private Date uploadDate;

    private Notices validationReport;

    private Notices errorsReport;

    private List<TableResume> tableResumeList;

    private Binary file;

    private int csvAgency;
    private int csvCalendar;
    private int csvCalendarDates;
    private int csvFeedInfo;
    private int csvFrequencies;
    private int csvRoutes;
    private int csvShapes;
    private int csvStopTimes;
    private int csvStops;
    private int csvTrips;

    private int pgAgency;
    private int pgCalendar;
    private int pgCalendarDates;
    private int pgFeedInfo;
    private int pgFrequencies;
    private int pgRoutes;
    private int pgShapes;
    private int pgStopTimes;
    private int pgStops;
    private int pgTrips;

    public int getPgAgency() {
        return pgAgency;
    }

    public void setPgAgency(int pgAgency) {
        this.pgAgency = pgAgency;
    }

    public int getPgCalendar() {
        return pgCalendar;
    }

    public void setPgCalendar(int pgCalendar) {
        this.pgCalendar = pgCalendar;
    }

    public int getPgCalendarDates() {
        return pgCalendarDates;
    }

    public void setPgCalendarDates(int pgCalendarDates) {
        this.pgCalendarDates = pgCalendarDates;
    }

    public int getPgFeedInfo() {
        return pgFeedInfo;
    }

    public void setPgFeedInfo(int pgFeedInfo) {
        this.pgFeedInfo = pgFeedInfo;
    }

    public int getPgFrequencies() {
        return pgFrequencies;
    }

    public void setPgFrequencies(int pgFrequencies) {
        this.pgFrequencies = pgFrequencies;
    }

    public int getPgRoutes() {
        return pgRoutes;
    }

    public void setPgRoutes(int pgRoutes) {
        this.pgRoutes = pgRoutes;
    }

    public int getPgShapes() {
        return pgShapes;
    }

    public void setPgShapes(int pgShapes) {
        this.pgShapes = pgShapes;
    }

    public int getPgStopTimes() {
        return pgStopTimes;
    }

    public void setPgStopTimes(int pgStopTimes) {
        this.pgStopTimes = pgStopTimes;
    }

    public int getPgStops() {
        return pgStops;
    }

    public void setPgStops(int pgStops) {
        this.pgStops = pgStops;
    }

    public int getPgTrips() {
        return pgTrips;
    }

    public void setPgTrips(int pgTrips) {
        this.pgTrips = pgTrips;
    }

    public int getCsvAgency() {
        return csvAgency;
    }

    public void setCsvAgency(int csvAgency) {
        this.csvAgency = csvAgency;
    }

    public int getCsvCalendar() {
        return csvCalendar;
    }

    public void setCsvCalendar(int csvCalendar) {
        this.csvCalendar = csvCalendar;
    }

    public int getCsvCalendarDates() {
        return csvCalendarDates;
    }

    public void setCsvCalendarDates(int csvCalendarDates) {
        this.csvCalendarDates = csvCalendarDates;
    }

    public int getCsvFeedInfo() {
        return csvFeedInfo;
    }

    public void setCsvFeedInfo(int csvFeedInfo) {
        this.csvFeedInfo = csvFeedInfo;
    }

    public int getCsvFrequencies() {
        return csvFrequencies;
    }

    public void setCsvFrequencies(int csvFrequencies) {
        this.csvFrequencies = csvFrequencies;
    }

    public int getCsvRoutes() {
        return csvRoutes;
    }

    public void setCsvRoutes(int csvRoutes) {
        this.csvRoutes = csvRoutes;
    }

    public int getCsvShapes() {
        return csvShapes;
    }

    public void setCsvShapes(int csvShapes) {
        this.csvShapes = csvShapes;
    }

    public int getCsvStopTimes() {
        return csvStopTimes;
    }

    public void setCsvStopTimes(int csvStopTimes) {
        this.csvStopTimes = csvStopTimes;
    }

    public int getCsvStops() {
        return csvStops;
    }

    public void setCsvStops(int csvStops) {
        this.csvStops = csvStops;
    }

    public int getCsvTrips() {
        return csvTrips;
    }

    public void setCsvTrips(int csvTrips) {
        this.csvTrips = csvTrips;
    }


    public Binary getFile() {
        return file;
    }
    public void setFile(Binary file) {
        this.file = file;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Date getUploadDate() {
        return uploadDate;
    }
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Notices getValidationReport() {
        return validationReport;
    }
    public void setValidationReport(Notices validationReport) { this.validationReport = validationReport; }

    public Notices getErrorsReport() {
        return errorsReport;
    }
    public void setErrorsReport(Notices errorsReport) {
        this.errorsReport = errorsReport;
    }

    public List<TableResume> getTableResumeList() { return tableResumeList; }
    public void setTableResumeList(List<TableResume> tableResumeList) { this.tableResumeList = tableResumeList; }
}
