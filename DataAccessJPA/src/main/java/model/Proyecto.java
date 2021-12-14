package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "proyecto")
@NamedQuery(name = "Proyecto.findAll", query = "SELECT a FROM Proyecto a")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private static UUID id;

    @ManyToOne
    @JoinColumn(name = "jefeProyecto", referencedColumnName = "id")
    private Programador jefeProyecto;
    @Column
    private String nombre;
    @Column
    private Double presupuesto;
    @Column
    private Date fecha_inicio;
    @Column
    private Date fecha_fin;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<model.Tecnologias> tecnologias;

    @ManyToOne
    @JoinColumn(name = "departamento")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "programador_id")
    private Programador programador;


    public static Proyecto fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, Proyecto.class);
    }

    public String toJSON() {
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(this);
    }

    public static UUID getId() {
        return id;
    }

    public static void setId(UUID id) {
        Proyecto.id = id;
    }

    public Programador getJefeProyecto() {
        return jefeProyecto;
    }

    public void setJefeProyecto(Programador jefeProyecto) {
        this.jefeProyecto = jefeProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Set<model.Tecnologias> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(Set<model.Tecnologias> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Programador getProgramador() {
        return programador;
    }

    public void setProgramador(Programador programador) {
        this.programador = programador;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "jefeProyecto=" + jefeProyecto.getNombre() +
                ", nombre='" + nombre + '\'' +
                ", presupuesto=" + presupuesto +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", tecnologias=" + tecnologias +
                ", departamento=" + departamento.getNombre() + " " + departamento.getPresupuesto() + " " + departamento.getPresupuestoAnual() +
                ", programador=" + programador.getNombre() +
                '}';
    }
}
