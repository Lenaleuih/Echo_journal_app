package com.example.android.sfinalproject_lenalshuangtingy;

import java.io.Serializable;

public class Journal implements Serializable {
    private String journalMonth;
    private String journalDay;
    private String journalText;
    private int journalPhoto;
    private boolean marked;

    public Journal(String journalMonth, String journalDay, String journalText,  boolean marked) {
        this.journalMonth = journalMonth;
        this.journalDay = journalDay;
        this.journalText = journalText;
        this.marked = marked;
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

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
