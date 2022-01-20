package tml.centralapi.validatormain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RowsByTable {
    @Id
    @Column(name="gtfs_table")
    private String gtfsTable;
    private int counter;

    public RowsByTable(String gtfs_table, int counter) {
        this.gtfsTable = gtfs_table;
        this.counter = counter;
    }

    public RowsByTable() {
    }

    public String getGtfsTable() {
        return gtfsTable;
    }

    public void setGtfsTable(String gtfsTable) {
        this.gtfsTable = gtfsTable;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
