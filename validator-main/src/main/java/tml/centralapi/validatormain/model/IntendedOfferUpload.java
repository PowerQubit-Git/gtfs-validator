package tml.centralapi.validatormain.model;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Document(collection = "IntendedOfferUploads")
public class IntendedOfferUpload {

    @Transient
    public static final String SEQUENCE_NAME = "raw_input_sequence";

    @Id
    private String id;

    private String publisherName;

    private Date uploadDate;

    private String validationReport;

    private String errorsReport;

    private Binary file;

    public Binary getFile() {
        return file;
    }

    public void setFile(Binary file) {
        this.file = file;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getValidationReport() {
        return validationReport;
    }

    public void setValidationReport(String validationReport) {
        this.validationReport = validationReport;
    }

    public String getErrorsReport() {
        return errorsReport;
    }

    public void setErrorsReport(String errorsReport) {
        this.errorsReport = errorsReport;
    }
}
