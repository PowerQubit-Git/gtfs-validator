package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.FeedInfo;

import java.util.List;

public interface FeedInfoRepository extends JpaRepository<FeedInfo, Long> {
    List<FeedInfo> findByFeedId(String id);
    FeedInfo findByFeedInfoId(String id);
}
