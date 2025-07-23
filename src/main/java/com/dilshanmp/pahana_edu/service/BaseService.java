package com.dilshanmp.pahana_edu.service;

public interface BaseService<T> {
    T save(T entity) throws Exception;
    T update(T entity) throws Exception;
    T delete(T entity) throws Exception;
    T findById(int id) throws Exception;
    T findAll(int id) throws Exception;

    boolean validate(T entity);
}
