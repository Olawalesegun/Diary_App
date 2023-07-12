package services;

import data.models.Diary;
import data.repositories.DiaryRepository;
import data.repositories.DiaryRepositoryImpl;
import dtos.requests.*;
import dtos.responses.*;
import exceptions.DiaryDoesNotExist;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DiaryServiceImplementation implements DiaryService{
    DiaryRepository diaryRepository = new DiaryRepositoryImpl();
    @Override
    public CreateDiaryResponse createDiary(CreateDiaryRequest createDiaryRequest) {
        Diary diary = new Diary();
        map(diary, createDiaryRequest);
        CreateDiaryResponse createDiaryResponse = new CreateDiaryResponse();
        LocalDateTime dateAndTime = diary.getDateAndTimeForDiaryCreation();
        String date = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss").format(dateAndTime);
        map(diary, createDiaryResponse, date);
        ///
        //String date = diary.getDateAndTimeForDiaryCreation();
        return createDiaryResponse;
    }

    @Override
    public DeleteDiaryResponse deleteDiary(DeleteDiaryRequest deleteDiaryRequest) {
        /*Diary diary1 = diaryRepository.findBy(deleteDiaryRequest.getDiaryName());
        if(diary1.getDiaryName() == null){
            throw new DiaryDoesNotExist("This diary does not exist");
        }else{

        }*/
        DeleteDiaryResponse deleteDiaryResponse = new DeleteDiaryResponse();
        //deleteDiaryResponse.
        return deleteDiaryResponse;
    }

    public void map(Diary diary, CreateDiaryRequest createDiaryRequest){
        diary.setUserName(createDiaryRequest.getUserName());
        diary.setDiaryName(createDiaryRequest.getDiaryName());
        diaryRepository.save(diary);
    }
    public void map(Diary diary, CreateDiaryResponse createDiaryResponse, String DateAndTime){
        createDiaryResponse.setDiaryName(diary.getDiaryName());
        createDiaryResponse.setDateAndTimeEntered(DateAndTime);
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
    public DeleteEntryResponse deleteEntry(DeleteEntryRequest deleteEntryRequest) {
        return null;
    }

    @Override
    public FindEntryResponse findEntry(FindEntryRequest findDiaryRequest) {

        return null;
    }

    @Override
    public FindDiaryResponse findDiary(FindDiaryRequest findDiaryRequest) {
        Diary returnedDiaryAfterFinding = diaryRepository.findBy(findDiaryRequest.getDiaryName());
        if(returnedDiaryAfterFinding == null){
            throw new DiaryDoesNotExist("This diary does not exist");
        }else{
          if(returnedDiaryAfterFinding.getDiaryName() == findDiaryRequest.getDiaryName()&&
          returnedDiaryAfterFinding.getUserName() == findDiaryRequest.getUserName()){
              FindDiaryResponse findDiaryResponse = new FindDiaryResponse();
              return findDiaryResponse;
          }
        }

        /* findDiaryRequest.getDiaryName();
        Diary diaryFound = diaryRepository.findBy(findDiaryRequest.getDiaryName());
        if(diaryFound == null){
            throw new DiaryDoesNotExist("This diary does not exist");
        }else{
            if(diaryFound.getDiaryName() == findDiaryRequest.getDiaryName() &&
            diaryFound.getUserName() == findDiaryRequest.getUserName()){
                diaryRepository.delete();
            }
        }*/

        /*diaryRepository.findBy(findDiaryRequest)*/
        return null;
    }

    @Override
    public long count() {
        return diaryRepository.count();
    }
}
