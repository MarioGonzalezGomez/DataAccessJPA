package repository;


import controller.HibernateController;
import model.Departamento;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class DepartamentoRepository implements repository.CrudRepository<Departamento, String> {
    HibernateController hb;

    public DepartamentoRepository() {
        hb = new HibernateController();
    }

    public List<Departamento> findAll() {
        hb.open();
        TypedQuery<Departamento> query = hb.getManager().createNamedQuery("Departamento.findAll", Departamento.class);
        List<Departamento> departamentos = query.getResultList();
        hb.close();
        return departamentos;
    }

    public Departamento getById(UUID id) {
        hb.open();
        Departamento dep = hb.getManager().find(Departamento.class, id);
        hb.close();
        return dep;
    }

    public Departamento save(Departamento dep) throws SQLException {
        hb.open();
        try {
            hb.getTransaction().begin();
            hb.getManager().persist(dep);
            hb.getTransaction().commit();
            hb.close();

        } catch (Exception e) {

        } finally {
            if (hb.getTransaction().isActive()) {
                hb.getTransaction().rollback();
            }
            hb.close();

        }
        return dep;
    }


    public Departamento update(Departamento dep) throws SQLException {
        hb.open();
        try {
            hb.getTransaction().begin();
            hb.getManager().merge(dep);
            hb.getTransaction().commit();
            hb.close();
            return dep;
        } catch (Exception e) {
            throw new SQLException("Error al actualizar departamento con id: " + dep.getId());
        } finally {
            if (hb.getTransaction().isActive()) {
                hb.getTransaction().rollback();
            }
            hb.close();

        }

    }

    public Departamento delete(UUID id) throws SQLException {

        hb.open();
        try {
            hb.getTransaction().begin();
            Departamento dep = hb.getManager().find(Departamento.class, Departamento.getId());
            hb.getManager().remove(dep);
            hb.getTransaction().commit();
            hb.close();
            return dep;
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
