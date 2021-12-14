import utils.AppProperties;

public class App {
    public static void main(String[] args) {


        System.out.println("Hola MPO-MANUAL!");
        AppProperties properties = new AppProperties();
        System.out.println("Bienvenid@s a " +
                properties.readProperty("app.title") + " "
                + properties.readProperty("app.version") + " de " +
                properties.readProperty("app.curso"));

        Facade facade = Facade.getInstance();
        // Chequeamos el sistema
        facade.checkService();

        // Iniciamos la base de datos al estado original en cada prueba
        if (properties.readProperty("database.init").equals("true"))
            facade.initDataBase();


        System.out.println("OPERACIONES CRUD Y SOLICITADAS");


    }


}
