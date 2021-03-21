package lv.javaguru.classwork.finalwork.model.error;

public class ValidationError {

    private final String fieldName;
    private final String message;

    public ValidationError(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ValidationError{" +
                "fieldName='" + fieldName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
