package lv.javaguru.classwork.finalwork.validation;

import lv.javaguru.classwork.finalwork.model.Product;
import lv.javaguru.classwork.finalwork.model.error.ProductValidationException;
import lv.javaguru.classwork.finalwork.model.error.ValidationError;
import lv.javaguru.classwork.finalwork.validation.rules.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductValidator {

    private List<ValidationRule<Product>> validationRules = Arrays.asList(
            new NotNullProductName(),
            new NotNullProductCategory(),
            new NotNullProductPrice()
    );

    public void validate(Product product) {
        List<ValidationError> validationErrors =
                validationRules.stream()
                        .map(rule -> rule.execute(product))
//                        .flatMap(Optional::stream)
                        .flatMap(error -> error.isPresent() ? Stream.of(error.get()) : Stream.empty())  //for JDK 8 users
                        .collect(Collectors.toList());

        if (!validationErrors.isEmpty()) {
            throw new ProductValidationException(validationErrors);
        }

    }

}
