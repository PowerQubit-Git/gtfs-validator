package tml.centralapi.validatormain.model;
import javax.persistence.*;
import java.time.ZoneId;
import java.util.Locale;

@Entity
@Table(name = "agency")
@IdClass(CsvRowFeedIdCompositeKey.class)
public class Agency {

    @Column(name = "AgencyId")
    private String agencyId;

    @Column(name = "AgencyName")
    private String agencyName;

    @Column(name = "AgencyUrl")
    private String agencyUrl;

    @Column(name = "AgencyTimezone")
    private ZoneId agencyTimezone;

    @Column(name = "AgencyLang")
    private Locale agencyLang;

    @Id
    @Column(name = "FeedId")
    private String feedId;

    @Id
    @Column(name = "CsvRowNumber")
    private long csvRowNumber;

    public String getAgencyName() {
        return agencyName;
    }
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyUrl() {
        return agencyUrl;
    }
    public void setAgencyUrl(String agencyUrl) {
        this.agencyUrl = agencyUrl;
    }

    public ZoneId getAgencyTimezone() {
        return agencyTimezone;
    }
    public void setAgencyTimezone(ZoneId agencyTimezone) {
        this.agencyTimezone = agencyTimezone;
    }

    public Locale getAgencyLang() {
        return agencyLang;
    }
    public void setAgencyLang(Locale agencyLang) {
        this.agencyLang = agencyLang;
    }

    public String getAgencyId() {
        return agencyId;
    }
    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getFeedId() { return feedId; }
    public void setFeedId(String feedId) { this.feedId = feedId; }

    public long getCsvRowNumber() { return csvRowNumber; }
    public void setCsvRowNumber(long csvRowNumber) { this.csvRowNumber = csvRowNumber; }
}
