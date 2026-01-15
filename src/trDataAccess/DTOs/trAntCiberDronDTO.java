package trDataAccess.DTOs;

public class trAntCiberDronDTO {

    private Integer         trIdAntCiberDron;
    private String          trSerie;        
    private String          trEstado;       
    private String          trFechaCreacion;
    private String          trFechaModifica;

    public Integer getTrIdAntCiberDron() {
        return trIdAntCiberDron;
    }

    public void setTrIdAntCiberDron(Integer trIdAntCiberDron) {
        this.trIdAntCiberDron = trIdAntCiberDron;
    }

    public String getTrSerie() {
        return trSerie;
    }

    public void setTrSerie(String trSerie) {
        this.trSerie = trSerie;
    }

    public String getTrEstado() {
        return trEstado;
    }

    public void setTrEstado(String trEstado) {
        this.trEstado = trEstado;
    }

    public String getTrFechaCreacion() {
        return trFechaCreacion;
    }

    public void setTrFechaCreacion(String trFechaCreacion) {
        this.trFechaCreacion = trFechaCreacion;
    }

    public String getTrFechaModifica() {
        return trFechaModifica;
    }

    public void setTrFechaModifica(String trFechaModifica) {
        this.trFechaModifica = trFechaModifica;
    }

    public trAntCiberDronDTO() {}

    public trAntCiberDronDTO(String serie) {
        trIdAntCiberDron = 0;
        trSerie = serie;
    }

    public trAntCiberDronDTO(Integer idAntCiberDron, String serie, String estado, String fechaCreacion,
            String fechaModifica) {
        trIdAntCiberDron = idAntCiberDron;
        trSerie = serie;
        trEstado = estado;
        trFechaCreacion = fechaCreacion;
        trFechaModifica = fechaModifica;
    }

   

    @Override

    public String toString() {

        return getClass().getName()
        + "\n trIdAntCiberDron        : "+ getTrIdAntCiberDron()
        + "\n trSerie                 : "+ getTrSerie()
        + "\n trEstado                : "+ getTrEstado() 
        + "\n trFechaCreacion         : "+ getTrFechaCreacion()
        + "\n trFechaModifica         : "+ getTrFechaModifica()
        + "\n ----------------------";
    }



}
