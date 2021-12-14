package mapper;

import model.Proyecto;
import dto.ProyectoDTO;
import repository.DepartamentoRepository;
import repository.ProgramadorRepository;


public class ProyectoMapper extends BaseMapper<Proyecto, ProyectoDTO> {


    @Override
    public Proyecto fromDTO(ProyectoDTO item) {
        Proyecto proyecto = new Proyecto();
        DepartamentoRepository pr = new DepartamentoRepository();
        ProgramadorRepository pror = new ProgramadorRepository();
        if (item.getId() != null) {
            proyecto.setId(item.getId());
        }
        proyecto.setNombre(item.getNombre());
        proyecto.setDepartamento(pr.getById(item.getIdDepartamento()));
        proyecto.setJefeProyecto(item.getJefeProyecto());
        proyecto.setPresupuesto(item.getPresupuesto());
        proyecto.setFecha_fin(item.getFecha_fin());
        proyecto.setFecha_inicio(item.getFecha_inicio());
        proyecto.setProgramador(pror.getById(item.getIdProgramador()));
        return null;
    }

    @Override
    public ProyectoDTO toDTO(Proyecto item) {
        return ProyectoDTO.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .idDepartamento(item.getDepartamento().getId())
                .jefeProyecto(item.getJefeProyecto())
                .presupuesto(item.getPresupuesto())
                .fecha_fin(item.getFecha_fin())
                .fecha_inicio(item.getFecha_inicio())
                .idProgramador(item.getProgramador().getId())
                .build();
    }
}
