package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.annotation.*;
import org.mobilitydata.gtfsvalidator.table.GtfsContinuousPickupDropOff;
import org.mobilitydata.gtfsvalidator.table.GtfsStopTimeTimepoint;
import org.mobilitydata.gtfsvalidator.type.GtfsTime;

public class GtfsStopTimeIntendedOffer {

    private String tripId;
    private GtfsTime arrivalTime;
    private GtfsTime departureTime;
    private String stopId;
    private int stopSequence;
    private String stopHeadsign;
    private GtfsContinuousPickupDropOff continuousPickup;
    private GtfsContinuousPickupDropOff continuousDropOff;
    private double shapeDistTraveled;
    private GtfsStopTimeTimepoint timepoint;

    public String getTripId() {
        return tripId;
    }
    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public GtfsTime getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(GtfsTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public GtfsTime getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(GtfsTime departureTime) {
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

}
