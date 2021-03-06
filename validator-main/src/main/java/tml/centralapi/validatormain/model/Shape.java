package tml.centralapi.validatormain.model;

import javax.persistence.*;

@Entity
@Table(name = "shapes")
@IdClass(CsvRowFeedIdCompositeKey.class)
public class Shape {

    @Column(name = "LineId")
    private String shapeId;

    @Column(name = "ShapePtLat")
    private double shapePtLat;

    @Column(name = "ShapePtLon")
    private double shapePtLon;

    @Column(name = "ShapePtSequence")
    private int shapePtSequence;

    @Column(name = "ShapeDistTraveled")
    private double shapeDistTraveled;

    @Id
    @Column(name = "FeedId")
    private String feedId;

    @Id
    @Column(name = "CsvRowNumber")
    private long csvRowNumber;

    public String getShapeId() {
        return shapeId;
    }

    public void setShapeId(String shapeId) {
        this.shapeId = shapeId;
    }

    public double getShapePtLat() {
        return shapePtLat;
    }

    public void setShapePtLat(double shapePtLat) {
        this.shapePtLat = shapePtLat;
    }

    public double getShapePtLon() {
        return shapePtLon;
    }

    public void setShapePtLon(double shapePtLon) {
        this.shapePtLon = shapePtLon;
    }

    public int getShapePtSequence() {
        return shapePtSequence;
    }

    public void setShapePtSequence(int shapePtSequence) {
        this.shapePtSequence = shapePtSequence;
    }

    public double getShapeDistTraveled() {
        return shapeDistTraveled;
    }

    public void setShapeDistTraveled(double shapeDistTraveled) {
        this.shapeDistTraveled = shapeDistTraveled;
    }

    public String getFeedId() { return feedId; }
    public void setFeedId(String feedId) { this.feedId = feedId; }

    public long getCsvRowNumber() { return csvRowNumber; }
    public void setCsvRowNumber(long csvRowNumber) { this.csvRowNumber = csvRowNumber; }
}
