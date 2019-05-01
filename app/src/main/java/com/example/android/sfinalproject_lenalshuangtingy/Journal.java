package com.example.android.sfinalproject_lenalshuangtingy;

public class Journal {
    private String journalTitle;
    private String journalMonth;
    private String journalDay;
    private String journalText;
    private int journalPhoto;

    public Journal(String journalTitle, String journalInfo, String journalMonth, String journalDay, String journalText, int journalPhoto) {
        this.journalTitle = journalTitle;
        this.journalMonth = journalMonth;
        this.journalDay = journalDay;
        this.journalText = journalText;
        this.journalPhoto = journalPhoto;
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }


    public int getJournalPhoto() {
        return journalPhoto;
    }

    public void setJournalPhoto(int journalPhoto) {
        this.journalPhoto = journalPhoto;
    }

    public String getJournalText() {
        return journalText;
    }

    public void setJournalText(String journalText) {
        this.journalText = journalText;
    }

    public String getJournalDay() {
        return journalDay;
    }

    public void setJournalDay(String journalDay) {
        this.journalDay = journalDay;
    }

    public String getJournalMonth() {
        return journalMonth;
    }

    public void setJournalMonth(String journalMonth) {
        this.journalMonth = journalMonth;
    }
}
