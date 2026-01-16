package trDataAccess.DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import trDataAccess.DTOs.trHormigaDTO;
import trDataAccess.DTOs.trFaVWHormigaDTO;
import trDataAccess.Helpers.trDataHelperSQLiteDAO;
import trInfrastructure.AppException;

public class trHormigaDAO extends trDataHelperSQLiteDAO<trHormigaDTO>{
    public trHormigaDAO() throws AppException {
        super(trHormigaDTO.class, "trHormiga", "trIdHormiga");
    }

    public List<trFaVWHormigaDTO> readAllvwHormiga() throws AppException {
        trFaVWHormigaDTO dto;
        List<trFaVWHormigaDTO> lst = new ArrayList<>();
        String query = " SELECT trIdHormiga"
                    +"  ,trTipo         "   
                    +"  ,trSexo         "
                    +"  ,trEstadoHormiga"   
                    +"  ,trNombre       "
                    +"  ,trDescripcion  "
                    +"  ,trEstado       "
                    +"  ,trFechaCreacion"   
                    +"  ,trFechaModifica" 
                    +"  FROM vwHormiga";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                dto = new trFaVWHormigaDTO(rs.getString(1)      // trIdHormiga
                                        ,rs.getString(2)        // trTipo            
                                        ,rs.getString(3)        // trSexo        
                                        ,rs.getString(4)        // trEstadoHormiga 
                                        ,rs.getString(5)        // trNombre 
                                        ,rs.getString(6)        // trDescripcion
                                        ,rs.getString(7)        // trEstado
                                        ,rs.getString(8)        // trFechaCreacion
                                        ,rs.getString(9)        // trFechaModifica
                                    ); 
                lst.add(dto);
            }
        } 
        catch (SQLException e) {
            throw new AppException("Ups... porblemas con la vista", e, getClass(), "getVWHormiga()");
        }
        return lst;
    }
}