package trDataAccess.Interfaces;

import java.util.List;

import trBusinessLogic.Entities.trAlimentoTipoBL;
import trBusinessLogic.Entities.trHormigaTipoBL;

public interface trIEntomologo {

    public List<trHormigaTipoBL> trEtlAntNest();
    public List<trAlimentoTipoBL> trEtlAntFood();
    public trHormigaTipoBL trAlimentarHormiga(int idHormiga, int idAlimento);
    public trAlimentoTipoBL trPreparar(String tipoAlimento);

}
