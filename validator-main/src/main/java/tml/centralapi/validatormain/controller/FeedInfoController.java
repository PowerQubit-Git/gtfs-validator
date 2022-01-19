package tml.centralapi.validatormain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tml.centralapi.validatormain.model.FeedInfo;
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

    @GetMapping("/feed_info/{id}")
    HttpEntity<List<FeedInfo>> get(@PathVariable String id) throws Exception {
        try {
            List<FeedInfo> list = feedInfoRepository.findByFeedId(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/feed_info")
    public FeedInfo create(@Valid @RequestBody FeedInfo FeedInfo) {
        return feedInfoRepository.save(FeedInfo);
    }

    @PutMapping("/feed_info/{id}")
    public ResponseEntity<FeedInfo> update(@PathVariable(value = "id") String id,
                                           @Valid @RequestBody FeedInfo details) throws Exception {
        try {
            FeedInfo feedInfo = feedInfoRepository.findByFeedInfoId(id);
            feedInfo.setFeedId(details.getFeedId());
            feedInfo.setFeedDesc(details.getFeedDesc());
            feedInfo.setFeedRemarks(details.getFeedRemarks());
            feedInfo.setFeedVersion(details.getFeedVersion());
            feedInfo.setFeedEndDate(details.getFeedEndDate());
            feedInfo.setFeedStartDate(details.getFeedStartDate());
            feedInfo.setFeedPublisherUrl(details.getFeedPublisherUrl());
            feedInfo.setFeedLang(details.getFeedLang());
            feedInfo.setFeedInfoId(details.getFeedInfoId());
            final FeedInfo updatedFeedInfo = feedInfoRepository.save(feedInfo);
            return ResponseEntity.ok(updatedFeedInfo);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/feed_info/{id}")
    public Map<String, Boolean> deleteFeedInfo(@PathVariable(value = "id") Long id)
            throws Exception {
        FeedInfo FeedInfo = feedInfoRepository.findById(id)
                .orElseThrow(() -> new Exception("not found"));

        feedInfoRepository.delete(FeedInfo);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
