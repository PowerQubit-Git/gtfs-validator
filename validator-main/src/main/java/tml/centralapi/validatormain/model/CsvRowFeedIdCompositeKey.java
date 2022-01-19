package tml.centralapi.validatormain.model;

import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

public class CsvRowFeedIdCompositeKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String feedId;

    private long csvRowNumber;

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    public long getCsvRowNumber() {
        return csvRowNumber;
    }

    public void setCsvRowNumber(long csvRowNumber) {
        this.csvRowNumber = csvRowNumber;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(feedId, csvRowNumber);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CsvRowFeedIdCompositeKey entity = (CsvRowFeedIdCompositeKey) o;
        return Objects.equals(this.csvRowNumber, entity.csvRowNumber) && Objects.equals(this.feedId, entity.feedId);
    }
}