package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.annotation.*;
import org.mobilitydata.gtfsvalidator.type.GtfsDate;

import java.util.Locale;

public class GtfsFeedInfoIntendedOffer {

    private String feedPublisherName;
    private String feedPublisherUrl;
    private Locale feedLang;
    private GtfsDate feedStartDate;
    private GtfsDate feedEndDate;
    private String feedVersion;
    private String feedDesc;
    private String feedRemarks;

    public String getFeedPublisherName() {
        return feedPublisherName;
    }

    public void setFeedPublisherName(String feedPublisherName) {
        this.feedPublisherName = feedPublisherName;
    }

    public String getFeedPublisherUrl() {
        return feedPublisherUrl;
    }

    public void setFeedPublisherUrl(String feedPublisherUrl) {
        this.feedPublisherUrl = feedPublisherUrl;
    }

    public Locale getFeedLang() {
        return feedLang;
    }

    public void setFeedLang(Locale feedLang) {
        this.feedLang = feedLang;
    }

    public GtfsDate getFeedStartDate() {
        return feedStartDate;
    }

    public void setFeedStartDate(GtfsDate feedStartDate) {
        this.feedStartDate = feedStartDate;
    }

    public GtfsDate getFeedEndDate() {
        return feedEndDate;
    }

    public void setFeedEndDate(GtfsDate feedEndDate) {
        this.feedEndDate = feedEndDate;
    }

    public String getFeedVersion() {
        return feedVersion;
    }

    public void setFeedVersion(String feedVersion) {
        this.feedVersion = feedVersion;
    }

    public String getFeedDesc() {
        return feedDesc;
    }

    public void setFeedDesc(String feedDesc) {
        this.feedDesc = feedDesc;
    }

    public String getFeedRemarks() {
        return feedRemarks;
    }

    public void setFeedRemarks(String feedRemarks) {
        this.feedRemarks = feedRemarks;
    }

}
