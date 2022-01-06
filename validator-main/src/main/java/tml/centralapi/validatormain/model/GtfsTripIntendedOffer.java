package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.annotation.*;
import org.mobilitydata.gtfsvalidator.table.GtfsBikesAllowed;
import org.mobilitydata.gtfsvalidator.table.GtfsTripDirectionId;
import org.mobilitydata.gtfsvalidator.table.GtfsWheelchairBoarding;
import org.mobilitydata.gtfsvalidator.type.GtfsTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TripIntendedOffer")
public class GtfsTripIntendedOffer {

    @Id
    @Column(name = "RouteId")
    private String routeId;

    @Id
    @Column(name = "ServiceId")
    private String serviceId;

    @Id
    @Column(name = "TripId")
    private String tripId;

    @Column(name = "TripFirt")
    private GtfsTime tripFirt;

    @Column(name = "TripLast")
    private GtfsTime tripLast;

    @Column(name = "TripHeadsign")
    private String tripHeadsign;

    @Column(name = "DirectionId")
    private GtfsTripDirectionId directionId;

    @Id
    @Column(name = "ShapeId")
    private String shapeId;

    @Column(name = "WheelchairAccessible")
    private GtfsWheelchairBoarding wheelchairAccessible;

    @Column(name = "BikesAllowed")
    private GtfsBikesAllowed bikesAllowed;

    public String getRouteId() {
        return routeId;
    }
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getServiceId() {
        return serviceId;
    }
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getTripId() {
        return tripId;
    }
    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public GtfsTime getTripFirt() {
        return tripFirt;
    }
    public void setTripFirt(GtfsTime tripFirt) {
        this.tripFirt = tripFirt;
    }

    public GtfsTime getTripLast() {
        return tripLast;
    }
    public void setTripLast(GtfsTime tripLast) {
        this.tripLast = tripLast;
    }

    public String getTripHeadsign() {
        return tripHeadsign;
    }
    public void setTripHeadsign(String tripHeadsign) {
        this.tripHeadsign = tripHeadsign;
    }

    public GtfsTripDirectionId getDirectionId() {
        return directionId;
    }
    public void setDirectionId(GtfsTripDirectionId directionId) {
        this.directionId = directionId;
    }

    public String getShapeId() {
        return shapeId;
    }
    public void setShapeId(String shapeId) {
        this.shapeId = shapeId;
    }

    public GtfsWheelchairBoarding getWheelchairAccessible() {
        return wheelchairAccessible;
    }
    public void setWheelchairAccessible(GtfsWheelchairBoarding wheelchairAccessible) {
        this.wheelchairAccessible = wheelchairAccessible;
    }

    public GtfsBikesAllowed getBikesAllowed() {
        return bikesAllowed;
    }
    public void setBikesAllowed(GtfsBikesAllowed bikesAllowed) {
        this.bikesAllowed = bikesAllowed;
    }

}
