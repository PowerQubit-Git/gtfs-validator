package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.table.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stops")
public class Stop {

    @Id
    @Column(name = "StopId")
    private String stopId;

    @Column(name = "StopIdSteep")
    private String stopIdSteep;

    @Column(name = "StopCode")
    private String stopCode;

    @Column(name = "StopName")
    private String stopName;

    @Column(name = "StopDesc")
    private String stopDesc;

    @Column(name = "StopRemarks")
    private String stopRemarks;

    @Column(name = "StopLat")
    private double stopLat;

    @Column(name = "StopLon")
    private double stopLon;

    @Column(name = "ZoneShift")
    private GtfsZoneShift zoneShift;

    @Column(name = "LocationType")
    private GtfsLocationType locationType;

    @Column(name = "ParentStation")
    private String parentStation;

    @Column(name = "WheelchairBoarding")
    private GtfsWheelchairBoarding wheelchairBoarding;

    @Column(name = "PlatformCode")
    private String platformCode;

    @Column(name = "EntranceRestriction")
    private GtfsEntranceRestriction entranceRestriction;

    @Column(name = "ExitRestriction")
    private GtfsExitRestriction exitRestriction;

    @Column(name = "Slot")
    private GtfsSlot slot;

    @Column(name = "Signalling")
    private GtfsSignalling signalling;

    @Column(name = "Shelter")
    private GtfsShelter shelter;

    @Column(name = "Bench")
    private GtfsBench bench;

    @Column(name = "NetworkMap")
    private GtfsNetworkMap networkMap;

    @Column(name = "Schedule")
    private GtfsSchedule schedule;

    @Column(name = "RealTimeInformation")
    private GtfsRealTimeInformation realTimeInformation;

    @Column(name = "Tariff")
    private GtfsTariff tariff;

    @Column(name = "PreservationState")
    private GtfsPreservationState preservationState;

    @Column(name = "Equipment")
    private String equipment;

    @Column(name = "Observations")
    private String observations;

    @Column(name = "Region")
    private String region;

    @Column(name = "Municipality")
    private GtfsMunicipality municipality;

    @Column(name = "MunicipalityFare1")
    private GtfsMunicipalityFare1 municipalityFare1;

    @Column(name = "MunicipalityFare2")
    private GtfsMunicipalityFare2 municipalityFare2;

    @Column(name = "FeedId")
    private String feedId;

    public String getStopId() {
        return stopId;
    }
    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getStopIdSteep() {
        return stopIdSteep;
    }
    public void setStopIdSteep(String stopIdSteep) {
        this.stopIdSteep = stopIdSteep;
    }

    public String getStopCode() {
        return stopCode;
    }
    public void setStopCode(String stopCode) {
        this.stopCode = stopCode;
    }

    public String getStopName() {
        return stopName;
    }
    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public String getStopDesc() {
        return stopDesc;
    }
    public void setStopDesc(String stopDesc) {
        this.stopDesc = stopDesc;
    }

    public String getStopRemarks() {
        return stopRemarks;
    }
    public void setStopRemarks(String stopRemarks) {
        this.stopRemarks = stopRemarks;
    }

    public double getStopLat() {
        return stopLat;
    }
    public void setStopLat(double stopLat) {
        this.stopLat = stopLat;
    }

    public double getStopLon() {
        return stopLon;
    }
    public void setStopLon(double stopLon) {
        this.stopLon = stopLon;
    }

    public GtfsZoneShift getZoneShift() {
        return zoneShift;
    }
    public void setZoneShift(GtfsZoneShift zoneShift) {
        this.zoneShift = zoneShift;
    }

    public GtfsLocationType getLocationType() {
        return locationType;
    }
    public void setLocationType(GtfsLocationType locationType) {
        this.locationType = locationType;
    }

    public String getParentStation() {
        return parentStation;
    }
    public void setParentStation(String parentStation) {
        this.parentStation = parentStation;
    }

    public GtfsWheelchairBoarding getWheelchairBoarding() {
        return wheelchairBoarding;
    }
    public void setWheelchairBoarding(GtfsWheelchairBoarding wheelchairBoarding) {
        this.wheelchairBoarding = wheelchairBoarding;
    }

    public String getPlatformCode() {
        return platformCode;
    }
    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    public GtfsEntranceRestriction getEntranceRestriction() {
        return entranceRestriction;
    }
    public void setEntranceRestriction(GtfsEntranceRestriction entranceRestriction) {
        this.entranceRestriction = entranceRestriction;
    }

    public GtfsExitRestriction getExitRestriction() {
        return exitRestriction;
    }
    public void setExitRestriction(GtfsExitRestriction exitRestriction) {
        this.exitRestriction = exitRestriction;
    }

    public GtfsSlot getSlot() {
        return slot;
    }
    public void setSlot(GtfsSlot slot) {
        this.slot = slot;
    }

    public GtfsSignalling getSignalling() {
        return signalling;
    }
    public void setSignalling(GtfsSignalling signalling) {
        this.signalling = signalling;
    }

    public GtfsShelter getShelter() {
        return shelter;
    }
    public void setShelter(GtfsShelter shelter) {
        this.shelter = shelter;
    }

    public GtfsBench getBench() {
        return bench;
    }
    public void setBench(GtfsBench bench) {
        this.bench = bench;
    }

    public GtfsNetworkMap getNetworkMap() {
        return networkMap;
    }
    public void setNetworkMap(GtfsNetworkMap networkMap) {
        this.networkMap = networkMap;
    }

    public GtfsSchedule getSchedule() {
        return schedule;
    }
    public void setSchedule(GtfsSchedule schedule) {
        this.schedule = schedule;
    }

    public GtfsRealTimeInformation getRealTimeInformation() {
        return realTimeInformation;
    }
    public void setRealTimeInformation(GtfsRealTimeInformation realTimeInformation) {
        this.realTimeInformation = realTimeInformation;
    }

    public GtfsTariff getTariff() {
        return tariff;
    }
    public void setTariff(GtfsTariff tariff) {
        this.tariff = tariff;
    }

    public GtfsPreservationState getPreservationState() {
        return preservationState;
    }
    public void setPreservationState(GtfsPreservationState preservationState) {
        this.preservationState = preservationState;
    }

    public String getEquipment() {
        return equipment;
    }
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getObservations() {
        return observations;
    }
    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }

    public GtfsMunicipality getMunicipality() {
        return municipality;
    }
    public void setMunicipality(GtfsMunicipality municipality) {
        this.municipality = municipality;
    }

    public GtfsMunicipalityFare1 getMunicipalityFare1() {
        return municipalityFare1;
    }
    public void setMunicipalityFare1(GtfsMunicipalityFare1 municipalityFare1) {
        this.municipalityFare1 = municipalityFare1;
    }

    public GtfsMunicipalityFare2 getMunicipalityFare2() {
        return municipalityFare2;
    }
    public void setMunicipalityFare2(GtfsMunicipalityFare2 municipalityFare2) {
        this.municipalityFare2 = municipalityFare2;
    }

    public String getFeedId() { return feedId; }
    public void setFeedId(String feedId) { this.feedId = feedId; }
}
