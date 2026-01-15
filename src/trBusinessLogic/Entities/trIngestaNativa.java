package trBusinessLogic.Entities;

import trBusinessLogic.Interfaces.trIIngestaNativa;

public abstract class trIngestaNativa implements trIIngestaNativa {
    protected String tipo;

    public trIngestaNativa(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}

