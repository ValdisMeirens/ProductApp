package lv.javaguru.classwork.finalwork.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    Long save(T object);

    List<T> finalAll();

    Optional<T> findById(Long id);

    void delete(Long id);

}
