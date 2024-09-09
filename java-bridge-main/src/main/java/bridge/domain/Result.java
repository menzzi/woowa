package bridge.domain;

public enum Result {
    SUCCESS("성공"),
    FAILURE("실패");

    private final String message;

    Result(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
