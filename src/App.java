
import trDataAccess.trInitDatabase;

public class App {

    public static void main(String[] args) {
        
        // Inicializa la Base de Datos
        new trInitDatabase().init();

        // Arranca el sistema
        new trApp.trConsoleApp.trSistemaRuso().iniciar();
        
    }
}
