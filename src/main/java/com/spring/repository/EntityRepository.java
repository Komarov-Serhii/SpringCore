package com.spring.repository;

import java.util.List;
import java.util.Optional;

public interface EntityRepository<T, E extends Object> {

    Object findById(T id);

    List<E> findAll();

    E update(E entity);

    boolean deleteById(T id);

    E save(E entity);

}
