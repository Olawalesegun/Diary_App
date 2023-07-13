package dtos.responses;

import java.time.LocalDateTime;

public class CreateDiaryResponse {
    private String dateAndTimeEntered;
    private String diaryName;

    public void setDateAndTimeEntered(String dateEntered) {
        this.dateAndTimeEntered = dateEntered;
    }
    public String getDateAndTimeEntered() {
        return dateAndTimeEntered;
    }
    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }

    @Override
    public String toString() {
        return "CreateDiaryResponse{" +
                "dateEntered='" + dateAndTimeEntered + '\'' +
                ", diaryName='" + diaryName + '\'' +
                '}';
    }
}
