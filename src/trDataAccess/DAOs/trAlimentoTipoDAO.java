package trDataAccess.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import trDataAccess.DTOs.trAlimentoTipoDTO;
import trDataAccess.DTOs.trGenomasTipoDTO;
import trDataAccess.DTOs.trSexoDTO;
import trDataAccess.Helpers.trSQLiteDataHelper;
import trDataAccess.Interfaces.trIDAO;
import trFramework.trRBException;
import trInfrastructure.AppException;

public class trAlimentoTipoDAO extends trSQLiteDataHelper implements trIDAO<trAlimentoTipoDTO>{
     @Override
    public boolean create(trAlimentoTipoDTO entity) throws Exception {

        String query = "INSERT INTO trCatalogo (trCatalogoTipo, trNombre, trDescripcion) VALUES (?, ?, ?)";
       
        try {
            Connection conn = trOpenConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 2); // Tipo 2 para Sexo Masculino
            pstmt.setString(2, entity.getTrNombre());
            pstmt.setString(3, entity.getTrDescripcion());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new trRBException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<trAlimentoTipoDTO> readAll() throws Exception {

        List <trAlimentoTipoDTO> listaAlimentos = new ArrayList<>();
        String query = "SELECT trIdCatalogo"
                    + ", trIdCatalogoTipo"
                    + ", trNombre"
                    + ", trDescripcion"
                    + ", trEstado"
                    + ", trFechaCreacion"
                    + ", trFechaModifica"
                    + " FROM trCatalogo"
                    + " WHERE trEstado = 'A'"
                    + " AND trIdCatalogoTipo = 2"; // Tipo 2 para Sexo Masculino
  
        try {
            Connection conn = trOpenConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                trAlimentoTipoDTO alimento = new trAlimentoTipoDTO( rs.getInt(1),       // trIdCatalogo
                                                                 rs.getInt(2),       // trIdCatalogoTipo
                                                rs.getString(3),    // trNombre
                                                rs.getString(4),    // trDescripcion
                                                rs.getString(5),    // trEstado
                                                rs.getString(6),    // trFechaCreacion
                                                rs.getString(7));   // trFechaModifica
                
                listaAlimentos.add(alimento);
            }

        } catch (SQLException e) {
            throw new trRBException(e.getMessage(), getClass().getName(), "readAll()");
        }

        return listaAlimentos;
    }

    @Override
    public boolean update(trAlimentoTipoDTO entity) throws Exception {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE trCatalogo SET trNombre = ?, trDescripcion = ?, trFechaModifica = ? WHERE trIdCatalogo = ?;";

        try {
            Connection                  conn    = trOpenConnection();
            PreparedStatement           pstmt   = conn.prepareStatement(query);
            pstmt.setString(1, entity.getTrNombre());
            pstmt.setString(2, entity.getTrDescripcion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getTrIdCatalogo());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new trRBException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {

        String query = "UPDATE trCatalogo SET trEstado = ? WHERE trIdCatalogo = ?;";
        
        try {
            Connection conn = trOpenConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new trRBException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public trAlimentoTipoDTO readBy(Integer id) throws Exception {

        trAlimentoTipoDTO s = new trAlimentoTipoDTO();
        String query = "SELECT trIdCatalogo         "
                    + ", trIdCatalogoTipo           "
                    + ", trNombre                   "
                    + ", trDescripcion              "
                    + ", trEstado                   "
                    + ", trFechaCreacion            "
                    + ", trFechaModifica            "
                    + " FROM trCatalogo             "
                    + " WHERE trEstado = 'A'        "
                    + " AND trIdCatalogoTipo = 2    " // Tipo 2 para Sexo Masculino
                    + " AND trIdCatalogo = " + id.toString();
  
        try {
            Connection conn = trOpenConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                s = new trAlimentoTipoDTO( rs.getInt(1),       // trIdCatalogo
                                   rs.getInt(2),       // trIdCatalogoTipo
                                   rs.getString(3),    // trNombre
                                   rs.getString(4),    // trDescripcion
                                   rs.getString(5),    // trEstado
                                   rs.getString(6),    // trFechaCreacion
                                   rs.getString(7));   // trFechaModifica
                
            }

        } catch (SQLException e) {
            throw new trRBException(e.getMessage(), getClass().getName(), "readBy()");
        }

        return s;
    }

    public Integer getRowCout() throws Exception {

        String query = "SELECT COUNT(*) TotalReg "
                     + "FROM trCatalogo "
                     + " AND trIdCatalogoTipo = 2" 
                     + " WHERE trEstado = 'A';";

        try {
            Connection conn = trOpenConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
            }
            
        } catch (SQLException e) {
            throw new trRBException(e.getMessage(), getClass().getName(), "getRowCout()");

        }
        return 0;
    }
}
