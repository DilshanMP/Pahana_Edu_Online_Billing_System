package com.dilshanmp.pahana_edu.dao;


import java.sql.SQLException;
import java.util.List;

/**
 * Generic DAO interface demonstrating use of Generics
 * 
 * Implements Interface Segregation Principle (ISP) from SOLID


 */
public interface GenericDAO<T, ID> {


    T save(T entity) throws SQLException;


    boolean update(T entity) throws SQLException;


    boolean delete(ID id) throws SQLException;


    T findById(ID id) throws SQLException;


    List<T> findAll() throws SQLException;
}