package Model;

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
}

