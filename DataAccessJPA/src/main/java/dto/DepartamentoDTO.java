package dto;

import model.Programador;
import model.Proyecto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class DepartamentoDTO {
//Esta clase ya tiene objetos.

    private UUID id;
    private String nombre;
    private Programador jefeDepartamento;
    private Double presupuesto;
    private Set<Proyecto> proyectosTerminados;
    private Set<Proyecto> proyectosDesarrollo;
    private Double presupuestoAnual;
    private Set<Programador> historicoJefes;
    private UUID idJefe;


    public static DepartamentoDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, DepartamentoDTO.class);
    }

    public String toJSON() {
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(this);
    }


}
