package trDataAccess.DAOs;

import trDataAccess.DTOs.trAntCiberDronDTO;
import trDataAccess.Helpers.trDataHelperSQLiteDAO;
import trInfrastructure.AppException;

public class trAntCiberDronDAO extends trDataHelperSQLiteDAO<trAntCiberDronDTO>{
    public trAntCiberDronDAO() throws AppException {
        super(trAntCiberDronDTO.class, "trAntCiberDron", "trIdAntCiberDron");
    }


}
