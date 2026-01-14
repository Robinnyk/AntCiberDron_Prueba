package trDataAccess.DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import trDataAccess.DTOs.trHormigaDTO;
import trDataAccess.DTOs.trVWHormigaDTO;
import trDataAccess.Helpers.trDataHelperSQLiteDAO;
import trInfrastructure.AppException;

public class trHormigaDAO extends trDataHelperSQLiteDAO<trHormigaDTO>{
    public trHormigaDAO() throws AppException {
        super(trHormigaDTO.class, "Hormiga", "IdHormiga");
    }

    public List<trVWHormigaDTO> readAllvwHormiga() throws AppException {
        trVWHormigaDTO dto;
        List<trVWHormigaDTO> lst = new ArrayList<>();
        String query = " SELECT trIdHormiga"
                      +"  ,Tipo         "   
                      +"  ,Sexo         "
                      +"  ,EstadoHormiga"   
                      +"  ,Nombre       "
                      +"  ,Descripcion  "
                      +"  ,Estado       "
                      +"  ,FechaCreacion"   
                      +"  ,FechaModifica" 
                      +"  FROM trvwHormiga";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                dto = new trVWHormigaDTO(rs.getString(1)        // trIdHormiga
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