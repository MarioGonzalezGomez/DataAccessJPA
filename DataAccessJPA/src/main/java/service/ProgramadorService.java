package service;

import dto.ProgramadorDTO;
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

public class ProgramadorService extends BaseService<Programador, String, ProgramadorRepository> {
    ProgramadorMapper mapper = new ProgramadorMapper();
    public ProgramadorService(ProgramadorRepository repository) {
        super(repository);
    }

    public List<ProgramadorDTO> getAllProgramadores() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public ProgramadorDTO getProgramadorById(String id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public ProgramadorDTO postProgramador(ProgramadorDTO programadorDTO) throws SQLException {

        Programador res = this.save(mapper.fromDTO(programadorDTO));
        return mapper.toDTO(res);
    }

    public ProgramadorDTO updateProgramador(ProgramadorDTO programadorDTO) throws SQLException {
        Programador res = this.update(mapper.fromDTO(programadorDTO));
        return mapper.toDTO(res);
    }

    public ProgramadorDTO deleteProgramador(ProgramadorDTO programadorDTO) throws SQLException {
        Programador res = this.delete(mapper.fromDTO(programadorDTO));
        return mapper.toDTO(res);
    }




}
