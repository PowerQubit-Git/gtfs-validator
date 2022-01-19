package tml.centralapi.validatormain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Locale;

@Entity
@Table(name = "feed_info")
public class FeedInfo {

    @Column(name = "FeedId")
    private String feedId;

    @Id
    @Column(name = "FeedInfoId")
    private Long feedInfoId;

    @Column(name = "FeedPublisherName")
    private String feedPublisherName;

    @Column(name = "FeedPublisherUrl")
    private String feedPublisherUrl;

    @Column(name = "FeedLang")
    private Locale feedLang;

    @Column(name = "FeedStartDate")
    private LocalDate feedStartDate;

    @Column(name = "FeedEndDate")
    private LocalDate feedEndDate;

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

    public LocalDate getFeedStartDate() {
        return feedStartDate;
    }

    public void setFeedStartDate(LocalDate feedStartDate) {
        this.feedStartDate = feedStartDate;
    }

    public LocalDate getFeedEndDate() {
        return feedEndDate;
    }

    public void setFeedEndDate(LocalDate feedEndDate) {
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

    public Long getFeedInfoId() {
        return feedInfoId;
    }

    public void setFeedInfoId(Long feedInfoId) {
        this.feedInfoId = feedInfoId;
    }

    public String getFeedId() { return feedId; }
    public void setFeedId(String feedId) { this.feedId = feedId; }
}
