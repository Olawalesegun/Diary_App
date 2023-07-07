package data.repositories;

import data.models.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository{
    private List<Diary> diaries = new ArrayList<>();

    @Override
    public Diary save(Diary diary) {
        Diary foundUser = findBy(diary.getUserName());
        if(foundUser != null){
            diaries.add(diary);
            return diary;
        }
      return null;
    }

    @Override
    public Diary findBy(String diaryName) {
        for(Diary diary: diaries){
            if(diary.getDiaryName().equals(diaryName)){
                return diary;
            }
        }
        return null;
    }

    @Override
    public void delete(String diaryName) {

    }

    @Override
    public void delete(Diary diary) {

    }

    @Override
    public long count() {
        return diaries.size();
    }
}
