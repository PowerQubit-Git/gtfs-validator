package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.annotation.*;
import org.mobilitydata.gtfsvalidator.table.*;

public class GtfsRouteIntendedOffer {

    private String lineId;
    private String LineShortName;
    private String lineLongName;
    private String routeId;
    private String agencyId;
    private String routeOrigin;
    private String routeDestination;
    private String routeShortName;
    private String routeLongName;
    private String routeDesc;
    private String routeRemarks;
    private GtfsRouteType routeType;
    private String contract;
    private GtfsPathType pathType;
    private GtfsCircular circular;
    private GtfsSchool school;
    private GtfsContinuousPickupDropOff continuousPickup;
    private GtfsContinuousPickupDropOff continuousDropOff;

    public String getLineId() {
        return lineId;
    }
    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getLineShortName() {
        return LineShortName;
    }
    public void setLineShortName(String lineShortName) {
        LineShortName = lineShortName;
    }

    public String getLineLongName() {
        return lineLongName;
    }
    public void setLineLongName(String lineLongName) {
        this.lineLongName = lineLongName;
    }

    public String getRouteId() {
        return routeId;
    }
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getAgencyId() {
        return agencyId;
    }
    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getRouteOrigin() {
        return routeOrigin;
    }
    public void setRouteOrigin(String routeOrigin) {
        this.routeOrigin = routeOrigin;
    }

    public String getRouteDestination() {
        return routeDestination;
    }
    public void setRouteDestination(String routeDestination) {
        this.routeDestination = routeDestination;
    }

    public String getRouteShortName() {
        return routeShortName;
    }
    public void setRouteShortName(String routeShortName) {
        this.routeShortName = routeShortName;
    }

    public String getRouteLongName() {
        return routeLongName;
    }
    public void setRouteLongName(String routeLongName) {
        this.routeLongName = routeLongName;
    }

    public String getRouteDesc() {
        return routeDesc;
    }
    public void setRouteDesc(String routeDesc) {
        this.routeDesc = routeDesc;
    }

    public String getRouteRemarks() {
        return routeRemarks;
    }
    public void setRouteRemarks(String routeRemarks) {
        this.routeRemarks = routeRemarks;
    }

    public GtfsRouteType getRouteType() {
        return routeType;
    }
    public void setRouteType(GtfsRouteType routeType) {
        this.routeType = routeType;
    }

    public String getContract() {
        return contract;
    }
    public void setContract(String contract) {
        this.contract = contract;
    }

    public GtfsPathType getPathType() {
        return pathType;
    }
    public void setPathType(GtfsPathType pathType) {
        this.pathType = pathType;
    }

    public GtfsCircular getCircular() {
        return circular;
    }
    public void setCircular(GtfsCircular circular) {
        this.circular = circular;
    }

    public GtfsSchool getSchool() {
        return school;
    }
    public void setSchool(GtfsSchool school) {
        this.school = school;
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

}
