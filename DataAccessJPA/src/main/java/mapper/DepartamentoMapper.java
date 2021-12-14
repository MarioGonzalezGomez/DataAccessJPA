package mapper;

import dto.DepartamentoDTO;
import model.Departamento;

public class DepartamentoMapper extends BaseMapper<Departamento, DepartamentoDTO> {
    @Override
    public Departamento fromDTO(DepartamentoDTO item) {
        Departamento departamento = new Departamento();
        if (item.getId() != null) {
            departamento.setId(item.getId());
        }
        departamento.setNombre(item.getNombre());
        departamento.setJefeDepartamento(item.getJefeDepartamento());
        departamento.setPresupuesto(item.getPresupuesto());
        departamento.setHistoricoJefes(item.getHistoricoJefes());
        departamento.setPresupuestoAnual(item.getPresupuestoAnual());
        departamento.setProyectosDesarrollo(item.getProyectosDesarrollo());
        departamento.setProyectosTerminados(item.getProyectosTerminados());
        return null;
    }

    @Override
    public DepartamentoDTO toDTO(Departamento item) {
        return DepartamentoDTO.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .jefeDepartamento(item.getJefeDepartamento())
                .presupuesto(item.getPresupuesto())
                .historicoJefes(item.getHistoricoJefes())
                .presupuestoAnual(item.getPresupuestoAnual())
                .proyectosDesarrollo(item.getProyectosDesarrollo())
                .proyectosTerminados(item.getProyectosTerminados())
                .build();


    }

}

