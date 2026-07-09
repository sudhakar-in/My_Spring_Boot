package in.sk.globalExceptionHandling.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationExceptionResponse {
    private int statusCode;
    private String message;
    private String error;
    private Map<String, String> fieldErrors;
    private String path;
    private LocalDateTime timestamp;

    public ValidationExceptionResponse(int statusCode, String message, String error, Map<String, String> fieldErrors, String path, LocalDateTime timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.error = error;
        this.fieldErrors = fieldErrors;
        this.path = path;
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
