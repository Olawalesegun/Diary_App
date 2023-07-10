package services;

import data.models.User;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dtos.requests.*;
import dtos.responses.*;
import exceptions.*;

public class UserServiceImplementation implements UserService{
    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        checkForDuplicate(registerUserRequest);
        User user = new User();
        user.setUserName(registerUserRequest.getUserName());
        user.setEmail(registerUserRequest.getEmail());
        user.setPassword(registerUserRequest.getPassword());
        userRepository.save(user);
        RegisterUserResponse response= new RegisterUserResponse();
        response.setUserName(registerUserRequest.getUserName());
        return response;
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest loginUserRequest){
        User checkIfUserFound = userRepository.findBy(loginUserRequest.getUserName());
        if (checkIfUserFound != null) {
            if (checkIfUserFound.getUserName() == loginUserRequest.getUserName() &&
                    checkIfUserFound.getPassword() == loginUserRequest.getPassword()) {
                checkIfUserFound.setLoggedIn(true);
                return new LoginUserResponse();
            }
            if (checkIfUserFound.getUserName() != loginUserRequest.getUserName()) {
                throw new UserNameDoesNotExistException("This User with such username does not exist.");
            }
            if (checkIfUserFound.getPassword() != loginUserRequest.getPassword()) {
                throw new PasswordDoesNotMatchException("Wrong password");
            }
        }
        else{
            throw new UserDoesNotExistException("This User does not exist");
        }
        return null;
    }

    @Override
    public ChangePasswordResponse changePassword(ChangePasswordRequest changePasswordRequest) {
        User checkIfUserIsFound = userRepository.findBy(changePasswordRequest.getUserName());
        if(checkIfUserIsFound != null){
            if(changePasswordRequest.getUserName() != checkIfUserIsFound.getUserName()){
                throw new UserNameDoesNotExistException(" User is not found");
            }
            if(changePasswordRequest.getOldPassword() != checkIfUserIsFound.getPassword()){
                throw new PasswordDoesNotMatchException("Wrong password entered");
            }
            if(changePasswordRequest.getUserName() == checkIfUserIsFound.getUserName() &&
            changePasswordRequest.getOldPassword() == checkIfUserIsFound.getPassword()){
                checkIfUserIsFound.setPassword(changePasswordRequest.getNewPassword());
                userRepository.save(checkIfUserIsFound);
            }
        }
        ChangePasswordResponse changePasswordResponse = new ChangePasswordResponse();
        changePasswordResponse.setNewPassword(changePasswordResponse.getNewPassword());
        return changePasswordResponse;
    }

    @Override
    public boolean isLoggedIn(String userName) {
        User foundUser = userRepository.findBy(userName);
        return foundUser.isLoggedIn();
    }

    @Override
    public CreateDiaryResponse createDiary(CreateDiaryRequest createDiaryRequest) {
        return null;
    }

    @Override
    public CreateEntryResponse createEntry(CreateEntryRequest createEntryRequest) {
        return null;
    }

    @Override
    public DeleteDiaryResponse deleteEntry(DeleteDiaryRequest deleteEntryRequest) {
        return null;
    }

    @Override
    public long count() {
        return userRepository.count();
    }
    public void checkForDuplicate(RegisterUserRequest userName){
        User checkIfUserExist = userRepository.findBy(userName.getUserName());
        if(checkIfUserExist == null){
            return;
        }
        else{
            throw new UserNameAlreadyExistsException("This User Already Exists");
        }
    }

  /*  public void checkForIncorrectLoginDetails(LoginUserRequest loginUserRequest) throws UserLoginDetailsIncorrectException {
        User checkIfLoginDetailsExist = userRepository.findBy(loginUserRequest.getUserName());
        if(loginUserRequest.getUserName().equals(checkIfLoginDetailsExist.getUserName())){
            return;
        }else {
            throw new UserLoginDetailsIncorrectException("The Login Details you have entered is incorrect");
        }
    }*/
}
