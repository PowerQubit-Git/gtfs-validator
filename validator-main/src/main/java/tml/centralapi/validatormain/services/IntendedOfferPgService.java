package tml.centralapi.validatormain.services;

import org.mobilitydata.gtfsvalidator.table.GtfsFeedContainer;
import org.mobilitydata.gtfsvalidator.table.GtfsStop;
import org.mobilitydata.gtfsvalidator.table.GtfsTableContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tml.centralapi.validatormain.model.GtfsAgencyIntendedOffer;
import tml.centralapi.validatormain.model.GtfsStopIntendedOffer;
import tml.centralapi.validatormain.repository.AgencyRepository;
import tml.centralapi.validatormain.repository.StopRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class IntendedOfferPgService {

    @Autowired
    StopRepository stopRepository;

    private String feedId;

    public String getFeedId() { return feedId; }

    public void setFeedId(String feedId) { this.feedId = feedId; }

    public IntendedOfferPgService() {
    }

    @Async()
    public void addToDatabase(GtfsFeedContainer feedContainer) throws Exception {
        GtfsTableContainer stopsContainer = feedContainer.getTableForFilename("stops.txt").orElseThrow(() -> new Exception("stops.txt not found"));
        List<GtfsStop> list = stopsContainer.getEntities();
        List<GtfsStopIntendedOffer> ioStops = new ArrayList<>();
        list.forEach(stop -> {
            GtfsStopIntendedOffer newStop = new GtfsStopIntendedOffer();
            newStop.setFeedId(feedId);
            newStop.setStopId(stop.stopId());
            newStop.setStopCode(stop.stopCode());
            newStop.setStopName(stop.stopName());
            newStop.setStopDesc(stop.stopDesc());
            newStop.setStopLat(stop.stopLat());
            newStop.setStopLon(stop.stopLon());
            newStop.setLocationType(stop.locationType());
            newStop.setParentStation(stop.parentStation());
            newStop.setWheelchairBoarding(stop.wheelchairBoarding());
            newStop.setPlatformCode(stop.platformCode());
            ioStops.add(newStop);
        });

        try {
            ioStops.forEach(s -> { stopRepository.save(s); });
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
