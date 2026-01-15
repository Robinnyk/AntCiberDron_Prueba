package trBusinessLogic.Entities;

import trBusinessLogic.trFactoryBL;
import trDataAccess.DAOs.trHormigaDAO;
import trDataAccess.DTOs.trHormigaDTO;
import trDataAccess.DTOs.trAlimentoExistenteDTO;
import trBusinessLogic.Interfaces.trIHormiga;
import trBusinessLogic.Interfaces.trIIngestaNativa;

public abstract class trHormiga implements trIHormiga{

    protected trFactoryBL<trHormigaDTO> factory = new trFactoryBL<>(trHormigaDAO.class);
    public trHormigaDTO data = new trHormigaDTO();
    protected boolean superCortadora = false;

    public trHormiga() {}

    @Override
    public Boolean trComer(trAlimentoExistenteDTO alimento) {
        if (alimento.getTrIdEstadoAlimento() == 2) {
            this.data.setTrIdEstado(2);
            return false;
        }
        if (alimento.getTrIdAlimentoTipo() == 4) {
            this.superCortadora = true;
            cambiarSexo(alimento);
        }
        return true;
    }

    @Override
    public String trComer(trIIngestaNativa ingesta) {
        return "La hormiga ha ingerido la ingesta nativa";
    }

    public void transformarse(trAlimentoExistenteDTO alimento) {
        trComer(alimento);
    }

    protected void cambiarSexo(trAlimentoExistenteDTO alimento) {
        if (!superCortadora) return;
        if (data.getTrIdSexo() == 1) data.setTrIdSexo(2);
        else if (data.getTrIdSexo() == 2) data.setTrIdSexo(1);
    }

    public void superReproductora() {
        this.superCortadora = true;
    }

    public boolean vivir() {
        return data.getTrIdEstado() != 2;
    }
}
