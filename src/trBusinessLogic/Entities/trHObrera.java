package trBusinessLogic.Entities;

import trDataAccess.DTOs.trAlimentoExistenteDTO;

public class trHObrera extends trHormiga {

    private boolean superCortadora = false;

    public trHObrera() {
        super();
    }

    public boolean trSuperCortadora() {
        return superCortadora;
    }

    public boolean vivir() {
        return data.getTrIdEstado() == 1; 
    }

    public void transformarse(trAlimentoExistenteDTO alimento) {
        
        if (alimento.getTrIdEstadoAlimento() == 2) { 
            data.setTrIdEstado(2); 
            return;
        }

        if (alimento.getTrIdAlimentoTipo() == 4) {
            superCortadora = true;
        }
    }

    public void cambiarSexo(trAlimentoExistenteDTO alimento) {
     
        if (alimento.getTrIdAlimentoTipo() == 4) {
            data.setTrIdSexo(3); 
        }
    }

    

}
