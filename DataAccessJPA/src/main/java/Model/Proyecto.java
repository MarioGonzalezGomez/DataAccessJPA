package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.persistence.*;
import java.util.Date;
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
    private Set<Tecnologias> tecnologias;

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
}
