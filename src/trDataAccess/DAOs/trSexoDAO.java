package trDataAccess.DAOs;

import trDataAccess.DTOs.trSexoDTO;
import trDataAccess.Helpers.trDataHelperSQLiteDAO;
import trInfrastructure.AppException;

public class trSexoDAO extends trDataHelperSQLiteDAO<trSexoDTO>{
    public trSexoDAO() throws AppException {
        super(trSexoDTO.class, "Sexo", "IdSexo");
    }
}
