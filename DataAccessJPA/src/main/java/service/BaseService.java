package service;

import repository.CrudRepository;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor // Requerimos un constructor con al menos las propiedades finales
public abstract class BaseService<T, String, R extends CrudRepository<T, String>> {
    protected final R repository;

    // Operaciones CRUD

    // Obtiene todos
    public List<T> findAll() throws SQLException {
        return repository.findAll();
    }

    // Obtiene por ID
    public T getById(UUID d) throws SQLException {
        return repository.getById(d);
    }

    // Salva
    public T save(T t) throws SQLException {
        return repository.save(t);
    }

    // Actualiza
    public T update(T t) throws SQLException {
        return repository.update(t);
    }

    // Elimina
    public T delete(UUID t) throws SQLException {
        return repository.delete(t);
    }


}
