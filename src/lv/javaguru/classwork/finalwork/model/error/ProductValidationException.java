package lv.javaguru.classwork.finalwork.model.error;

import java.util.List;

public class ProductValidationException extends RuntimeException {

    private final List<ValidationError> validationErrors;

    public ProductValidationException(List<ValidationError> validationErrors) {
        super("Validation failed");
        this.validationErrors = validationErrors;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }
}
