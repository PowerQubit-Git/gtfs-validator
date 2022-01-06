package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsFeedInfoIntendedOffer;

public interface FeedInfoRepository extends JpaRepository<GtfsFeedInfoIntendedOffer, Long> {
}
