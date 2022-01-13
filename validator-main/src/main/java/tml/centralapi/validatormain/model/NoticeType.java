package tml.centralapi.validatormain.model;

import java.util.ArrayList;

public class NoticeType {
    String code;
    String severity;
    int totalNotices;
    ArrayList<NoticeTypeSample> sampleNotices;

    public NoticeType() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public int getTotalNotices() {
        return totalNotices;
    }

    public void setTotalNotices(int totalNotices) {
        this.totalNotices = totalNotices;
    }

    public ArrayList<NoticeTypeSample> getSampleNotices() {
        return sampleNotices;
    }

    public void setSampleNotices(ArrayList<NoticeTypeSample> sampleNotices) {
        this.sampleNotices = sampleNotices;
    }
}

//{
//        "code":"missing_required_column",
//        "severity":"ERROR",
//        "totalNotices":2,
//        "sampleNotices":[
//        {
//        "filename":"agency.txt",
//        "fieldName":"agency_timezone"
//        },
//        {
//        "filename":"agency.txt",
//        "fieldName":"agency_url"
//        }
//        ]
//        }
