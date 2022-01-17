package tml.centralapi.validatormain.model;

public class NoticeType {
    private String filename;
    private String fieldName;
    private String csvRowNumber;
    private String fieldValue;

    public NoticeType() {
    }

    public NoticeType(String filename, String fieldName, String csvRowNumber, String fieldValue) {
        this.filename = filename;
        this.fieldName = fieldName;
        this.csvRowNumber = csvRowNumber;
        this.fieldValue = fieldValue;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getCsvRowNumber() {
        return csvRowNumber;
    }

    public void setCsvRowNumber(String csvRowNumber) {
        this.csvRowNumber = csvRowNumber;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
