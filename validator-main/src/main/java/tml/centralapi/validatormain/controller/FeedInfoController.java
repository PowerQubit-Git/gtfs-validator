package tml.centralapi.validatormain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tml.centralapi.validatormain.model.GtfsFeedInfoIntendedOffer;
import tml.centralapi.validatormain.repository.FeedInfoRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class FeedInfoController {
    @Autowired
    FeedInfoRepository feedInfoRepository;

    @GetMapping("/feedInfo/{id}")
    HttpEntity<List<GtfsFeedInfoIntendedOffer>> get(@PathVariable String id) throws Exception {
        try {
            List<GtfsFeedInfoIntendedOffer> list = feedInfoRepository.findByFeedId(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/feedInfo")
    public GtfsFeedInfoIntendedOffer create(@Valid @RequestBody GtfsFeedInfoIntendedOffer FeedInfo) {
        return feedInfoRepository.save(FeedInfo);
    }

    @PutMapping("/feedInfo/{id}")
    public ResponseEntity<GtfsFeedInfoIntendedOffer> update(@PathVariable(value = "id") String id,
                                                   @Valid @RequestBody GtfsFeedInfoIntendedOffer details) throws Exception {
        try {
            GtfsFeedInfoIntendedOffer feedInfo = feedInfoRepository.findByFeedInfoId(id);
            feedInfo.setFeedId(details.getFeedId());
            feedInfo.setFeedDesc(details.getFeedDesc());
            feedInfo.setFeedRemarks(details.getFeedRemarks());
            feedInfo.setFeedVersion(details.getFeedVersion());
            feedInfo.setFeedEndDate(details.getFeedEndDate());
            feedInfo.setFeedStartDate(details.getFeedStartDate());
            feedInfo.setFeedPublisherUrl(details.getFeedPublisherUrl());
            feedInfo.setFeedLang(details.getFeedLang());
            feedInfo.setFeedInfoId(details.getFeedInfoId());
            final GtfsFeedInfoIntendedOffer updatedFeedInfo = feedInfoRepository.save(feedInfo);
            return ResponseEntity.ok(updatedFeedInfo);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/feedInfo/{id}")
    public Map<String, Boolean> deleteFeedInfo(@PathVariable(value = "id") Long id)
            throws Exception {
        GtfsFeedInfoIntendedOffer FeedInfo = feedInfoRepository.findById(id)
                .orElseThrow(() -> new Exception("not found"));

        feedInfoRepository.delete(FeedInfo);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
