package dtos.requests;

import java.time.LocalDateTime;

public class CreateDiaryRequest {
    private String userName;
    private String diaryName;
    private String DateAndTimeEntered;
    public String getTimeEntered() {
        return DateAndTimeEntered;
    }

    public void setTimeEntered(String timeEntered) {
        this.DateAndTimeEntered = DateAndTimeEntered;
    }



    /*private LocalDateTime timeEntered = LocalDateTime.now();

    public LocalDateTime getTimeEntered() {
        return timeEntered;
    }*/
    /*public void setTimeEntered(LocalDateTime timeEntered) {
        this.timeEntered = timeEntered;
    }*/

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


}
