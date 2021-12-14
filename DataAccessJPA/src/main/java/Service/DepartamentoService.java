package Service;

import Model.Departamento;
import Repository.DepartamentoRepository;

import java.sql.SQLException;
import java.util.List;

public class DepartamentoService {
    Departamento mapper = new Departamento();

    public DepartamentoService(DepartamentoRepository repository) {
        super(repository);
    }

    public List<Departamento> getAllDepartamentos() throws SQLException {
        // Obtenemos la lista
        List<Departamento> result = this.findAll();
        return result;
    }

    public CommentDTO getCommentById(Long id) throws SQLException {
        CommentDTO commentDTO = mapper.toDTO(this.getById(id));
        return commentDTO;
    }

    public CommentDTO postComment(CommentDTO commentDTO) throws SQLException {
        Comment comment = this.save(mapper.fromDTO(commentDTO));
        CommentDTO res = mapper.toDTO(comment);
        return res;
    }

    public CommentDTO updateComment(CommentDTO commentDTO) throws SQLException {
        Comment comment = this.update(mapper.fromDTO(commentDTO));
        CommentDTO res = mapper.toDTO(comment);
        return res;
    }

    public CommentDTO deleteComment(CommentDTO commentDTO) throws SQLException {
        Comment comment = this.delete(mapper.fromDTO(commentDTO));
        CommentDTO res = mapper.toDTO(comment);
        return res;
    }
}
