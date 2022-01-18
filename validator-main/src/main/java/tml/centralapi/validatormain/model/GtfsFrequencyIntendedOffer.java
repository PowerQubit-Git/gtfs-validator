package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.table.GtfsPassengerCounting;
import org.mobilitydata.gtfsvalidator.table.GtfsPropulsion;
import org.mobilitydata.gtfsvalidator.table.GtfsTypology;
import org.mobilitydata.gtfsvalidator.table.GtfsVideoSurveillance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;

@Entity
@Table(name = "frequencies")
public class GtfsFrequencyIntendedOffer {

    @Id
    @Column(name = "TripId")
    private String tripId;

    @Column(name = "StartTime")
    private LocalTime startTime;

    @Column(name = "EndTime")
    private LocalTime endTime;

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

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
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
