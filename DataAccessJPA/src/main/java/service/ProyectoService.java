package service;

import dto.DepartamentoDTO;
import dto.ProyectoDTO;
import mapper.DepartamentoMapper;
import mapper.ProyectoMapper;
import model.Departamento;
import model.Programador;
import model.Proyecto;
import repository.DepartamentoRepository;
import repository.ProgramadorRepository;
import repository.ProyectoRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProyectoService extends BaseService<Proyecto, String, ProyectoRepository> {

    ProyectoMapper mapper = new ProyectoMapper();
    public ProyectoService(ProyectoRepository repository) {
        super(repository);
    }

    public List<ProyectoDTO> getAllProyectos() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public ProyectoDTO getProyectoById(String id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public ProyectoDTO postProyecto(ProyectoDTO proyectoDTO) throws SQLException {

        Proyecto res = this.save(mapper.fromDTO(proyectoDTO));
        return mapper.toDTO(res);
    }

    public ProyectoDTO updateProyecto(ProyectoDTO proyectoDTO) throws SQLException {
        Proyecto res = this.update(mapper.fromDTO(proyectoDTO));
        return mapper.toDTO(res);
    }

    public ProyectoDTO deleteProyecto(ProyectoDTO proyectoDTO) throws SQLException {
        Proyecto res = this.delete(mapper.fromDTO(proyectoDTO));
        return mapper.toDTO(res);
    }



}
