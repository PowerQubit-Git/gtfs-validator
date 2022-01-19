package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.table.*;

import javax.persistence.*;

@Entity
@Table(name = "routes")
@IdClass(CsvRowFeedIdCompositeKey.class)
public class Route {

    @Column(name = "LineId")
    private String lineId;

    @Column(name = "LineShortName")
    private String LineShortName;

    @Column(name = "LineLongName")
    private String lineLongName;

    @Column(name = "RouteId")
    private String routeId;

    @Column(name = "AgencyId")
    private String agencyId;

    @Column(name = "RouteOrigin")
    private String routeOrigin;

    @Column(name = "RouteDestination")
    private String routeDestination;

    @Column(name = "RouteShortName")
    private String routeShortName;

    @Column(name = "RouteLongName")
    private String routeLongName;

    @Column(name = "RouteDesc")
    private String routeDesc;

    @Column(name = "RouteRemarks")
    private String routeRemarks;

    @Column(name = "RouteType")
    private GtfsRouteType routeType;

    @Column(name = "Contract")
    private String contract;

    @Column(name = "PathType")
    private GtfsPathType pathType;

    @Column(name = "Circular")
    private GtfsCircular circular;

    @Column(name = "School")
    private GtfsSchool school;

    @Column(name = "ContinuousPickup")
    private GtfsContinuousPickupDropOff continuousPickup;

    @Column(name = "ContinuousDropOff")
    private GtfsContinuousPickupDropOff continuousDropOff;

    @Id
    @Column(name = "FeedId")
    private String feedId;

    @Id
    @Column(name = "CsvRowNumber")
    private long csvRowNumber;

    public Route() {
    }

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

    public String getFeedId() { return feedId; }
    public void setFeedId(String feedId) { this.feedId = feedId; }

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

    public long getCsvRowNumber() { return csvRowNumber; }
    public void setCsvRowNumber(long csvRowNumber) { this.csvRowNumber = csvRowNumber; }

}
