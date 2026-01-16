package trDataAccess.DAOs;

import trDataAccess.DTOs.trAlimentoExistenteDTO;
import trDataAccess.Helpers.trDataHelperSQLiteDAO;
import trInfrastructure.AppException;

public class trAlimentoExistenteDAO extends trDataHelperSQLiteDAO<trAlimentoExistenteDTO> {
    
    public trAlimentoExistenteDAO() throws AppException {
        super(trAlimentoExistenteDTO.class, "trAlimentoExistente", "trIdAlimentoExistente");
    }
}

