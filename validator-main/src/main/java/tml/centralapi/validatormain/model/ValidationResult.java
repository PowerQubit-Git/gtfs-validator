package tml.centralapi.validatormain.model;

import org.mobilitydata.gtfsvalidator.table.GtfsFeedContainer;

public class ValidationResult {
    boolean success;
    String tableTotals;
    double validationTime;
    GtfsFeedContainer feedContainer;
    String err;

    public ValidationResult() {
    }

    public ValidationResult(boolean success, String tableTotals, double validationTime, GtfsFeedContainer feedContainer) {
        this.success = success;
        this.tableTotals = tableTotals;
        this.validationTime = validationTime;
        this.feedContainer = feedContainer;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTableTotals() {
        return tableTotals;
    }

    public void setTableTotals(String tableTotals) {
        this.tableTotals = tableTotals;
    }

    public double getValidationTime() {
        return validationTime;
    }

    public void setValidationTime(double validationTime) {
        this.validationTime = validationTime;
    }

    public GtfsFeedContainer getFeedContainer() {
        return feedContainer;
    }

    public void setFeedContainer(GtfsFeedContainer feedContainer) {
        this.feedContainer = feedContainer;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}
