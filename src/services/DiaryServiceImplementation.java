package services;

import data.models.Diary;
import data.repositories.DiaryRepository;
import data.repositories.DiaryRepositoryImpl;
import dtos.requests.*;
import dtos.responses.*;

public class DiaryServiceImplementation implements DiaryService{
    DiaryRepository diaryRepository = new DiaryRepositoryImpl();
    @Override
    public CreateDiaryResponse createDiary(CreateDiaryRequest createDiaryRequest) {
        Diary diary = new Diary();
        diary.setUserName(createDiaryRequest.getUserName());
        diary.setDiaryName(createDiaryRequest.getDiaryName());
        diaryRepository.save(diary);
        CreateDiaryResponse createDiaryResponse = new CreateDiaryResponse();
        createDiaryResponse.setDiaryName(createDiaryRequest.getDiaryName());
        createDiaryResponse.setDateEntered(createDiaryRequest.getTimeEntered());
        createDiaryResponse.setTimeEntered();
        return createDiaryResponse;
    }

    @Override
    public DeleteDiaryResponse deleteDiary(DeleteDiaryResponse deleteDiaryResponse) {
        return null;
    }

    @Override
    public CreateEntryResponse createEntry(CreateDiaryRequest createDiaryRequest) {
        return null;
    }

    @Override
    public UpdateEntryResponse updateEntry(UpdateEntryRequest updateEntryRequest) {
        return null;
    }

    @Override
    public DeleteDiaryResponse deleteEntry(DeleteDiaryRequest deleteDiaryRequest) {
        return null;
    }

    @Override
    public FindEntryResponse findEntry(FindEntryRequest findDiaryRequest) {

        return null;
    }

    @Override
    public FindDiaryResponse findDiary(FindDiaryRequest findDiaryRequest) {
        /*diaryRepository.findBy(findDiaryRequest)*/
        return null;
    }

    @Override
    public long count() {
        return diaryRepository.count();
    }
}
