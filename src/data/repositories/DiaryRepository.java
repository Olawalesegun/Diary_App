package data.repositories;

import data.models.Diary;
public interface DiaryRepository {
    Diary save(Diary diary);
    Diary findBy(String diaryName);
   // void delete(String diaryName, String userName);
    void delete(Diary diary);
    long count();
}
