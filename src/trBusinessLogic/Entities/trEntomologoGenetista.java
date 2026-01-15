package trBusinessLogic.Entities;

import trBusinessLogic.Entities.trGenoAlimento;
import trBusinessLogic.Interfaces.trIIngestaNativa;

public class trEntomologoGenetista implements trIIngestaNativa {

    @Override
    public boolean trInyectar(trGenoAlimento genoAlimento) {

        if (genoAlimento == null){
            return false;
        }

        String tipo = genoAlimento.tipo(); 
        System.out.println("Se ha inyectado exitosamente un genoma de tipo: " + tipo);

        return true;
    }




}

