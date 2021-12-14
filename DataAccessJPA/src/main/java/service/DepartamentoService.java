package service;

import repository.DepartamentoRepository;
import dto.DepartamentoDTO;
import mapper.DepartamentoMapper;
import model.Departamento;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class DepartamentoService extends service.BaseService<Departamento, String, DepartamentoRepository> {
    DepartamentoMapper mapper = new DepartamentoMapper();
    public DepartamentoService(DepartamentoRepository repository) {
        super(repository);
    }

    public List<DepartamentoDTO> getAllDepartamentos() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public DepartamentoDTO getDepartamentoById(UUID id) throws SQLException {
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
        Departamento res = this.delete((mapper.fromDTO(departamentoDTO)).getId());
        return mapper.toDTO(res);
    }


}



