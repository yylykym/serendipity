package com.akihi.serendipity.common.jpa.service;

import com.akihi.serendipity.common.core.entity.Entity;

import java.io.Serializable;
import java.util.List;

public interface WriteableService<E extends Entity, ID extends Serializable> extends ReadableService<E, ID> {
    default void delete(E entity) {
        this.getRepository().delete(entity);
    }

    default void deleteAllInBatch() {
        this.getRepository().deleteAllInBatch();
    }

    default void deleteAll(Iterable<E> entities) {
        this.getRepository().deleteAll(entities);
    }

    default void deleteAll() {
        this.getRepository().deleteAll();
    }

    default void deleteById(ID id) {
        this.getRepository().deleteById(id);
    }

    default E save(E domain) {
        return this.getRepository().save(domain);
    }

    default <S extends E> List<S> saveAll(Iterable<S> entities) {
        return this.getRepository().saveAll(entities);
    }

    default E saveAndFlush(E entity) {
        return this.getRepository().saveAndFlush(entity);
    }

    default List<E> saveAllAndFlush(List<E> entities) {
        return this.getRepository().saveAllAndFlush(entities);
    }

    default void flush() {
        this.getRepository().flush();
    }
}
