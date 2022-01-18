package tml.centralapi.validatormain.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZoneId;
import java.util.Locale;

@Entity
@Table(name = "agency")
public class GtfsAgencyIntendedOffer {

    @Id
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

    @Column(name = "FeedId")
    private String feedId;

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
}
