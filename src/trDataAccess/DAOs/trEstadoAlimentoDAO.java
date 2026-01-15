package trDataAccess.DAOs;

import trDataAccess.DTOs.trEstadoAlimentoDTO;
import trDataAccess.Helpers.trDataHelperSQLiteDAO;
import trInfrastructure.AppException;

public class trEstadoAlimentoDAO extends trDataHelperSQLiteDAO<trEstadoAlimentoDTO> {
    public trEstadoAlimentoDAO() throws AppException {
        super(trEstadoAlimentoDTO.class, "EstadoAlimento", "IdEstadoAlimento");
    }
}


