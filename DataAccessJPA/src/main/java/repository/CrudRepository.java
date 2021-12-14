package repository;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CrudRepository<T, String> {

    // Operaciones CRUD

    // Obtiene todos
    List<T> findAll() throws SQLException;

    // Obtiene por ID
    T getById(UUID d) throws SQLException;

    // Salva
    T save(T t) throws SQLException;

    // Actualiza
    T update(T t) throws SQLException;

    // Elimina
    T delete(UUID d) throws SQLException;


}
