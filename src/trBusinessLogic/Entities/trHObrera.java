package trBusinessLogic.Entities;

import DataAccess.DTOs.AlimentoExistenteDTO;

public class trHObrera extends trHormiga {

    private boolean superReproductora = false;

    public trHObrera() {
        super();
    }

    public boolean trSuperCortadora() {
        return superCortadora;
    }

    public boolean vivir() {
        return data.getIdEstado() == 1; 
    }

    public void transformarse(trAlimentoExistenteDTO alimento) {
        
        if (alimento.getIdEstadoAlimento() == 2) { 
            data.setIdEstado(2); 
            return;
        }

        if (alimento.getIdAlimentoTipo() == 4) {
            superReproductora = true;
        }
    }

    public void cambiarSexo(trAlimentoExistenteDTO alimento) {
     
        if (alimento.getIdAlimentoTipo() == 4) {
            data.setIdSexo(3); 
        }
    }

}
