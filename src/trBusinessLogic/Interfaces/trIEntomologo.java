package trBusinessLogic.Interfaces;

import java.util.List;

import trBusinessLogic.Entities.trHormiga;
import trDataAccess.DTOs.trAlimentoExistenteDTO;

public interface trIEntomologo {

    public List<trHormiga> etlAntNest();
    public List<trAlimentoExistenteDTO> etlAntFood();
    public trHormiga alimentarAnt(trHormiga hormiga, trAlimentoExistenteDTO alimento);
}