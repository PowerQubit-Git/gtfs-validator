package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.annotation.*;
import org.mobilitydata.gtfsvalidator.table.*;

import java.time.ZoneId;

public class GtfsStopIntendedOffer {

    private String stopId;
    private String stopIdSteep;
    private String stopCode;
    private String stopName;
    private String stopDesc;
    private String stopRemarks;
    private double stopLat;
    private double stopLon;
    private GtfsZoneShift zoneShift;
    private GtfsLocationType locationType;
    private String parentStation;
    private GtfsWheelchairBoarding wheelchairBoarding;
    private String platformCode;
    private GtfsEntranceRestriction entranceRestriction;
    private GtfsExitRestriction exitRestriction;
    private GtfsSlot slot;
    private GtfsSignalling signalling;
    private GtfsShelter shelter;
    private GtfsBench bench;
    private GtfsNetworkMap networkMap;
    private GtfsSchedule schedule;
    private GtfsRealTimeInformation realTimeInformation;
    private GtfsTariff tariff;
    private GtfsPreservationState preservationState;
    private String equipment;
    private String observations;
    private GtfsRegion region;
    private GtfsMunicipality municipality;
    private GtfsMunicipalityFare1 municipalityFare1;
    private GtfsMunicipalityFare2 municipalityFare2;

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

    public GtfsRegion getRegion() {
        return region;
    }
    public void setRegion(GtfsRegion region) {
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


}
