package trDataAccess.DAOs;

import trDataAccess.DTOs.trAlimentoTipoDTO;
import trDataAccess.Helpers.trDataHelperSQLiteDAO;
import trInfrastructure.AppException;

public class trAlimentoTipoDAO extends trDataHelperSQLiteDAO<trAlimentoTipoDTO>{
    public trAlimentoTipoDAO() throws AppException {
        super(trAlimentoTipoDTO.class, "AlimentoTipo", "IdAlimentoTipo");
    }
}
