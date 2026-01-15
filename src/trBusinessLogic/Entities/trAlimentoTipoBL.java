package trBusinessLogic.Entities;

import java.util.List;

import trDataAccess.DAOs.trAlimentoTipoDAO;
import trDataAccess.DTOs.trAlimentoTipoDTO;

public class trAlimentoTipoBL {

    private trAlimentoTipoDTO alimentoTipo;
    private trAlimentoTipoDAO alimentoTipoDAO = new trAlimentoTipoDAO();

    public trAlimentoTipoBL() {}

    public List<trAlimentoTipoDTO> getAllAlimentoTipo() throws Exception {
        
        List<trAlimentoTipoDTO> lst = alimentoTipoDAO.readAll();
        for (trAlimentoTipoDTO aTipoDTO : lst) {
            aTipoDTO.setTrNombre(aTipoDTO.getTrNombre().toUpperCase());
        }
        return lst;
    }

    public trAlimentoTipoDTO getAlimentoTipoById(Integer id) throws Exception {
        alimentoTipo = alimentoTipoDAO.readBy(id);
        return alimentoTipo;
    }

    public boolean create(trAlimentoTipoDTO trAlimentoTipoDTO) throws Exception {
        return alimentoTipoDAO.create(trAlimentoTipoDTO);       
    }

    public boolean update(trAlimentoTipoDTO trAlimentoTipoDTO) throws Exception {
        return alimentoTipoDAO.update(trAlimentoTipoDTO);
       
    }

    public boolean delete(trAlimentoTipoDTO trAlimentoTipoDTO) throws Exception {
        return alimentoTipoDAO.delete(trAlimentoTipoDTO.getTrIdCatalogo());
       
    }

    public Integer getMaxRow() throws Exception {
        return alimentoTipoDAO.getRowCout();
    }

}
