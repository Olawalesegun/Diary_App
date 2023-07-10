package services;

import data.models.User;
import dtos.requests.ChangePasswordRequest;
import dtos.requests.LoginUserRequest;
import dtos.requests.RegisterUserRequest;
import dtos.responses.ChangePasswordResponse;
import dtos.responses.RegisterUserResponse;
import exceptions.PasswordDoesNotMatchException;
import exceptions.UserDoesNotExistException;
import exceptions.UserNameAlreadyExistsException;
import exceptions.UserNameDoesNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplementationTest {
    UserService userService;

    @BeforeEach
    void setUp(){
        userService = new UserServiceImplementation();
    }
    @Test
    public void testThatUserServiceImplementationExist(){
        assertNotNull(userService);
    }
    @Test
    public void whenOneUserRegistersADiary_CountThatRegisteredUserIsOneTest(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUserName("Bolatito");
        registerUserRequest.setEmail("bola@gmail.com");
        registerUserRequest.setPassword("PararanPa");
        userService.registerUser(registerUserRequest);
        assertEquals(1, userService.count());
    }
    @Test
    public void whenTwoUserRegisterDiary_CountThatRegisteredUserIsTwoTest(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        RegisterUserRequest registerUserRequest2 = new RegisterUserRequest();
        registerUserRequest.setUserName("Bolatito");
        registerUserRequest.setEmail("bola@gmail.com");
        registerUserRequest.setPassword("PararanPa");
        registerUserRequest2.setUserName("Babana");
        registerUserRequest2.setEmail("ora@gmail.com");
        registerUserRequest2.setPassword("9087890");
        userService.registerUser(registerUserRequest);
        userService.registerUser(registerUserRequest2);
        assertEquals(2, userService.count());
    }
    @Test
    public void whenDifferentUserRegister_testThatRegisteredUsernameIsUniqueAndDoesntPermitDuplicateTest(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        RegisterUserRequest registerUserRequest2 = new RegisterUserRequest();
        registerUserRequest.setUserName("Bandana");
        registerUserRequest2.setUserName("Bandana");
        userService.registerUser(registerUserRequest);
        //userService.registerUser(registerUserRequest2);
        assertThrows(UserNameAlreadyExistsException.class,()-> userService.registerUser(registerUserRequest2));
        try{
            userService.registerUser(registerUserRequest2);
        }catch(UserNameAlreadyExistsException e){
            assertEquals("This User Already Exists", e.getMessage());
        }
    }
    @Test
    public void testThatWhenUserLoginWithRightLoginDetails_LoginEnters(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        registerUserRequest.setUserName("Darda09");
        registerUserRequest.setEmail("darda09@gmail.com");
        registerUserRequest.setPassword("Finalize");
        loginUserRequest.setUserName("Darda09");
        loginUserRequest.setPassword("Finalize");
        userService.registerUser(registerUserRequest);
        userService.loginUser(loginUserRequest);
        assertTrue(userService.isLoggedIn("Darda09"));
    }
    @Test
    public void testThatWhenUserLoginWithNoneExistingUserName_LoginFails(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        registerUserRequest.setUserName("Fadeke00");
        registerUserRequest.setEmail("Tabitha");
        registerUserRequest.setPassword("000987654");
        userService.registerUser(registerUserRequest);
        loginUserRequest.setUserName("Fadeke");
        loginUserRequest.setPassword("000987654");
       // userService.loginUser(loginUserRequest);
        assertThrows(UserDoesNotExistException.class,()-> userService.loginUser(loginUserRequest));
        try{
            userService.loginUser(loginUserRequest);
        }catch(UserDoesNotExistException u){
            assertEquals("This User does not exist", u.getMessage());
        }

    }
    @Test
    public void testThatWhenILoginWithWrongPassWord_LoginFailsTest(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        RegisterUserRequest registerUserRequest2 = new RegisterUserRequest();
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        registerUserRequest.setUserName("EbukizyOmoBabaIbo");
        registerUserRequest.setPassword("chukwuemeka");
        registerUserRequest.setEmail("odaba@chkw@gmail.com");
        userService.registerUser(registerUserRequest);
        registerUserRequest2.setUserName("Dang");
        registerUserRequest2.setEmail("dembele");
        registerUserRequest2.setPassword("090876");
        userService.registerUser(registerUserRequest2);
        loginUserRequest.setUserName("Dang");
        loginUserRequest.setPassword("chukwuemeka");
        assertThrows(PasswordDoesNotMatchException.class,()-> userService.loginUser(loginUserRequest));
        try{
            userService.loginUser(loginUserRequest);
        }catch(PasswordDoesNotMatchException p){
            assertEquals("Wrong password", p.getMessage());
        }
    }
    @Test
    public void whenIinputTheRightDetailsForRegistration_myRegistrationIsSuccessfulTesT(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUserName("EbukizyOmoBabaIbo");
        registerUserRequest.setPassword("chukwuemeka");
        registerUserRequest.setEmail("odaba@chkw@gmail.com");
        RegisterUserResponse registrationResponse = userService.registerUser(registerUserRequest);
        String response = """
                ======================================================
                   You have successfully registered EbukizyOmoBabaIbo
                ======================================================
                """;
        assertEquals(response, String.valueOf(registrationResponse));
    }
    @Test
    public void WhenIChangeMyPassword_PasswordChanges(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        registerUserRequest.setUserName("FolaAgoro");
        registerUserRequest.setEmail("fol@gmail.com");
        registerUserRequest.setPassword("09011111");
        userService.registerUser(registerUserRequest);
        changePasswordRequest.setUserName(registerUserRequest.getUserName());
        changePasswordRequest.setOldPassword(registerUserRequest.getPassword());
        changePasswordRequest.setNewPassword("Babalawo");
        ChangePasswordResponse passwordResponse = userService.changePassword(changePasswordRequest);
        String response = """
                ================================================
                   You have successfully changed your password
                ================================================
                """;
        assertEquals(response, String.valueOf(passwordResponse));
        //assertEquals(response, userService.changePassword(changePasswordRequest));

    }
}