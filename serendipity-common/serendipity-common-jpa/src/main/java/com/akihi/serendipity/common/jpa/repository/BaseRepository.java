package com.akihi.serendipity.common.jpa.repository;

import com.akihi.serendipity.common.core.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface BaseRepository <E extends Entity, ID extends Serializable> extends JpaRepository<E, ID>, JpaSpecificationExecutor<E> {
}











