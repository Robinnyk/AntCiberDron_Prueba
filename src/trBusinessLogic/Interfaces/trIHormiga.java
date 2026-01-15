package trBusinessLogic.Interfaces;

import trDataAccess.DTOs.trAlimentoExistenteDTO;

public interface trIHormiga {

    public Boolean trComer(trAlimentoExistenteDTO alimento);
    public String trComer(trIIngestaNativa ingesta);

}