package in.sk.springBootCrudDemo.dto;

import java.util.List;

public class ResponseDTO<T> {

    private boolean success;
    private String message;
    private List<String> errors;
    private T data;

    public ResponseDTO(boolean success, String message, List<String> errors) {
        this.success = success;
        this.message = message;
        this.errors = errors;
    }

    public ResponseDTO(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public T getData() {
        return data;
    }
}
