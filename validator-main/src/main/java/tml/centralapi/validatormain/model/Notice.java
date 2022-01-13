package tml.centralapi.validatormain.model;

import java.util.ArrayList;

public class Notice {
    ArrayList<NoticeType> notices;

    public Notice() {}

    public ArrayList<NoticeType> getNotices() {
        return notices;
    }

    public void setNotices(ArrayList<NoticeType> notices) {
        this.notices = notices;
    }
}
