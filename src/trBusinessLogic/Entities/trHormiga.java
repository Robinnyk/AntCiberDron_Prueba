package trBusinessLogic.Entities;

import trBusinessLogic.trFactoryBL;
import trDataAccess.DAOs.trHormigaDAO;
import trDataAccess.DTOs.trHormigaDTO;
import trDataAccess.DTOs.trAlimentoExistenteDTO;
import trBusinessLogic.Interfaces.trIHormiga;
import trBusinessLogic.Interfaces.trIIngestaNativa;

public class trHormiga implements trIHormiga{

    protected FactoryBL<trHormigaDTO> factory = new FactoryBL<>(trHormigaDAO.class);
    public trHormigaDTO data = new trHormigaDTO();
    protected boolean superCortadora = false;

    public trHormiga() {}

    @Override
    public Boolean trComer(trAlimentoExistenteDTO alimento) {
        if (alimento.getIdEstadoAlimento() == 2) {
            this.data.setIdEstado(2);
            return false;
        }
        if (alimento.getIdAlimentoTipo() == 4) {
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
        comer(alimento);
    }

    protected void cambiarSexo(trAlimentoExistenteDTO alimento) {
        if (!superCortadora) return;
        if (data.getIdSexo() == 1) data.setIdSexo(2);
        else if (data.getIdSexo() == 2) data.setIdSexo(1);
    }

    public void superReproductora() {
        this.superCortadora = true;
    }

    public boolean vivir() {
        return data.getIdEstado() != 2;
    }
}
