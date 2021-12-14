package mapper;


import model.Programador;
import dto.ProgramadorDTO;

public class ProgramadorMapper extends BaseMapper<Programador, ProgramadorDTO> {

    @Override
    public Programador fromDTO(ProgramadorDTO item) {
        Programador programador = new Programador();
        if (item.getId() != null) {
            programador.setId(item.getId());
        }
        programador.setNombre(item.getNombre());
        programador.setFecha_alta(item.getFecha_alta());
        programador.setSueldo(item.getSueldo());
        programador.setDepartamento(item.getDepartamento());
        return programador;


        }

    @Override
    public ProgramadorDTO toDTO(Programador item) {
        return ProgramadorDTO.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .fecha_alta(item.getFecha_alta())
                .sueldo(item.getSueldo())
                .idDepartamento(item.getDepartamento().getId())
                .build();
    }
}


