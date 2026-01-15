package trBusinessLogic.Entities;

import java.util.List;

import trDataAccess.DTOs.trHormigaDTO;
import trInfrastructure.AppException;

public class trHLarva extends trHormiga {

    public trHormigaDTO getLava(int id) throws AppException{
        data = factory.getBy(id);
        return data;
    }
    
    public List<trHormigaDTO> getLarvas() throws AppException {
        return factory.getAll();
    }
    
    public trHormiga comer(String comida) {
        if (comida.equals("planta")) {
            return new trHSoldado();
        }
        return this;
    }

    @Override
    public String toString() {
        return "HLarva {}";
    }

    
}
