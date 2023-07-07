package data.models;

import java.time.LocalDateTime;

public class User {
    private String userName;
    private String diaryName;
    private final LocalDateTime dateAndTimeForDiaryCreation = LocalDateTime.now();

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }

    public LocalDateTime getDateAndTimeForDiaryCreation() {
        return dateAndTimeForDiaryCreation;
    }
}
