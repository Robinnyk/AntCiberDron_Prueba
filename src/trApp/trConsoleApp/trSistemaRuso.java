package trApp.trConsoleApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import trBusinessLogic.Entities.trCoordenadaUK;

public class trSistemaRuso {

    public List<trCoordenadaUK> readCoord(String fileNamePath) throws IOException {
        List<trCoordenadaUK> lstCoord = new java.util.ArrayList<>();
        List<String> allLines = Files.readAllLines(Paths.get(fileNamePath));
        for (String line : allLines) {
            System.out.println(line);
            String[] coord = line.split(",");
            trCoordenadaUK trCoordenada = new trCoordenadaUK( coord[0], coord[6], false);
            lstCoord.add(trCoordenada);
            //System.out.println( trCoordenada.toString() );
        }
        return lstCoord;
    }
}
