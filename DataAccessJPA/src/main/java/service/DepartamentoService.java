package service;

import dto.DepartamentoDTO;
import dto.ProgramadorDTO;
import mapper.DepartamentoMapper;
import mapper.ProgramadorMapper;
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

public class DepartamentoService extends BaseService<Departamento, String, DepartamentoRepository> {
    DepartamentoMapper mapper = new DepartamentoMapper();
    public DepartamentoService(DepartamentoRepository repository) {
        super(repository);
    }

    public List<DepartamentoDTO> getAllDepartamentos() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public DepartamentoDTO getDepartamentoById(String id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public DepartamentoDTO postDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {

        Departamento res = this.save(mapper.fromDTO(departamentoDTO));
        return mapper.toDTO(res);
    }

    public DepartamentoDTO updateDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
        Departamento res = this.update(mapper.fromDTO(departamentoDTO));
        return mapper.toDTO(res);
    }

    public DepartamentoDTO deleteDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
        Departamento res = this.delete(mapper.fromDTO(departamentoDTO));
        return mapper.toDTO(res);
    }


}



