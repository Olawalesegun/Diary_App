package dtos.responses;

public class FindDiaryResponse {

    @Override
    public String toString() {
        return String.format("""
                ======================================================
                   You have successfully registered %s
                ======================================================
                """);
    }
}
