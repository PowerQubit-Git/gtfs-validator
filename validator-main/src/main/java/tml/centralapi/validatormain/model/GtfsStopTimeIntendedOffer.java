package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.annotation.*;
import org.mobilitydata.gtfsvalidator.table.GtfsContinuousPickupDropOff;
import org.mobilitydata.gtfsvalidator.table.GtfsStopTimeTimepoint;
import org.mobilitydata.gtfsvalidator.type.GtfsTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StopTimeIntendedOffer")
public class GtfsStopTimeIntendedOffer {

    @Id
    @Column(name = "TripId")
    private String tripId;

    @Column(name = "ArrivalTime")
    private GtfsTime arrivalTime;

    @Column(name = "DepartureTime")
    private GtfsTime departureTime;

    @Id
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
