package trBusinessLogic.Entities;

import trDataAccess.Interfaces.trIHormiga;

public class trHObreraBL extends trHormigaTipoBL implements trIHormiga {
 
    public trHObreraBL() {
    }

    @Override
    public Boolean trComer(int idAlimento, int idGenomas) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'trComer'");
    }

    @Override
    public trHormigaTipoBL trComer(String IngestaNativa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'trComer'");
    }

    @Override
    public String toString() {
        return "HLarva {}";
    }
}
