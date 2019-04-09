package com.example.android.sfinalproject_lenalshuangtingy;

public class Journal {
    private String journalTitle;
    private String journalInfo;
    private int journalPhoto;

    public Journal(String journalTitle, String journalInfo, int journalPhoto) {
        this.journalTitle = journalTitle;
        this.journalInfo = journalInfo;
        this.journalPhoto = journalPhoto;
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    public String getJournalInfo() {
        return journalInfo;
    }

    public void setJournalInfo(String journalInfo) {
        this.journalInfo = journalInfo;
    }

    public int getJournalPhoto() {
        return journalPhoto;
    }

    public void setJournalPhoto(int journalPhoto) {
        this.journalPhoto = journalPhoto;
    }
}
