package service;

import repository.ProyectoRepository;
import dto.ProyectoDTO;
import mapper.ProyectoMapper;
import model.Proyecto;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;


public class ProyectoService extends service.BaseService<Proyecto, String, ProyectoRepository> {

    ProyectoMapper mapper = new ProyectoMapper();

    public ProyectoService(ProyectoRepository repository) {
        super(repository);
    }

    public List<ProyectoDTO> getAllProyectos() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public ProyectoDTO getProyectoById(UUID id) throws SQLException {
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
        Proyecto res = this.delete((mapper.fromDTO(proyectoDTO)).getId());
        return mapper.toDTO(res);
    }


}
