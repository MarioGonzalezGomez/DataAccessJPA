package Model;

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
    private Set<Proyecto> proyectos;

    @OneToMany(mappedBy = "programador", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Tecnologias> tecnologias;

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
}

