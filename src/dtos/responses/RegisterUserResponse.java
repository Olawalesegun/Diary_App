package dtos.responses;

public class RegisterUserResponse {
    private String userName;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String toString(){
        return String.format("""
                ======================================================
                   You have successfully registered %s
                ======================================================
                """,getUserName()
        );
    }


}
