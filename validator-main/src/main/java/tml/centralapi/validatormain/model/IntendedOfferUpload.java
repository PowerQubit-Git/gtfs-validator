package tml.centralapi.validatormain.model;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Document(collection = "IntendedOfferUploads")
public class IntendedOfferUpload {

    @Transient
    public static final String SEQUENCE_NAME = "raw_input_sequence";

    @Id
    private String id;

    private String publisherName;

    private Date uploadDate;

    private Notices validationReport;

    private Notices errorsReport;

    private List<TableResume> tableResumeList;

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

    public Notices getValidationReport() {
        return validationReport;
    }
    public void setValidationReport(Notices validationReport) { this.validationReport = validationReport; }

    public Notices getErrorsReport() {
        return errorsReport;
    }
    public void setErrorsReport(Notices errorsReport) {
        this.errorsReport = errorsReport;
    }

    public List<TableResume> getTableResumeList() { return tableResumeList; }
    public void setTableResumeList(List<TableResume> tableResumeList) { this.tableResumeList = tableResumeList; }
}
