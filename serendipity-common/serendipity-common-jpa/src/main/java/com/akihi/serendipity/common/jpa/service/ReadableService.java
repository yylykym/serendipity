package com.akihi.serendipity.common.jpa.service;

import com.akihi.serendipity.common.core.entity.Entity;
import com.akihi.serendipity.common.jpa.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface ReadableService<E extends Entity, ID extends Serializable> {
    BaseRepository<E, ID> getRepository();

    default Optional<E> findById(ID id) {
        return this.getRepository().findById(id);
    }

    default boolean existsById(ID id) {
        return this.getRepository().existsById(id);
    }

    default long count() {
        return this.getRepository().count();
    }

    default long count(Specification<E> specification) {
        return this.getRepository().count(specification);
    }

    default List<E> findAll() {
        return this.getRepository().findAll();
    }

    default List<E> findAll(Sort sort) {
        return this.getRepository().findAll(sort);
    }

    default List<E> findAll(Specification<E> specification) {
        return this.getRepository().findAll(specification);
    }

    default List<E> findAll(Specification<E> specification, Sort sort) {
        return this.getRepository().findAll(specification, sort);
    }

    default Page<E> findByPage(Pageable pageable) {
        return this.getRepository().findAll(pageable);
    }

    default Page<E> findByPage(int pageNumber, int pageSize) {
        return this.findByPage(PageRequest.of(pageNumber, pageSize));
    }

    default Page<E> findByPage(int pageNumber, int pageSize, Sort sort) {
        return this.findByPage(PageRequest.of(pageNumber, pageSize, sort));
    }

    default Page<E> findByPage(int pageNumber, int pageSize, Sort.Direction direction, String... properties) {
        return this.findByPage(PageRequest.of(pageNumber, pageSize, direction, properties));
    }

    default Page<E> findByPage(Specification<E> specification, Pageable pageable) {
        return this.getRepository().findAll(specification, pageable);
    }

    default Page<E> findByPage(Specification<E> specification, int pageNumber, int pageSize) {
        return this.getRepository().findAll(specification, PageRequest.of(pageNumber, pageSize));
    }

    default Page<E> findByPage(int pageNumber, int pageSize, Sort.Direction direction) {
        return this.findByPage(PageRequest.of(pageNumber, pageSize, direction, new String[0]));
    }

}
