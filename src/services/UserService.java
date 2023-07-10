package services;

import dtos.requests.*;
import dtos.responses.*;
import exceptions.PasswordDoesNotMatchException;
import exceptions.UserLoginDetailsIncorrectException;
import exceptions.UserNameDoesNotExistException;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
    LoginUserResponse loginUser(LoginUserRequest loginUserRequest) throws UserLoginDetailsIncorrectException, UserNameDoesNotExistException, PasswordDoesNotMatchException;
    ChangePasswordResponse changePassword(ChangePasswordRequest changePasswordRequest);

    boolean isLoggedIn(String userName);
    CreateDiaryResponse createDiary(CreateDiaryRequest createDiaryRequest);
    CreateEntryResponse createEntry(CreateEntryRequest createEntryRequest);
    DeleteDiaryResponse deleteEntry(DeleteDiaryRequest deleteEntryRequest);
    long count();
}
