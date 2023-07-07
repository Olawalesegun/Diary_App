package data.repositories;

import data.models.Diary;
public interface DiaryRepository {
    Diary save(Diary diary);
    Diary findBy(String diaryName);
    void delete(String diaryName);
    void delete(Diary diary);
    long count();
}
