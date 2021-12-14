package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "programador")
@NamedQuery(name = "Programador.findAll", query = "SELECT a FROM Programador a")
public class Programador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private static UUID id;

    @Column
    private String nombre;
    @Column
    private Date fecha_alta;

    @ManyToOne
    @JoinColumn(name = "departamento", referencedColumnName = "id")
    private Departamento departamento;

    @OneToMany(mappedBy = "programador", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<model.Proyecto> proyectos;

    @OneToMany(mappedBy = "programador", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<model.Tecnologias> tecnologias;

    @Column
    private Double sueldo;


    public static Programador fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, Programador.class);
    }

    public String toJSON() {
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(this);
    }

    public static UUID getId() {
        return id;
    }

    public static void setId(UUID id) {
        Programador.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Set<model.Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(Set<model.Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public Set<model.Tecnologias> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(Set<model.Tecnologias> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Programador{" +
                "nombre='" + nombre + '\'' +
                ", fecha_alta=" + fecha_alta +
                ", departamento=" + departamento +
                ", proyectos=" + proyectos +
                ", tecnologias=" + tecnologias +
                ", sueldo=" + sueldo +
                '}';
    }
}

