package repository;

import controller.HibernateController;
import model.Programador;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class ProgramadorRepository implements repository.CrudRepository<Programador, String> {
    HibernateController hb;

    public ProgramadorRepository() {
        hb = new HibernateController();
    }

    public List<Programador> findAll() {
        hb.open();
        TypedQuery<Programador> query = hb.getManager().createNamedQuery("Programador.findAll", Programador.class);
        List<Programador> programadores = query.getResultList();
        hb.close();
        return programadores;
    }

    public Programador getById(UUID id) {
        hb.open();
        Programador prog = hb.getManager().find(Programador.class, id);
        hb.close();
        return prog;
    }

    public Programador save(Programador prog) throws SQLException {
        hb.open();
        try {
            hb.getTransaction().begin();
            hb.getManager().persist(prog);
            hb.getTransaction().commit();
            hb.close();
        } catch (Exception e) {

        } finally {
            if (hb.getTransaction().isActive()) {
                hb.getTransaction().rollback();
            }
            hb.close();

        }
        return prog;
    }


    public Programador update(Programador prog) throws SQLException {
        hb.open();
        try {
            hb.getTransaction().begin();
            hb.getManager().merge(prog);
            hb.getTransaction().commit();
            hb.close();
            return prog;
        } catch (Exception e) {
            throw new SQLException("Error al actualizar programador con id: " + prog.getId());
        } finally {
            if (hb.getTransaction().isActive()) {
                hb.getTransaction().rollback();
            }
            hb.close();

        }

    }

    public Programador delete(UUID id) throws SQLException {

        hb.open();
        try {
            hb.getTransaction().begin();
            Programador prog = hb.getManager().find(Programador.class, Programador.getId());
            hb.getManager().remove(prog);
            hb.getTransaction().commit();
            hb.close();
            return prog;
        } catch (Exception e) {
            throw new SQLException("Error al eliminar programador con id: " + id);
        } finally {
            if (hb.getTransaction().isActive()) {
                hb.getTransaction().rollback();
            }
            hb.close();

        }
    }
}
