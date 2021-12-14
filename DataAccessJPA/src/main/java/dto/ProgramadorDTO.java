package dto;

import model.Departamento;
import model.Proyecto;
import model.Tecnologias;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class ProgramadorDTO {
    private UUID id;
    private String nombre;
    private Date fecha_alta;
    private Departamento departamento;
    private Set<Proyecto> proyectos;
    private Tecnologias tecnologias;
    private Double sueldo;
    private UUID idDepartamento;
    private String contraseña;



    public static ProgramadorDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, ProgramadorDTO.class);
    }

    public String toJSON() {
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(this);
    }



}
