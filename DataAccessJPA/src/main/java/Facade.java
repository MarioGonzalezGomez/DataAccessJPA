import Controller.ProyectoController;
import database.DataBaseController;
import dto.ProyectoDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;


    public class Facade {
        private static Facade instance;


        public static Facade getInstance() {
            if (instance == null) {
                instance = new Facade();
            }
            return instance;
        }


        public void checkService() {
            DataBaseController controller = DataBaseController.getInstance();
            try {
                controller.open();
                Optional<ResultSet> rs = controller.select("SELECT 'Hello World'");
                if (rs.isPresent()) {
                    rs.get().first();
                    controller.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al conectar al servidor de Base de Datos: " + e.getMessage());
                System.exit(1);
            }
        }


        public void initDataBase() {
            String sqlFile = System.getProperty("user.dir") + File.separator + "sql" + File.separator + "init_db.sql";
            //System.out.println(sqlFile);
            DataBaseController controller = DataBaseController.getInstance();
            try {
                controller.open();
                controller.initData(sqlFile);
                controller.close();
            } catch (SQLException | FileNotFoundException e) {
                System.err.println("Error al conectar al servidor de Base de Datos: " + e.getMessage());
                System.exit(1);
            }

        }

        public void Proyectos() {
            System.out.println("INICIO PROYECTOS");

            ProyectoController proyectoController = ProyectoController.getInstance();

            System.out.println("GET todos los proyectos");
            System.out.println(proyectoController.getAllProyectos());

            System.out.println("GET Proyecto con ID = 2");
            System.out.println(proyectoController.getProyectoById("2"));

         /*   System.out.println("POST Proyecto");
            ProyectoDTO proyectoDTO = ProyectoDTO.builder()
                    .("Insert " + LocalDateTime.now())
                    .build();
            System.out.println(categoryController.postCategory(categoryDTO));

           */

            System.out.println("DELETE Proyecto con ID 6");
            Optional<ProyectoDTO> optionalProyectoDTO = proyectoController.getProyectoyByIdOptional("4");
            if (optionalProyectoDTO.isPresent()) {
                optionalProyectoDTO.get().setNombre("Update " + LocalDateTime.now());
                //Quizá haya que poner todos los datos
                System.out.println(proyectoController.updateProyecto(optionalProyectoDTO.get()));
            }


        }
    }
