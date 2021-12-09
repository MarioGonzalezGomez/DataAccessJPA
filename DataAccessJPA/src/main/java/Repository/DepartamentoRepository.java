package Repository;

import Controller.HibernateController;
import Model.Departamento;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DepartamentoRepository {
    HibernateController hb;

    public DepartamentoRepository() {
        hb = new HibernateController();
    }

    public Optional<List<Departamento>> findAll() {
        hb.open();
        TypedQuery<Departamento> query = hb.getManager().createNamedQuery("Departamento.findAll", Departamento.class);
        Optional<List<Departamento>> departamentos = Optional.ofNullable(query.getResultList());
        hb.close();
        return departamentos;
    }

    public Optional<Departamento> findById(UUID id) {
        hb.open();
        Departamento dep = hb.getManager().find(Departamento.class, id);
        hb.close();
        return Optional.of(dep);
    }

    public Optional<Departamento> save(Departamento dep) throws SQLException {
        hb.open();
        try {
            hb.getTransaction().begin();
            hb.getManager().persist(dep);
            hb.getTransaction().commit();
            hb.close();
            return Optional.of(dep);
        } catch (Exception e) {

        } finally {
            if (hb.getTransaction().isActive()) {
                hb.getTransaction().rollback();
            }
            hb.close();

        }
        return Optional.empty();
    }


    public Optional<Departamento> update(Departamento dep) throws SQLException {
        hb.open();
        try {
            hb.getTransaction().begin();
            hb.getManager().merge(dep);
            hb.getTransaction().commit();
            hb.close();
            return Optional.of(dep);
        } catch (Exception e) {
            throw new SQLException("Error al actualizar departamento con id: " + dep.getId());
        } finally {
            if (hb.getTransaction().isActive()) {
                hb.getTransaction().rollback();
            }
            hb.close();

        }

    }

    public Optional<Departamento> delete(UUID id) throws SQLException {

        hb.open();
        try {
            hb.getTransaction().begin();
            Departamento dep = hb.getManager().find(Departamento.class, Departamento.getId());
            hb.getManager().remove(dep);
            hb.getTransaction().commit();
            hb.close();
            return Optional.of(dep);
        } catch (Exception e) {
            throw new SQLException("Error al eliminar departamento con id: " + id);
        } finally {
            if (hb.getTransaction().isActive()) {
                hb.getTransaction().rollback();
            }
            hb.close();

        }
    }
}
