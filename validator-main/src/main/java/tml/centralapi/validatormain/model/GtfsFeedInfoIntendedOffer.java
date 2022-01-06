package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.annotation.*;
import org.mobilitydata.gtfsvalidator.type.GtfsDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Locale;

@Entity
@Table(name = "FeedInfoIntendedOffer")
public class GtfsFeedInfoIntendedOffer {

    @Column(name = "FeedPublisherName")
    private String feedPublisherName;

    @Column(name = "FeedPublisherUrl")
    private String feedPublisherUrl;

    @Column(name = "FeedLang")
    private Locale feedLang;

    @Column(name = "FeedStartDate")
    private GtfsDate feedStartDate;

    @Column(name = "FeedEndDate")
    private GtfsDate feedEndDate;

    @Column(name = "FeedVersion")
    private String feedVersion;

    @Column(name = "FeedDesc")
    private String feedDesc;

    @Column(name = "FeedRemarks")
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
