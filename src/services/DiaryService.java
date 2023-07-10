package services;

import dtos.requests.*;
import dtos.responses.*;

public interface DiaryService {

    CreateDiaryResponse createDiary(CreateDiaryRequest createDiaryRequest);
    DeleteDiaryResponse deleteDiary(DeleteDiaryResponse deleteDiaryResponse);
    CreateEntryResponse createEntry(CreateDiaryRequest createDiaryRequest);
    UpdateEntryResponse updateEntry(UpdateEntryRequest updateEntryRequest);
    DeleteDiaryResponse deleteEntry(DeleteDiaryRequest deleteDiaryRequest);
    FindEntryResponse findEntry(FindEntryRequest findDiaryRequest);
    FindDiaryResponse findDiary(FindDiaryRequest findDiaryRequest);
    long count();
}
