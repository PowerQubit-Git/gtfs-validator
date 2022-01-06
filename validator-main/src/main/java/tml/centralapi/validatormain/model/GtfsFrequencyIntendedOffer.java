package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.annotation.*;
import org.mobilitydata.gtfsvalidator.table.GtfsPassengerCounting;
import org.mobilitydata.gtfsvalidator.table.GtfsPropulsion;
import org.mobilitydata.gtfsvalidator.table.GtfsTypology;
import org.mobilitydata.gtfsvalidator.table.GtfsVideoSurveillance;
import org.mobilitydata.gtfsvalidator.type.GtfsTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FrequencyIntendedOffer")
public class GtfsFrequencyIntendedOffer {

    @Id
    @Column(name = "TripId")
    private String tripId;

    @Column(name = "StartTime")
    private GtfsTime startTime;

    @Column(name = "EndTime")
    private GtfsTime endTime;

    @Column(name = "Frequency")
    private int frequency;

    @Column(name = "Typology")
    private GtfsTypology typology;

    @Column(name = "Propulsion")
    private GtfsPropulsion propulsion;

    @Column(name = "PassengerCounting")
    private GtfsPassengerCounting passengerCounting;

    @Column(name = "VideoSurveillance")
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
