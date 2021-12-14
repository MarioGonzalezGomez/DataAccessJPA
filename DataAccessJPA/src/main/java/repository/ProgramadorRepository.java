package repository;

import Controller.HibernateController;
import model.Departamento;
import model.Programador;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProgramadorRepository implements CrudRepository<Programador, String> {
    HibernateController hb;

    public ProgramadorRepository() {
        hb = new HibernateController();
    }

    public Optional<List<Programador>> findAll() {
        hb.open();
        TypedQuery<Programador> query = hb.getManager().createNamedQuery("Programador.findAll", Programador.class);
        Optional<List<Programador>> programadores = Optional.ofNullable(query.getResultList());
        hb.close();
        return programadores;
    }

    public Optional<Programador> findById(UUID id) {
        hb.open();
        Programador prog = hb.getManager().find(Programador.class, id);
        hb.close();
        return Optional.of(prog);
    }

    public Optional<Programador> save(Programador prog) throws SQLException {
        hb.open();
        try {
            hb.getTransaction().begin();
            hb.getManager().persist(prog);
            hb.getTransaction().commit();
            hb.close();
            return Optional.of(prog);
        } catch (Exception e) {

        } finally {
            if (hb.getTransaction().isActive()) {
                hb.getTransaction().rollback();
            }
            hb.close();

        }
        return Optional.empty();
    }


    public Optional<Programador> update(Programador prog) throws SQLException {
        hb.open();
        try {
            hb.getTransaction().begin();
            hb.getManager().merge(prog);
            hb.getTransaction().commit();
            hb.close();
            return Optional.of(prog);
        } catch (Exception e) {
            throw new SQLException("Error al actualizar programador con id: " + prog.getId());
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
            Departamento dep = hb.getManager().find(Departamento.class, Programador.getId());
            hb.getManager().remove(dep);
            hb.getTransaction().commit();
            hb.close();
            return Optional.of(dep);
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
