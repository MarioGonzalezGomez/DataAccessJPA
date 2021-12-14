package repository;

import Controller.HibernateController;
import model.Proyecto;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProyectoRepository implements CrudRepository<Proyecto, String> {
    HibernateController hb;

    public ProyectoRepository() {
        hb = new HibernateController();
    }

    public Optional<List<Proyecto>> findAll() {
        hb.open();
        TypedQuery<Proyecto> query = hb.getManager().createNamedQuery("Proyecto.findAll", Proyecto.class);
        Optional<List<Proyecto>> proyectos = Optional.ofNullable(query.getResultList());
        hb.close();
        return proyectos;
    }

    public Optional<Proyecto> findById(UUID id) {
        hb.open();
        Proyecto proy = hb.getManager().find(Proyecto.class, id);
        hb.close();
        return Optional.of(proy);
    }

    public Optional<Proyecto> save(Proyecto proy) throws SQLException {
        hb.open();
        try {
            hb.getTransaction().begin();
            hb.getManager().persist(proy);
            hb.getTransaction().commit();
            hb.close();
            return Optional.of(proy);
        } catch (Exception e) {

        } finally {
            if (hb.getTransaction().isActive()) {
                hb.getTransaction().rollback();
            }
            hb.close();

        }
        return Optional.empty();
    }


    public Optional<Proyecto> update(Proyecto proy) throws SQLException {
        hb.open();
        try {
            hb.getTransaction().begin();
            hb.getManager().merge(proy);
            hb.getTransaction().commit();
            hb.close();
            return Optional.of(proy);
        } catch (Exception e) {
            throw new SQLException("Error al actualizar proyecto con id: " + proy.getId());
        } finally {
            if (hb.getTransaction().isActive()) {
                hb.getTransaction().rollback();
            }
            hb.close();

        }

    }

    public Optional<Proyecto> delete(UUID id) throws SQLException {

        hb.open();
        try {
            hb.getTransaction().begin();
            Proyecto proy = hb.getManager().find(Proyecto.class, Proyecto.getId());
            hb.getManager().remove(proy);
            hb.getTransaction().commit();
            hb.close();
            return Optional.of(proy);
        } catch (Exception e) {
            throw new SQLException("Error al eliminar proyecto con id: " + id);
        } finally {
            if (hb.getTransaction().isActive()) {
                hb.getTransaction().rollback();
            }
            hb.close();

        }
    }
}
