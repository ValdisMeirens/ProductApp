package lv.javaguru.classwork.finalwork.validation;

import lv.javaguru.classwork.finalwork.model.Product;
import lv.javaguru.classwork.finalwork.model.error.ProductValidationException;
import lv.javaguru.classwork.finalwork.model.error.ValidationError;
import lv.javaguru.classwork.finalwork.validation.rules.NotNullProductCategory;
import lv.javaguru.classwork.finalwork.validation.rules.NotNullProductName;
import lv.javaguru.classwork.finalwork.validation.rules.NotNullProductPrice;
import lv.javaguru.classwork.finalwork.validation.rules.ValidationRule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductValidator {

    private NotNullProductName notNullProductName;
    private NotNullProductCategory notNullProductCategory;
    private NotNullProductPrice notNullProductPrice;
    //VME
    private List<ValidationRule<Product>> validationRules = Arrays.asList(notNullProductName, notNullProductCategory, notNullProductPrice);
    private Product product;

    public ProductValidator(NotNullProductName notNullProductName,
                            NotNullProductCategory notNullProductCategory,
                            NotNullProductPrice notNullProductPrice,
                            Product product) {
        this.notNullProductName = notNullProductName;
        this.notNullProductCategory = notNullProductCategory;
        this.notNullProductPrice = notNullProductPrice;
        this.product = product;

    }
//            new NotNullProductName(),
//            new NotNullProductCategory(),
//            new NotNullProductPrice()
//    );

    public void validate() {
        List<ValidationError> validationErrors =
                validationRules.stream()
                        .map(rule -> rule.execute(this.product))
//                        .flatMap(Optional::stream)
                        .flatMap(error -> error.isPresent() ? Stream.of(error.get()) : Stream.empty())  //for JDK 8 users
                        .collect(Collectors.toList());

        if (!validationErrors.isEmpty()) {
            throw new ProductValidationException(validationErrors);
        }

    }

}
