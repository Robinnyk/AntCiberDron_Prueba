package trDataAccess.Interfaces;

import trBusinessLogic.Entities.trHormigaTipoBL;

public interface trIHormiga {

    public Boolean trComer(int idAlimento, int idGenomas);
    public trHormigaTipoBL trComer(String IngestaNativa);
    
}
