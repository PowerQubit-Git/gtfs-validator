package tml.centralapi.validatormain.model;

import javax.persistence.*;

@Entity
@Table(name = "intended_offer_uploads")
public class UploadHistoric {

    @Id
    @Column(name = "intended_offer_uploads_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "publisher_name")
    private String publisherName;

    @Column(name = "upload_date")
    private String uploadDate;

    @Column(name = "filename")
    private String fileName;

    @Column(name = "notices")
    private String notices;

    public UploadHistoric() {

    }

    public UploadHistoric(String publisherName, String uploadDate, String fileName) {
        this.publisherName = publisherName;
        this.uploadDate = uploadDate;
        this.fileName = fileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getNotices() {
        return notices;
    }

    public void setNotices(String notices) {
        this.notices = notices;
    }
}
