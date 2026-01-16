package trDataAccess.DTOs;

public class trAlimentoExistenteDTO {
    private Integer trIdAlimentoExistente;
    private Integer trIdAlimentoTipo;
    private Integer trIdEstadoAlimento;

    private String  trDescripcion;
    private String  trEstado;
    private String  trFechaCreacion;
    private String  trFechaModifica;

    private String trGenoma;

    public Integer getTrIdAlimentoExistente() {
        return trIdAlimentoExistente;
    }

    public void setTrIdAlimentoExistente(Integer trIdAlimentoExistente) {
        this.trIdAlimentoExistente = trIdAlimentoExistente;
    }

    public Integer getTrIdAlimentoTipo() {
        return trIdAlimentoTipo;
    }

    public void setTrIdAlimentoTipo(Integer trIdAlimentoTipo) {
        this.trIdAlimentoTipo = trIdAlimentoTipo;
    }

    public Integer getTrIdEstadoAlimento() {
        return trIdEstadoAlimento;
    }

    public void setTrIdEstadoAlimento(Integer trIdEstadoAlimento) {
        this.trIdEstadoAlimento = trIdEstadoAlimento;
    }

    public String getTrDescripcion() {
        return trDescripcion;
    }

    public void setTrDescripcion(String trDescripcion) {
        this.trDescripcion = trDescripcion;
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

    public String getTrGenoma() {
        return trGenoma;
    }

    public void setTrGenoma(String trGenoma) {
        this.trGenoma = trGenoma;
    }

    public trAlimentoExistenteDTO() {}

    public trAlimentoExistenteDTO(Integer idAlimentoTipo, Integer idEstadoAlimento) {
        trIdAlimentoExistente = 0;
        trIdAlimentoTipo      = idAlimentoTipo;
        trIdEstadoAlimento    = idEstadoAlimento;
        trDescripcion         = "Alimento existente";
        trGenoma              = ""; 
    }

    public trAlimentoExistenteDTO(Integer idAlimentoExistente, Integer idAlimentoTipo,
                                Integer idEstadoAlimento, String descripcion,
                                String estado, String fechaCreacion, String fechaModifica) {
        trIdAlimentoExistente = idAlimentoExistente;
        trIdAlimentoTipo      = idAlimentoTipo;
        trIdEstadoAlimento    = idEstadoAlimento;
        trDescripcion         = descripcion;
        trEstado              = estado;
        trFechaCreacion       = fechaCreacion;
        trFechaModifica       = fechaModifica;
        trGenoma              = ""; 
    }

    @Override
    public String toString() {
        return getClass().getName()
        + "\n trIdAlimentoExistente: " + getTrIdAlimentoExistente()
        + "\n trIdAlimentoTipo     : " + getTrIdAlimentoTipo()
        + "\n trIdEstadoAlimento   : " + getTrIdEstadoAlimento()
        + "\n trDescripcion        : " + getTrDescripcion()
        + "\n trEstado             : " + getTrEstado()
        + "\n trGenoma             : " + getTrGenoma()
        + "\n trFechaCreacion      : " + getTrFechaCreacion()
        + "\n trFechaModifica      : " + getTrFechaModifica()
        + "\n --------------------------- ";
    }
}
