package data.repositories;

import data.models.Diary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryRepositoryImplTest {
    DiaryRepository diaryRepo;
    @BeforeEach
    void setUp(){
        diaryRepo = new DiaryRepositoryImpl();
    }
    @Test
    void sata(){
        assertNotNull(diaryRepo);
    }
    @Test
    public void whenOneDiaryIsAdded_diaryCountIsOneTest(){
        Diary diary = new Diary();
        diary.setDiaryName("Diary Maiyaki");
        diaryRepo.save(diary);
        assertEquals(1, diaryRepo.count());
    }
    @Test
    public void whenTwoDiariesAreAdded_diaryCountIsTwo(){
        Diary diary1 = new Diary();
        Diary diary2 = new Diary();
        diary1.setDiaryName("Diary Timbuchalka");
        diary2.setDiaryName("Diary Salsa");
        diaryRepo.save(diary1);
        diaryRepo.save(diary2);
        assertEquals(2, diaryRepo.count());
    }
    @Test
    public void whenIAddADiary_ICanFindTheDiaryTest(){
        Diary diary = new Diary();
        diary.setUserName("Loko");
        diary.setDiaryName("Bando_Location");
        diaryRepo.save(diary);
        //assertEquals(diary, diaryRepo.findBy("Bando_Location"));
        assertSame(diary, diaryRepo.findBy("Bando_Location"));
    }
    @Test
    public void whenIAddTwoDiaries_ICanFindTheLastDiaryAdded(){
        Diary diary = new Diary();
        Diary diary2 = new Diary();
        diary.setUserName("Afolasho");
        diary.setDiaryName("Diary_Manicquin");
        diaryRepo.save(diary);
        diary2.setDiaryName("Diary_Mangu");
        diaryRepo.save(diary2);
        assertSame(diary2, diaryRepo.findBy("Diary_Mangu"));
    }
   @Test
    public void whenIAddTwoDiaries_ICanFindTheFirstDiaryAdded(){
        Diary diary1 = new Diary();
        Diary diary2 = new Diary();
        diary1.setUserName("Tochukwu");
        diary2.setUserName("Diary_Mo");
        diary1.setDiaryName("Zazu_Diary");
        diaryRepo.save(diary1);
        diary2.setDiaryName("Diary_Tukuchu");
        diaryRepo.save(diary2);
        assertSame(diary1, diaryRepo.findBy("Zazu_Diary"));
    }
    @Test
    public void saveTwoDiary_AndDeleteTheDiary(){
        Diary diary1 = new Diary();
        Diary diary2 = new Diary();
        diary1.setDiaryName("Darda_Diary");
        diaryRepo.save(diary1);
        diary2.setDiaryName("London_Diary");
        diaryRepo.save(diary2);
        diaryRepo.delete("Darda_Diary");
        assertEquals(1, diaryRepo.count());
    }
    //I should come back to this one below
   @Test
    public void whenIFindDiary_TheDiaryIsReturned(){
        Diary diary1 = new Diary();
        diary1.setDiaryName("Dai Diary");
        diary1.setUserName("Fela");
        diaryRepo.save(diary1);
        assertSame(diary1, diaryRepo.findBy("Fela"));
    }
}