package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.table.GtfsContinuousPickupDropOff;
import org.mobilitydata.gtfsvalidator.table.GtfsStopTimeTimepoint;

import javax.persistence.*;

@Entity
@Table(name = "stop_times")
@IdClass(CsvRowFeedIdCompositeKey.class)
public class StopTime {

    @Column(name = "TripId")
    private String tripId;

    @Column(name = "ArrivalTime")
    private String arrivalTime;

    @Column(name = "DepartureTime")
    private String departureTime;

    @Column(name = "StopId")
    private String stopId;

    @Column(name = "StopSequence")
    private int stopSequence;

    @Column(name = "StopHeadsign")
    private String stopHeadsign;

    @Column(name = "ContinuousPickup")
    private GtfsContinuousPickupDropOff continuousPickup;

    @Column(name = "ContinuousDropOff")
    private GtfsContinuousPickupDropOff continuousDropOff;

    @Column(name = "ShapeDistTraveled")
    private double shapeDistTraveled;

    @Column(name = "Timepoint")
    private GtfsStopTimeTimepoint timepoint;

    @Id
    @Column(name = "FeedId")
    private String feedId;

    @Id
    @Column(name = "CsvRowNumber")
    private long csvRowNumber;

    public String getTripId() {
        return tripId;
    }
    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getStopId() {
        return stopId;
    }
    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public int getStopSequence() {
        return stopSequence;
    }
    public void setStopSequence(int stopSequence) {
        this.stopSequence = stopSequence;
    }

    public String getStopHeadsign() {
        return stopHeadsign;
    }
    public void setStopHeadsign(String stopHeadsign) {
        this.stopHeadsign = stopHeadsign;
    }

    public GtfsContinuousPickupDropOff getContinuousPickup() {
        return continuousPickup;
    }
    public void setContinuousPickup(GtfsContinuousPickupDropOff continuousPickup) {
        this.continuousPickup = continuousPickup;
    }

    public GtfsContinuousPickupDropOff getContinuousDropOff() {
        return continuousDropOff;
    }
    public void setContinuousDropOff(GtfsContinuousPickupDropOff continuousDropOff) {
        this.continuousDropOff = continuousDropOff;
    }

    public double getShapeDistTraveled() {
        return shapeDistTraveled;
    }
    public void setShapeDistTraveled(double shapeDistTraveled) {
        this.shapeDistTraveled = shapeDistTraveled;
    }

    public GtfsStopTimeTimepoint getTimepoint() {
        return timepoint;
    }
    public void setTimepoint(GtfsStopTimeTimepoint timepoint) {
        this.timepoint = timepoint;
    }

    public String getFeedId() { return feedId; }
    public void setFeedId(String feedId) { this.feedId = feedId; }

    public long getCsvRowNumber() { return csvRowNumber; }
    public void setCsvRowNumber(long csvRowNumber) { this.csvRowNumber = csvRowNumber; }
}
