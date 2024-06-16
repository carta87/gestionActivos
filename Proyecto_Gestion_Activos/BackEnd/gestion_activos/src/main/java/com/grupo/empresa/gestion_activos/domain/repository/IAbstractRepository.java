package com.grupo.empresa.gestion_activos.domain.repository;

import java.util.List;
import java.util.Optional;

public interface IAbstractRepository<T, E> {
    List<T> findAll();
    Optional<T> findById(E entityId);
    T update(T entityToUpdate);
    void deleteById(E entityId);
}
