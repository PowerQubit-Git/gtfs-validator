package tml.centralapi.validatormain.model;
import java.time.ZoneId;
import java.util.Locale;

public class GtfsAgencyIntendedOffer {

    private String agencyId;
    private String agencyName;
    private String agencyUrl;
    private ZoneId agencyTimezone;
    private Locale agencyLang;

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

}
