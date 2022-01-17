package tml.centralapi.validatormain.services;

import org.mobilitydata.gtfsvalidator.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tml.centralapi.validatormain.model.*;
import tml.centralapi.validatormain.repository.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class IntendedOfferPgService {

    @Autowired
    StopRepository stopRepository;

    @Autowired
    AgencyRepository agencyRepository;

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    TripRepository tripRepository;

    @Autowired
    StopTimeRepository stopTimeRepository;

    @Autowired
    CalendarRepository calendarRepository;

    @Autowired
    CalendarDateRepository calendarDateRepository;

    @Autowired
    ShapeRepository shapeRepository;

    @Autowired
    FeedInfoRepository feedInfoRepository;

    private String feedId;

    public String getFeedId() { return feedId; }

    public void setFeedId(String feedId) { this.feedId = feedId; }

    public IntendedOfferPgService() {
    }

    @Async()
    public void addToDatabase(GtfsFeedContainer feedContainer) throws Exception {
        GtfsTableContainer agencyContainer = feedContainer.getTableForFilename("agency.txt").orElseThrow(() -> new Exception("agency.txt not found"));
        List<GtfsAgency> agencyList = agencyContainer.getEntities();
        List<GtfsAgencyIntendedOffer> ioAgency = new ArrayList<>();
        agencyList.forEach(agency -> {
            GtfsAgencyIntendedOffer newAgency = new GtfsAgencyIntendedOffer();
            newAgency.setFeedId(feedId);
            newAgency.setAgencyId(agency.agencyId());
            newAgency.setAgencyName(agency.agencyName());
            newAgency.setAgencyUrl(agency.agencyUrl());
            newAgency.setAgencyTimezone(agency.agencyTimezone());
            newAgency.setAgencyLang(agency.agencyLang());
            ioAgency.add(newAgency);
        });

        try {
            ioAgency.forEach(s -> { agencyRepository.save(s); });
        } catch (Exception e) {
            System.out.println(e);
        }


        GtfsTableContainer stopsContainer = feedContainer.getTableForFilename("stops.txt").orElseThrow(() -> new Exception("stops.txt not found"));
        List<GtfsStop> list = stopsContainer.getEntities();
        List<GtfsStopIntendedOffer> ioStops = new ArrayList<>();
        list.forEach(stop -> {
            GtfsStopIntendedOffer newStop = new GtfsStopIntendedOffer();
            newStop.setFeedId(feedId);
            newStop.setStopId(stop.stopId());
            newStop.setStopIdSteep(stop.stopIdStepp());
            newStop.setStopCode(stop.stopCode());
            newStop.setStopName(stop.stopName());
            newStop.setStopDesc(stop.stopDesc());
            newStop.setStopRemarks(stop.stopRemarks());
            newStop.setStopLat(stop.stopLat());
            newStop.setStopLon(stop.stopLon());
            newStop.setZoneShift(stop.zone_shift());
            newStop.setLocationType(stop.locationType());
            newStop.setParentStation(stop.parentStation());
            newStop.setWheelchairBoarding(stop.wheelchairBoarding());
            newStop.setPlatformCode(stop.platformCode());
            newStop.setEntranceRestriction(stop.entranceRestriction());
            newStop.setExitRestriction(stop.exitRestriction());
            newStop.setSlot(stop.slot());
            newStop.setSignalling(stop.signalling());
            newStop.setShelter(stop.shelter());
            newStop.setBench(stop.bench());
            newStop.setNetworkMap(stop.networkMap());
            newStop.setSchedule(stop.schedule());
            newStop.setRealTimeInformation(stop.realTimeInformation());
            newStop.setTariff(stop.tariff());
            newStop.setPreservationState(stop.preservationState());
            newStop.setEquipment(stop.equipment());
            newStop.setObservations(stop.observations());
            //newStop.setRegion(stop.region());
            newStop.setMunicipality(stop.municipality());
            newStop.setMunicipalityFare1(stop.municipalityFare1());
            newStop.setMunicipalityFare2(stop.municipalityFare2());
            ioStops.add(newStop);
        });

        try {
            ioStops.forEach(s -> { stopRepository.save(s); });
        } catch (Exception e) {
            System.out.println(e);
        }

        GtfsTableContainer routesContainer = feedContainer.getTableForFilename("routes.txt").orElseThrow(() -> new Exception("routes.txt not found"));
        List<GtfsRoute> routeslist = routesContainer.getEntities();
        List<GtfsRouteIntendedOffer> ioRoutes = new ArrayList<>();
        routeslist.forEach(route -> {
            GtfsRouteIntendedOffer newRoute = new GtfsRouteIntendedOffer();
            newRoute.setFeedId(feedId);
            newRoute.setLineId(route.lineId());
            newRoute.setLineShortName(route.LineShortName());
            newRoute.setRouteLongName(route.routeLongName());
            newRoute.setRouteId(route.routeId());
            newRoute.setAgencyId(route.agencyId());
            newRoute.setRouteOrigin(route.routeOrigin());
            newRoute.setRouteDestination(route.routeDestination());
            newRoute.setRouteShortName(route.routeShortName());
            newRoute.setRouteLongName(route.routeLongName());
            newRoute.setRouteDesc(route.routeDesc());
            newRoute.setRouteRemarks(route.routeRemarks());
            newRoute.setRouteType(route.routeType());
            newRoute.setContract(route.contract());
            newRoute.setPathType(route.pathType());
            newRoute.setCircular(route.circular());
            newRoute.setSchool(route.school());
            newRoute.setContinuousPickup(route.continuousPickup());
            newRoute.setContinuousDropOff(route.continuousDropOff());
            ioRoutes.add(newRoute);
        });

        try {
            ioRoutes.forEach(s -> { routeRepository.save(s); });
        } catch (Exception e) {
            System.out.println(e);
        }

        GtfsTableContainer tripsContainer = feedContainer.getTableForFilename("trips.txt").orElseThrow(() -> new Exception("trips.txt not found"));
        List<GtfsTrip> tripslist = tripsContainer.getEntities();
        List<GtfsTripIntendedOffer> ioTrips = new ArrayList<>();
        tripslist.forEach(trips -> {
            GtfsTripIntendedOffer newTrips = new GtfsTripIntendedOffer();
            newTrips.setFeedId(feedId);
            newTrips.setRouteId(trips.routeId());
            newTrips.setServiceId(trips.serviceId());
            newTrips.setTripId(trips.tripId());
            //newTrips.setTripFirt(trips.tripFirst());
            //newTrips.setTripLast(trips.tripLast());
            newTrips.setTripHeadsign(trips.tripHeadsign());
            newTrips.setDirectionId(trips.directionId());
            newTrips.setShapeId(trips.shapeId());
            newTrips.setWheelchairAccessible(trips.wheelchairAccessible());
            newTrips.setBikesAllowed(trips.bikesAllowed());

            ioTrips.add(newTrips);
        });

        try {
            ioTrips.forEach(s -> { tripRepository.save(s); });
        } catch (Exception e) {
            System.out.println(e);
        }

        GtfsTableContainer stopTimeContainer = feedContainer.getTableForFilename("stop_times.txt").orElseThrow(() -> new Exception("stop_times.txt not found"));
        List<GtfsStopTime> stopTimelist = stopTimeContainer.getEntities();
        List<GtfsStopTimeIntendedOffer> ioStopTime = new ArrayList<>();
        stopTimelist.forEach(stopTime -> {
            GtfsStopTimeIntendedOffer newStopTime = new GtfsStopTimeIntendedOffer();
            newStopTime.setFeedId(feedId);
            newStopTime.setTripId(stopTime.tripId());
            //newStopTime.setArrivalTime(stopTime.arrivalTime());
            //newStopTime.setDepartureTime(stopTime.departureTime());
            newStopTime.setStopId(stopTime.stopId());
            newStopTime.setStopSequence(stopTime.stopSequence());
            newStopTime.setStopHeadsign(stopTime.stopHeadsign());
            newStopTime.setContinuousPickup(stopTime.continuousPickup());
            newStopTime.setContinuousDropOff(stopTime.continuousDropOff());
            newStopTime.setShapeDistTraveled(stopTime.shapeDistTraveled());
            newStopTime.setTimepoint(stopTime.timepoint());
            ioStopTime.add(newStopTime);
        });

        try {
            ioStopTime.forEach(s -> { stopTimeRepository.save(s); });
        } catch (Exception e) {
            System.out.println(e);
        }


        GtfsTableContainer calendarContainer = feedContainer.getTableForFilename("calendar.txt").orElseThrow(() -> new Exception("calendar.txt not found"));
        List<GtfsCalendar> calendarlist = calendarContainer.getEntities();
        List<GtfsCalendarIntendedOffer> ioCalendar = new ArrayList<>();
        calendarlist.forEach(calendar -> {
            GtfsCalendarIntendedOffer newCalendar = new GtfsCalendarIntendedOffer();
            newCalendar.setFeedId(feedId);
            newCalendar.setServiceId(calendar.serviceId());
            newCalendar.setCalendarName(calendar.calendarName());
            newCalendar.setPeriod(calendar.period());
            newCalendar.setMonday(calendar.monday());
            newCalendar.setTuesday(calendar.tuesday());
            newCalendar.setWednesday(calendar.wednesday());
            newCalendar.setThursday(calendar.thursday());
            newCalendar.setFriday(calendar.friday());
            newCalendar.setSaturday(calendar.saturday());
            newCalendar.setSunday(calendar.sunday());
            //newCalendar.setStartDate(calendar.startDate());
            //newCalendar.setEndDate(calendar.endDate());
            ioCalendar.add(newCalendar);
        });

        try {
            ioCalendar.forEach(s -> { calendarRepository.save(s); });
        } catch (Exception e) {
            System.out.println(e);
        }

        GtfsTableContainer calendarDateContainer = feedContainer.getTableForFilename("calendar_date.txt").orElseThrow(() -> new Exception("calendar_date.txt not found"));
        List<GtfsCalendarDate> calendarDatelist = calendarDateContainer.getEntities();
        List<GtfsCalendarDateIntendedOffer> ioCalendarDate = new ArrayList<>();
        calendarDatelist.forEach(calendarDate -> {
            GtfsCalendarDateIntendedOffer newCalendarDate = new GtfsCalendarDateIntendedOffer();
            newCalendarDate.setFeedId(feedId);
            newCalendarDate.setServiceId(calendarDate.serviceId());
            newCalendarDate.setCalendarName(calendarDate.calendarName());
            newCalendarDate.setHoliday(calendarDate.holiday());
            newCalendarDate.setPeriod(calendarDate.period());
            //newCalendarDate.setDate(calendarDate.date());
            newCalendarDate.setExceptionType(calendarDate.exceptionType());
            ioCalendarDate.add(newCalendarDate);
        });

        try {
            ioCalendarDate.forEach(s -> { calendarDateRepository.save(s); });
        } catch (Exception e) {
            System.out.println(e);
        }

        GtfsTableContainer shapeContainer = feedContainer.getTableForFilename("shape.txt").orElseThrow(() -> new Exception("shape.txt not found"));
        List<GtfsShape> shapelist = shapeContainer.getEntities();
        List<GtfsShapeIntendedOffer> ioShape = new ArrayList<>();
        shapelist.forEach(shape -> {
            GtfsShapeIntendedOffer newShape = new GtfsShapeIntendedOffer();
            newShape.setFeedId(feedId);
            newShape.setShapeId(shape.shapeId());
            newShape.setShapePtLat(shape.shapePtLat());
            newShape.setShapePtLon(shape.shapePtLon());
            newShape.setShapePtSequence(shape.shapePtSequence());
            newShape.setShapeDistTraveled(shape.shapeDistTraveled());
            ioShape.add(newShape);
        });

        try {
            ioShape.forEach(s -> { shapeRepository.save(s); });
        } catch (Exception e) {
            System.out.println(e);
        }

        GtfsTableContainer feedInfoContainer = feedContainer.getTableForFilename("feed_info.txt").orElseThrow(() -> new Exception("feed_info.txt not found"));
        List<GtfsFeedInfo> feedInfolist = feedInfoContainer.getEntities();
        List<GtfsFeedInfoIntendedOffer> ioFeedInfo = new ArrayList<>();
        feedInfolist.forEach(feedInfo -> {
            GtfsFeedInfoIntendedOffer newFeedInfo = new GtfsFeedInfoIntendedOffer();
            newFeedInfo.setFeedId(feedId);
            newFeedInfo.setFeedPublisherName(feedInfo.feedPublisherName());
            newFeedInfo.setFeedPublisherUrl(feedInfo.feedPublisherUrl());
            newFeedInfo.setFeedLang(feedInfo.feedLang());
            //newFeedInfo.setFeedStartDate(feedInfo.feedStartDate());
            //newFeedInfo.setFeedEndDate(feedInfo.feedEndDate());
            newFeedInfo.setFeedVersion(feedInfo.feedVersion());
            newFeedInfo.setFeedDesc(feedInfo.feedDesc());
            newFeedInfo.setFeedRemarks(feedInfo.feedRemarks());
            ioFeedInfo.add(newFeedInfo);
        });

        try {
            ioFeedInfo.forEach(s -> { feedInfoRepository.save(s); });
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
