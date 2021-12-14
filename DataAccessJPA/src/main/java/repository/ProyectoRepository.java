package repository;

import controller.HibernateController;
import model.Proyecto;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

import java.util.UUID;

public class ProyectoRepository implements repository.CrudRepository<Proyecto, String> {
    HibernateController hb;

    public ProyectoRepository() {
        hb = new HibernateController();
    }

    public List<Proyecto> findAll() {
        hb.open();
        TypedQuery<Proyecto> query = hb.getManager().createNamedQuery("Proyecto.findAll", Proyecto.class);
       List<Proyecto> proyectos = query.getResultList();
        hb.close();
        return proyectos;
    }

    public Proyecto getById(UUID id) {
        hb.open();
        Proyecto proy = hb.getManager().find(Proyecto.class, id);
        hb.close();
        return proy;
    }

    public Proyecto save(Proyecto proy) throws SQLException {
        hb.open();
        try {
            hb.getTransaction().begin();
            hb.getManager().persist(proy);
            hb.getTransaction().commit();
            hb.close();
            return proy;
        } catch (Exception e) {

        } finally {
            if (hb.getTransaction().isActive()) {
                hb.getTransaction().rollback();
            }
            hb.close();

        }
        return null;
    }


    public Proyecto update(Proyecto proy) throws SQLException {
        hb.open();
        try {
            hb.getTransaction().begin();
            hb.getManager().merge(proy);
            hb.getTransaction().commit();
            hb.close();
            return proy;
        } catch (Exception e) {
            throw new SQLException("Error al actualizar proyecto con id: " + proy.getId());
        } finally {
            if (hb.getTransaction().isActive()) {
                hb.getTransaction().rollback();
            }
            hb.close();

        }

    }

    public Proyecto delete(UUID id) throws SQLException {

        hb.open();
        try {
            hb.getTransaction().begin();
            Proyecto proy = hb.getManager().find(Proyecto.class, Proyecto.getId());
            hb.getManager().remove(proy);
            hb.getTransaction().commit();
            hb.close();
            return proy;
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
