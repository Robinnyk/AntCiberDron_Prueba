package trDataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import trInfrastructure.AppConfig;

public class trInitDatabase {

    public void init() {
        try (Connection conn = DriverManager.getConnection(AppConfig.DATABASE);
             Statement stmt = conn.createStatement()) {

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS trHormiga (
                    trIdHormiga INTEGER PRIMARY KEY AUTOINCREMENT,
                    trIdHormigaTipo INTEGER,
                    trIdSexo INTEGER,
                    trIdEstado INTEGER,
                    trNombre TEXT,
                    trDescripcion TEXT,
                    trEstado TEXT DEFAULT 'A',
                    trFechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP,
                    trFechaModifica DATETIME DEFAULT CURRENT_TIMESTAMP
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS trAlimentoExistente (
                    trIdAlimentoExistente INTEGER PRIMARY KEY AUTOINCREMENT,
                    trIdAlimentoTipo INTEGER,
                    trIdEstadoAlimento INTEGER,
                    trDescripcion TEXT,
                    trGenoma TEXT,
                    trEstado TEXT DEFAULT 'A',
                    trFechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP,
                    trFechaModifica DATETIME DEFAULT CURRENT_TIMESTAMP
                );
            """);

            System.out.println("✔ Base de datos inicializada correctamente");

        } catch (Exception e) {
            System.out.println("✖ Error inicializando la BD");
            e.printStackTrace();
        }
    }
}
