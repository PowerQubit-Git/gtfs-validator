package tml.centralapi.validatormain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class SpGetTripsByLine {

    private Long total;

    public SpGetTripsByLine(Long total) {
        this.total = total;
    }

    public SpGetTripsByLine() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
