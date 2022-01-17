package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsFeedInfoIntendedOffer;
import tml.centralapi.validatormain.model.GtfsStopIntendedOffer;

import java.util.List;

public interface FeedInfoRepository extends JpaRepository<GtfsFeedInfoIntendedOffer, Long> {
    List<GtfsFeedInfoIntendedOffer> findByFeedId(String id);
    GtfsFeedInfoIntendedOffer findByFeedInfoId(String id);
}
