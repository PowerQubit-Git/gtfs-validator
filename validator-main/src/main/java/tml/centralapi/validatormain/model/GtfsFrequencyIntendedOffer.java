package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.annotation.*;
import org.mobilitydata.gtfsvalidator.table.GtfsPassengerCounting;
import org.mobilitydata.gtfsvalidator.table.GtfsPropulsion;
import org.mobilitydata.gtfsvalidator.table.GtfsTypology;
import org.mobilitydata.gtfsvalidator.table.GtfsVideoSurveillance;
import org.mobilitydata.gtfsvalidator.type.GtfsTime;

public class GtfsFrequencyIntendedOffer {

    private String tripId;
    private GtfsTime startTime;
    private GtfsTime endTime;
    private int frequency;
    private GtfsTypology typology;
    private GtfsPropulsion propulsion;
    private GtfsPassengerCounting passengerCounting;
    private GtfsVideoSurveillance videoSurveillance;

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public GtfsTime getStartTime() {
        return startTime;
    }

    public void setStartTime(GtfsTime startTime) {
        this.startTime = startTime;
    }

    public GtfsTime getEndTime() {
        return endTime;
    }

    public void setEndTime(GtfsTime endTime) {
        this.endTime = endTime;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public GtfsTypology getTypology() {
        return typology;
    }

    public void setTypology(GtfsTypology typology) {
        this.typology = typology;
    }

    public GtfsPropulsion getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(GtfsPropulsion propulsion) {
        this.propulsion = propulsion;
    }

    public GtfsPassengerCounting getPassengerCounting() {
        return passengerCounting;
    }

    public void setPassengerCounting(GtfsPassengerCounting passengerCounting) {
        this.passengerCounting = passengerCounting;
    }

    public GtfsVideoSurveillance getVideoSurveillance() {
        return videoSurveillance;
    }

    public void setVideoSurveillance(GtfsVideoSurveillance videoSurveillance) {
        this.videoSurveillance = videoSurveillance;
    }

}
