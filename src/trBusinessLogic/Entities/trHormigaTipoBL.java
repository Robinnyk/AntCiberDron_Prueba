package trBusinessLogic.Entities;

import java.util.List;

import trDataAccess.DAOs.trHormigaTipoDAO;
import trDataAccess.DTOs.trHormigaTipoDTO;

public class trHormigaTipoBL {

    private trHormigaTipoDTO hTipo;
    private trHormigaTipoDAO hormigaTipoDAO = new trHormigaTipoDAO();

    public trHormigaTipoBL() {}

    public List<trHormigaTipoDTO> getAllHormigaTipo() throws Exception {
        
        List<trHormigaTipoDTO> lst = hormigaTipoDAO.readAll();
        for (trHormigaTipoDTO hTipoDTO : lst) {
            hTipoDTO.setTrNombre(hTipoDTO.getTrNombre().toUpperCase());
        }
        return lst;
    }

    public trHormigaTipoDTO getHormigaTipoById(Integer id) throws Exception {
        hTipo = hormigaTipoDAO.readBy(id);
        return hTipo;
    }

    public boolean create(trHormigaTipoDTO trHormigaTipoDTO) throws Exception {
        return hormigaTipoDAO.create(trHormigaTipoDTO);       
    }

    public boolean update(trHormigaTipoDTO trHormigaTipoDTO) throws Exception {
        return hormigaTipoDAO.update(trHormigaTipoDTO);
       
    }

    public boolean delete(trHormigaTipoDTO trHormigaTipoDTO) throws Exception {
        return hormigaTipoDAO.delete(trHormigaTipoDTO.getTrIdCatalogo());
       
    }

    public Integer getMaxRow() throws Exception {
        return hormigaTipoDAO.getRowCout();
    }
    
}
