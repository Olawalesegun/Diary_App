package data.repositories;

import data.models.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository{
    private List<Diary> diaries = new ArrayList<>();

    @Override
    public Diary save(Diary diary) {
        Diary foundUser = findBy(diary.getDiaryName());
        if(foundUser != null){
            update(diary, foundUser);
        }
        else{
            diaries.add(diary);
        }
        return diary;
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
        Diary findDiary = findBy(diaryName);
        diaries.remove(findDiary);
    }

    public void update(Diary diaryName, Diary newDiaryName){
        int indexOfDiary = diaries.indexOf(diaryName);
        diaries.set(indexOfDiary, newDiaryName);
    }
    @Override
    public void delete(Diary diary) {

    }

    @Override
    public long count() {
        return diaries.size();
    }
}
