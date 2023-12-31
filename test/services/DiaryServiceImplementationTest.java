package services;

import dtos.requests.CreateDiaryRequest;
import dtos.requests.DeleteDiaryRequest;
import dtos.responses.DeleteDiaryResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryServiceImplementationTest {
    DiaryService diaryService;
    @BeforeEach
    void setUp(){
        diaryService = new DiaryServiceImplementation();
    }
    @Test
    public void countThatDiaryExistTest(){
        assertNotNull(diaryService);
    }
    @Test
    public void whenISaveADiary_diaryCountIsOne(){
        CreateDiaryRequest createDiaryRequest = new CreateDiaryRequest();
        createDiaryRequest.setDiaryName("WallStreet Diary");
        createDiaryRequest.setUserName("Bamboo");
        diaryService.createDiary(createDiaryRequest);
        assertEquals(1, diaryService.count());
    }
    @Test
    public void whenICreateTwoDiary_diaryCountIsTwoTest(){
        CreateDiaryRequest createDiaryRequest = new CreateDiaryRequest();
        CreateDiaryRequest createDiaryRequest2 = new CreateDiaryRequest();
        createDiaryRequest.setUserName("ZazzuZeh");
        createDiaryRequest.setDiaryName("Bembe Stickz Diary");
        diaryService.createDiary(createDiaryRequest);
        createDiaryRequest2.setDiaryName("Diary Two");
        createDiaryRequest2.setUserName("Pempe Wallz");
        diaryService.createDiary(createDiaryRequest2);
        assertEquals(2, diaryService.count());
    }
    @Test
    public void whenICreate_DiaryResponseIsSuccessfulTest(){
        CreateDiaryRequest createDiaryRequest = new CreateDiaryRequest();
        createDiaryRequest.setUserName("Bombo");
        createDiaryRequest.setDiaryName("DiaryWako");
        diaryService.createDiary(createDiaryRequest);
        String response ;
    }
    @Test
    public void whenIDeleteDiary(){
        DeleteDiaryRequest deleteDiaryRequest = new DeleteDiaryRequest();
        deleteDiaryRequest.setDiaryName("Dembe Diary");
        deleteDiaryRequest.setUserName("Dembele");
        DeleteDiaryResponse diaryResponse = diaryService.deleteDiary(deleteDiaryRequest);
        String response = """
                =======================================
                      Diary is deleted successfully
                =======================================
                """;
        assertEquals(response, diaryResponse);
    }

}