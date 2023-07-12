package dtos.requests;

public class FindDiaryRequest {

    private String diaryName;
    private String userName;

    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
