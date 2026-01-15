package trBusinessLogic.Entities;

import java.util.List;
import java.util.ArrayList;

import trBusinessLogic.Interfaces.trIEntomologo;
import trDataAccess.DAOs.trHormigaDAO;
import trDataAccess.DAOs.trAlimentoExistenteDAO;
import trDataAccess.DAOs.trAlimentoTipoDAO;
import trDataAccess.DAOs.trEstadoAlimentoDAO;
import trDataAccess.DTOs.trHormigaDTO;
import trDataAccess.DTOs.trAlimentoExistenteDTO;
import trDataAccess.DTOs.trEstadoAlimentoDTO;
import trInfrastructure.AppException;


public class trEntomologo implements trIEntomologo {

    private trHormigaDAO trHormigaDAO;
    private trAlimentoExistenteDAO trAlimentoDAO;
    private trAlimentoTipoDAO trAlimentoTipoDAO;
    private trEstadoAlimentoDAO trEstadoAlimentoDAO;

    public trEntomologo() throws AppException {
        this.trHormigaDAO = new trHormigaDAO();
        this.trAlimentoDAO = new trAlimentoExistenteDAO();
        this.trAlimentoTipoDAO = new trAlimentoTipoDAO();
        this.trEstadoAlimentoDAO = new trEstadoAlimentoDAO();
    }

    @Override
    public List<trHormiga> etlAntNest() {
        List<trHormiga> hormigas = new ArrayList<>();
        try {
            List<trHormigaDTO> dtos = trHormigaDAO.readAll();
            for (trHormigaDTO dto : dtos) {
                trHObrera h = new trHObrera();
                h.data = dto;
                hormigas.add(h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hormigas;
    }

    @Override
    public List<trAlimentoExistenteDTO> etlAntFood() {
        try {
            return trAlimentoDAO.readAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public trHormiga alimentarAnt(trHormiga hormiga, trAlimentoExistenteDTO alimento) {
        if (hormiga instanceof trHObrera) {
            trHObrera obrera = (trHObrera) hormiga;
            obrera.transformarse(alimento);
            obrera.cambiarSexo(alimento);
        }
        try {
            trAlimentoDAO.delete(alimento.getTrIdAlimentoExistente());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hormiga;
    }

    public void guardarAlimento(trAlimentoExistenteDTO alimento) {
        try {
            trAlimentoDAO.create(alimento);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarHormiga(trHormigaDTO hormiga) {
        try {
            trHormigaDAO.create(hormiga);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<trAlimentoExistenteDTO> getTrAlimentoTipos() throws AppException {
        return trAlimentoTipoDAO.readAll();
    }

    public List<trEstadoAlimentoDTO> getTrEstadoAlimentos() throws AppException {
        return trEstadoAlimentoDAO.readAll();
    }

    public String getTrNombreHormigaTipo(int id) {
        switch (id) {
            case 1: return "Larva";
            case 2: return "Soldado";
            case 3: return "Rastreadora";
            case 4: return "Reina";
            case 5: return "Zángano";
            default: return "Desconocido";
        }
    }

    public String getTrNombreSexo(int id) {
        switch (id) {
            case 1: return "Macho";
            case 2: return "Hembra";
            case 3: return "Híbrido";
            case 4: return "Asexual";
            default: return "Desconocido";
        }
    }

    public String getTrNombreEstado(int id) {
        switch (id) {
            case 1: return "VIVA";
            case 2: return "MUERTA";
            case 3: return "X";
            default: return "Desconocido";
        }
    }
}
