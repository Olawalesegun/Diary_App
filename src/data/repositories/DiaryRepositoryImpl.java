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

    public Diary findBy(Diary diary){
        for(Diary diary1: diaries){
            if(diary1.getDiaryName().equals(diary.getDiaryName()) &&
            diary1.getUserName().equals(diary.getUserName())){
                return diary;
            }
        }
        return null;
    }

  /*  @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        } else {
            boolean var10000;
            if (anObject instanceof String) {
                String aString = (String)anObject;
                if ((!COMPACT_STRINGS || this.coder == aString.coder) && StringLatin1.equals(this.value, aString.value)) {
                    var10000 = true;
                    return var10000;
                }
            }

            var10000 = false;
            return var10000;
        }
    }*/
    @Override
    public void delete(Diary diary) {
        Diary findDiary = findBy(diary.getDiaryName());
        if(findDiary.getDiaryName().equals(diary.getDiaryName()) &&
        findDiary.getUserName() == diary.getUserName()){
            diaries.remove(diary);
        }

    }

    public void update(Diary diaryName, Diary newDiaryName){
        int indexOfDiary = diaries.indexOf(diaryName);
        diaries.set(indexOfDiary, newDiaryName);
    }


    @Override
    public long count() {
        return diaries.size();
    }
}
