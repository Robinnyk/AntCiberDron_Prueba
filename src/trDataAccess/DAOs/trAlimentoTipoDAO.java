package trDataAccess.DAOs;

import trDataAccess.DTOs.trAlimentoExistenteDTO;
import trDataAccess.Helpers.trDataHelperSQLiteDAO;
import trInfrastructure.AppException;

public class trAlimentoTipoDAO extends trDataHelperSQLiteDAO<trAlimentoExistenteDTO>{

    public trAlimentoTipoDAO() throws AppException {
        super(trAlimentoExistenteDTO.class, "trAlimentoTipo", "trIdAlimentoTipo");
    }
    
}
