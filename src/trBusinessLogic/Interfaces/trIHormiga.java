package trBusinessLogic.Interfaces;

import trBusinessLogic.Entities.trHormigaTipoBL;

public interface trIHormiga {

    public Boolean trComer(trAlimentoExistenteDTO alimento);
    public trHormigaTipoBL trComer(trIIngestaNativa ingesta);
    
}
