package services;

import dtos.requests.*;
import dtos.responses.*;

public interface DiaryService {

    CreateDiaryResponse createDiary(CreateDiaryRequest createDiaryRequest);
    DeleteDiaryResponse deleteDiary(DeleteDiaryRequest deleteDiaryRequest);
    CreateEntryResponse createEntry(CreateDiaryRequest createDiaryRequest);
    UpdateEntryResponse updateEntry(UpdateEntryRequest updateEntryRequest);
    DeleteEntryResponse deleteEntry(DeleteEntryRequest deleteEntryRequest);

    FindEntryResponse findEntry(FindEntryRequest findDiaryRequest);
    FindDiaryResponse findDiary(FindDiaryRequest findDiaryRequest);
    long count();
}
