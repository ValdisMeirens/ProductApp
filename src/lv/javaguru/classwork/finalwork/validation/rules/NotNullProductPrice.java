package lv.javaguru.classwork.finalwork.validation.rules;

import lv.javaguru.classwork.finalwork.model.Product;
import lv.javaguru.classwork.finalwork.model.error.ValidationError;

import java.util.Optional;

public class NotNullProductPrice implements ValidationRule<Product> {

    @Override
    public Optional<ValidationError> execute(Product product) {
        if (product.getPrice() == null) {
            return Optional.of(new ValidationError("price", "Value should not be null"));
        }
        return Optional.empty();
    }
}
