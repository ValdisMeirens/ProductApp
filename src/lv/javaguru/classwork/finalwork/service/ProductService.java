package lv.javaguru.classwork.finalwork.service;

import lv.javaguru.classwork.finalwork.model.Product;
import lv.javaguru.classwork.finalwork.repository.ProductRepository;
import lv.javaguru.classwork.finalwork.validation.ProductValidator;

import java.util.List;
import java.util.Optional;

public class ProductService {

    private ProductRepository repository;
    private ProductValidator validator;

    public ProductService(ProductRepository repository, ProductValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public void save(Product product) {
        validator.validate(product);
        repository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    public List<Product> findAll() {
        return repository.finalAll();
    }

    public void deleteById(Long id) {
        repository.delete(id);
    }


}
