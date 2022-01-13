package tml.centralapi.validatormain.model;

public class NoticeTypeSample {
    String filename;
    String fieldName;

    public NoticeTypeSample(String filename, String fieldName) {
        this.filename = filename;
        this.fieldName = fieldName;
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
}
