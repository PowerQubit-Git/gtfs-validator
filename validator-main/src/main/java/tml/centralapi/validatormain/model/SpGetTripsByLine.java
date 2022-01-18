package tml.centralapi.validatormain.model;

public class SpGetTripsByLine {
    private int Number;
    private String LineId;

    public SpGetTripsByLine() {
    }

    public SpGetTripsByLine(int number, String lineId) {
        Number = number;
        LineId = lineId;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getLineId() {
        return LineId;
    }

    public void setLineId(String lineId) {
        LineId = lineId;
    }
}
