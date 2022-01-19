package tml.centralapi.validatormain.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Locale;

@Entity
@Table(name = "feed_info")
@IdClass(CsvRowFeedIdCompositeKey.class)
public class FeedInfo {

    @Column(name = "FeedInfoId")
    private Long feedInfoId;

    @Column(name = "FeedPublisherName")
    private String feedPublisherName;

    @Column(name = "FeedPublisherUrl")
    private String feedPublisherUrl;

    @Column(name = "FeedLang")
    private Locale feedLang;

    @Column(name = "FeedStartDate")
    private String feedStartDate;

    @Column(name = "FeedEndDate")
    private String feedEndDate;

    @Column(name = "FeedVersion")
    private String feedVersion;

    @Column(name = "FeedDesc")
    private String feedDesc;

    @Column(name = "FeedRemarks")
    private String feedRemarks;

    @Id
    @Column(name = "FeedId")
    private String feedId;

    @Id
    @Column(name = "CsvRowNumber")
    private long csvRowNumber;

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

    public String getFeedStartDate() {
        return feedStartDate;
    }

    public void setFeedStartDate(String feedStartDate) {
        this.feedStartDate = feedStartDate;
    }

    public String getFeedEndDate() {
        return feedEndDate;
    }

    public void setFeedEndDate(String feedEndDate) {
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

    public long getCsvRowNumber() { return csvRowNumber; }
    public void setCsvRowNumber(long csvRowNumber) { this.csvRowNumber = csvRowNumber; }
}
