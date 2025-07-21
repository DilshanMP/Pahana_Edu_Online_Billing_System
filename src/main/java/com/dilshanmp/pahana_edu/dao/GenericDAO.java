package com.dilshanmp.pahana_edu.dao;



import java.sql.SQLException;
import java.util.List;

/**
 * Generic DAO interface demonstrating use of Generics
 * Implements Interface Segregation Principle (ISP) from SOLID
 * @param <T> The entity type
 * @param <ID> The primary key type
 */
public interface GenericDAO<T, ID> {

    /**
     * Save entity to database
     * @param entity Entity to save
     * @return Saved entity with generated ID
     * @throws SQLException if database operation fails
     */
    T save(T entity) throws SQLException;

    /**
     * Update entity in database
     * @param entity Entity to update
     * @return true if update successful
     * @throws SQLException if database operation fails
     */
    boolean update(T entity) throws SQLException;

    /**
     * Delete entity by ID
     * @param id Entity ID
     * @return true if deletion successful
     * @throws SQLException if database operation fails
     */
    boolean delete(ID id) throws SQLException;

    /**
     * Find entity by ID
     * @param id Entity ID
     * @return Entity if found, null otherwise
     * @throws SQLException if database operation fails
     */
    T findById(ID id) throws SQLException;

    /**
     * Find all entities
     * @return List of all entities
     * @throws SQLException if database operation fails
     */
    List<T> findAll() throws SQLException;
}