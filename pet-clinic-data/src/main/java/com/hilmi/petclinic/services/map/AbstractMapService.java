package com.hilmi.petclinic.services.map;

import com.hilmi.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T entity) {
        if (entity == null)
            throw new IllegalArgumentException("Object cannot be null.");

        if (entity.getId() == null)
            entity.setId(getNextId());

        map.put(entity.getId(), entity);

        return entity;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T entity) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(entity));
    }

    private Long getNextId() {
        long nextId = 1L;

        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException ignored) {}

        return nextId;
    }
}
