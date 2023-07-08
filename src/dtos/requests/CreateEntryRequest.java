package dtos.requests;

public class CreateEntryRequest {
    private String entryTitle;
    private String entryBody;
    private String diaryName;
    private String diaryBody;

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

    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }

    public String getDiaryBody() {
        return diaryBody;
    }

    public void setDiaryBody(String diaryBody) {
        this.diaryBody = diaryBody;
    }
}
