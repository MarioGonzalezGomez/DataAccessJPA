package service;

import repository.ProgramadorRepository;
import dto.ProgramadorDTO;
import mapper.ProgramadorMapper;
import model.Programador;
import java.sql.SQLException;

import java.util.List;
import java.util.UUID;


public class ProgramadorService extends service.BaseService<Programador, String, ProgramadorRepository> {
    ProgramadorMapper mapper = new ProgramadorMapper();
    public ProgramadorService(ProgramadorRepository repository) {
        super(repository);
    }

    public List<ProgramadorDTO> getAllProgramadores() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public ProgramadorDTO getProgramadorById(UUID id) throws SQLException {
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
        Programador res = this.delete((mapper.fromDTO(programadorDTO)).getId());
        return mapper.toDTO(res);
    }




}
