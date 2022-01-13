package tml.centralapi.validatormain.model;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document(collection = "test")
public class UploadHistoricMongo {
    @Transient
    public static final String SEQUENCE_NAME = "raw_input_sequence";

    @Id
    private Long id;

    private String publisherName;

    private String uploadDate;

    private String fileName;

    private String notices;



    private Binary file;

    public UploadHistoricMongo() {

    }

    public UploadHistoricMongo(Long id, String publisherName, String uploadDate, String fileName) {
        this.id = id;
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

    public Binary getFile() {
        return file;
    }

    public void setFile(Binary file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + fileName + '\'' +
                ", lastName='" + publisherName + '\'' +
                ", email='" + notices + '\'' +
                '}';
    }

}
