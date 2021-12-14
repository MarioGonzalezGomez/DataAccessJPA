package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "departamento")
@NamedQuery(name = "Departamento.findAll", query = "SELECT a FROM Departamento a")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private static UUID id;

    @Column
    private String nombre;

    @OneToOne
    private Programador jefeDepartamento;

    @Column
    private Double presupuesto;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Proyecto> proyectosTerminados;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Proyecto> proyectosDesarrollo;

    @Column
    private Double presupuestoAnual;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Programador> historicoJefes;



    public static Departamento fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, Departamento.class);
    }

    public String toJSON() {
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(this);
    }


    public static UUID getId() {
        return id;
    }

    public static void setId(UUID id) {
        Departamento.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Programador getJefeDepartamento() {
        return jefeDepartamento;
    }

    public void setJefeDepartamento(Programador jefeDepartamento) {
        this.jefeDepartamento = jefeDepartamento;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Set<Proyecto> getProyectosTerminados() {
        return proyectosTerminados;
    }

    public void setProyectosTerminados(Set<Proyecto> proyectosTerminados) {
        this.proyectosTerminados = proyectosTerminados;
    }

    public Set<Proyecto> getProyectosDesarrollo() {
        return proyectosDesarrollo;
    }

    public void setProyectosDesarrollo(Set<Proyecto> proyectosDesarrollo) {
        this.proyectosDesarrollo = proyectosDesarrollo;
    }

    public Double getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public void setPresupuestoAnual(Double presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }

    public Set<Programador> getHistoricoJefes() {
        return historicoJefes;
    }

    public void setHistoricoJefes(Set<Programador> historicoJefes) {
        this.historicoJefes = historicoJefes;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                ", jefeDepartamento=" + jefeDepartamento.getNombre() +
                ", presupuesto=" + presupuesto +
                ", proyectosTerminados=" + proyectosTerminados +
                ", proyectosDesarrollo=" + proyectosDesarrollo +
                ", presupuestoAnual=" + presupuestoAnual +
                ", historicoJefes=" + historicoJefes +
                '}';
    }
}

