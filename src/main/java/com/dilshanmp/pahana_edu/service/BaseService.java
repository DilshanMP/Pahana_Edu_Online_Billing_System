package com.dilshanmp.pahana_edu.service;

import java.util.List;

public interface BaseService<T> {
    T save(T entity) throws Exception;

    boolean update(T entity) throws Exception;

    boolean delete(T id) throws Exception;

    T findById(Integer id) throws Exception;

    List<T> findAll() throws Exception;

    boolean validate(T entity);


}

