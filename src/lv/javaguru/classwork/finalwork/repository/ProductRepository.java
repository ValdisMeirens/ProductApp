package lv.javaguru.classwork.finalwork.repository;

import lv.javaguru.classwork.finalwork.model.Product;

import java.util.*;

public class ProductRepository implements Repository<Product> {

    private Long idCounter = 0L;

    public ProductRepository() {
        this.repo = new HashMap<>();
    }

    public ProductRepository(Map<Long, Product> repo) {
        this.repo = repo;
    }

    private final Map<Long, Product> repo;

    @Override
    public Long save(Product product) {
        idCounter++;
        product.setId(idCounter);
        repo.put(idCounter, product);
        return idCounter;
    }

    @Override
    public List<Product> finalAll() {
        return new ArrayList<>(repo.values());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(repo.get(id));
    }

    @Override
    public void delete(Long id) {
        repo.remove(id);
    }

}
