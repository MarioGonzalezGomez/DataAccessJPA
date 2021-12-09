package Model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tecnologias")
@NamedQuery(name = "Tecnologias.findAll", query = "SELECT a FROM Tecnologias a")
public enum Tecnologias {
    KOTLIN,
    GITHUB,
    CSHARP,
    GITKRAKEN,
    JAVASCRIPT,
    PYTHON,
    HTML,
    CSS,
    WORDPRESS;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "programador_id")
    private Programador programador;

}

