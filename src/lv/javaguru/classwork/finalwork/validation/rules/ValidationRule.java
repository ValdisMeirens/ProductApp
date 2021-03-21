package lv.javaguru.classwork.finalwork.validation.rules;

import lv.javaguru.classwork.finalwork.model.error.ValidationError;

import java.util.Optional;

public interface ValidationRule<T> {

    Optional<ValidationError> execute(T object);

}
