package tml.centralapi.validatormain.model;

import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

public class GtfsStopTimeCompositeKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String tripId;

    private String stopId;

    public GtfsStopTimeCompositeKey() {}


    public GtfsStopTimeCompositeKey(String tripId, String stopId)
    {
        this.tripId = tripId;
        this.stopId = stopId;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(tripId, stopId);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GtfsStopTimeCompositeKey entity = (GtfsStopTimeCompositeKey) o;
        return Objects.equals(this.stopId, entity.stopId) && Objects.equals(this.tripId, entity.tripId);
    }
}