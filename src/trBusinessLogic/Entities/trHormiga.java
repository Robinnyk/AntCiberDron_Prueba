package trBusinessLogic.Entities;

import trBusinessLogic.trFactoryBL;
import trDataAccess.DAOs.trHormigaDAO;
import trDataAccess.DTOs.trHormigaDTO;

public abstract class trHormiga {
    protected trFactoryBL<trHormigaDTO> factory = new trFactoryBL<>(trHormigaDAO.class);
    public trHormigaDTO data = new trHormigaDTO();

    // protected HormigaDAO hormigaDAO;
    // protected Hormiga() throws AppException  {
    //     this.hormigaDAO = new HormigaDAO();
    // }

    // public FactoryBL<HormigaDTO> factory = new FactoryBL<>(() -> {
    //     try {
    //         return new HormigaDAO();
    //     } catch (Exception e) {
    //         new RuntimeException();
    //     }
    // });
}
