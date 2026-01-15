package BusinessLogic.Entities;

import java.util.List;
import java.util.ArrayList;

import trBusinessLogic.Interfaces.trIEntomologo;
import trDataAccess.DAOs.trHormigaDAO;
import trDataAccess.DAOs.trAlimentoExistenteDAO;
import trDataAccess.DAOs.trAlimentoTipoDAO;
import trDataAccess.DAOs.trEstadoAlimentoDAO;
import trDataAccess.DTOs.trHormigaDTO;
import trDataAccess.DTOs.trAlimentoExistenteDTO;
import trDataAccess.DTOs.trAlimentoExistenteDTO;
import trDataAccess.DTOs.trEstadoAlimentoDTO;
import trInfrastructure.AppException;

public class trEntomologo implements trIEntomologo {

    private trHormigaDAO hormigaDAO;
    private AlimentoExistenteDAO alimentoDAO;
    private AlimentoTipoDAO alimentoTipoDAO;
    private EstadoAlimentoDAO estadoAlimentoDAO;

    public Entomologo() throws AppException {
        this.hormigaDAO = new HormigaDAO();
        this.alimentoDAO = new AlimentoExistenteDAO();
        this.alimentoTipoDAO = new AlimentoTipoDAO();
        this.estadoAlimentoDAO = new EstadoAlimentoDAO();
    }

    @Override
    public List<Hormiga> etlAntNest() {
        List<Hormiga> hormigas = new ArrayList<>();
        try {
            List<HormigaDTO> dtos = hormigaDAO.readAll();
            for (HormigaDTO dto : dtos) {
                HReina h = new HReina();
                h.data = dto;
                hormigas.add(h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hormigas;
    }

    @Override
    public List<AlimentoExistenteDTO> etlAntFood() {
        try {
            return alimentoDAO.readAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Hormiga alimentarAnt(Hormiga hormiga, AlimentoExistenteDTO alimento) {
        if (hormiga instanceof HReina) {
            HReina reina = (HReina) hormiga;
            reina.transformarse(alimento);
            reina.cambiarSexo(alimento);
        }
        try {
            alimentoDAO.delete(alimento.getIdAlimentoExistente());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hormiga;
    }

    public void guardarAlimento(AlimentoExistenteDTO alimento) {
        try {
            alimentoDAO.create(alimento);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarHormiga(HormigaDTO hormiga) {
        try {
            hormigaDAO.create(hormiga);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<AlimentoTipoDTO> getAlimentoTipos() throws AppException {
        return alimentoTipoDAO.readAll();
    }

    public List<EstadoAlimentoDTO> getEstadoAlimentos() throws AppException {
        return estadoAlimentoDAO.readAll();
    }

    public String getNombreHormigaTipo(int id) {
        switch (id) {
            case 1: return "Larva";
            case 2: return "Soldado";
            case 3: return "Rastreadora";
            case 4: return "Reina";
            case 5: return "Zángano";
            default: return "Desconocido";
        }
    }

    public String getNombreSexo(int id) {
        switch (id) {
            case 1: return "Macho";
            case 2: return "Hembra";
            case 3: return "Híbrido";
            case 4: return "Asexual";
            default: return "Desconocido";
        }
    }

    public String getNombreEstado(int id) {
        switch (id) {
            case 1: return "VIVA";
            case 2: return "MUERTA";
            case 3: return "X";
            default: return "Desconocido";
        }
    }
}
