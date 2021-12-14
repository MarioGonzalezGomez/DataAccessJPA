package controller;

import repository.ProyectoRepository;
import service.ProyectoService;
import dto.ProyectoDTO;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProyectoController {
    private static ProyectoController controller = null;

    // Mi Servicio unido al repositorio
    private final ProyectoService proyectoService;

    // Implementamos nuestro Singleton para el controlador
    private ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    public static ProyectoController getInstance() {
        if (controller == null) {
            controller = new ProyectoController(new ProyectoService(new ProyectoRepository()));
        }
        return controller;
    }

    public List<ProyectoDTO> getAllProyectos() {
        try {
            return proyectoService.getAllProyectos();
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en getAllCategories: " + e.getMessage());
            return null;
        }
    }

    public ProyectoDTO getProyectoById(UUID id) {
        try {
            return proyectoService.getProyectoById(id);
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en getCategoryById: " + e.getMessage());
            return null;
        }
    }

    public ProyectoDTO postProyecto(ProyectoDTO proyectoDTO) {
        try {
            return proyectoService.postProyecto(proyectoDTO);
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en postCategory: " + e.getMessage());
            return null;
        }
    }

    public ProyectoDTO updateProyecto(ProyectoDTO proyectoDTO) {
        try {
            return proyectoService.updateProyecto(proyectoDTO);
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en updateCategory: " + e.getMessage());
            return null;
        }
    }

    public ProyectoDTO deleteProyecto(ProyectoDTO proyectoDTO) {
        try {
            return proyectoService.deleteProyecto(proyectoDTO);
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en deleteCategory: " + e.getMessage());
            return null;
        }
    }


    public Optional<ProyectoDTO> getProyectoyByIdOptional(UUID id) {
        try {
            return Optional.of(proyectoService.getProyectoById(id));
        } catch (SQLException e) {
            System.err.println("Error ProyectoController en getCategoryById: " + e.getMessage());
            return Optional.empty();
        }
    }

}
