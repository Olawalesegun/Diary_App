package data.models;

import java.time.LocalDateTime;

public class User {
    private String userName;
    private String diaryName;
    private String email;

    private boolean isLoggedIn;
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


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
