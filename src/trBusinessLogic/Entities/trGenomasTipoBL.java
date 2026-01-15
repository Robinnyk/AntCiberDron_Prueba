package trBusinessLogic.Entities;

import java.util.List;

import trDataAccess.DAOs.trGenomasTipoDAO;
import trDataAccess.DTOs.trGenomasTipoDTO;


public class trGenomasTipoBL {

    private trGenomasTipoDTO genomasTipo;
    private trGenomasTipoDAO genomasTipoDAO = new trGenomasTipoDAO();

    public trGenomasTipoBL() {}

    public List<trGenomasTipoDTO> getAllGenomasTipo() throws Exception {
        
        List<trGenomasTipoDTO> lst = genomasTipoDAO.readAll();
        for (trGenomasTipoDTO aTipoDTO : lst) {
            aTipoDTO.setTrNombre(aTipoDTO.getTrNombre().toUpperCase());
        }
        return lst;
    }

    public trGenomasTipoDTO getGenomasTipoById(Integer id) throws Exception {
        genomasTipo = genomasTipoDAO.readBy(id);
        return genomasTipo;
    }

    public boolean create(trGenomasTipoDTO trGenomasTipoDTO) throws Exception {
        return genomasTipoDAO.create(trGenomasTipoDTO);       
    }

    public boolean update(trGenomasTipoDTO trGenomasTipoDTO) throws Exception {
        return genomasTipoDAO.update(trGenomasTipoDTO);
       
    }

    public boolean delete(trGenomasTipoDTO trGenomasTipoDTO) throws Exception {
        return genomasTipoDAO.delete(trGenomasTipoDTO.getTrIdCatalogo());
       
    }

    public Integer getMaxRow() throws Exception {
        return genomasTipoDAO.getRowCout();
    }
}
