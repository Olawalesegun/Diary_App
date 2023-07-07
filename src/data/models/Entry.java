package data.models;

import java.time.LocalDateTime;

public class Entry {
    private String entryTitle;
    private String entryBody;
    private LocalDateTime dateOfEntryCreation = LocalDateTime.now();
    private String userName;
    private int entryId;

    public String getEntryTitle() {
        return entryTitle;
    }
    public void setEntryTitle(String entryTitle) {
        this.entryTitle = entryTitle;
    }
    public String getEntryBody() {
        return entryBody;
    }

    public void setEntryBody(String entryBody) {
        this.entryBody = entryBody;
    }

    public LocalDateTime getDateOfEntryCreation() {
        return dateOfEntryCreation;
    }

    public void setDateOfEntryCreation(LocalDateTime dateOfEntryCreation) {
        this.dateOfEntryCreation = dateOfEntryCreation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }
}
