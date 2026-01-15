package trDataAccess.DTOs;

public class trAlimentoTipoDTO {

    private Integer trIdAlimentoTipo;

    private String  trNombre        ;
    private String  trDescripcion   ;
    private String  trEstado        ;

    private String  trFechaCreacion ;
    private String  trFechaModifica ;
    
    public Integer getTrIdAlimentoTipo() {
        return trIdAlimentoTipo;
    }
    public void setTrIdAlimentoTipo(Integer trIdAlimentoTipo) {
        this.trIdAlimentoTipo = trIdAlimentoTipo;
    }
    public String getTrNombre() {
        return trNombre;
    }
    public void setTrNombre(String trNombre) {
        this.trNombre = trNombre;
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
    public trAlimentoTipoDTO() {
    }
    
    public trAlimentoTipoDTO(String nombre, String descripcion) {
        trIdAlimentoTipo  = 0;
        trNombre          = nombre;
        trDescripcion     = descripcion;
    }
    public trAlimentoTipoDTO(Integer idAlimentoTipo, String nombre, String descripcion, String estado, String fechaCreacion,
            String fechaModifica) {
        trIdAlimentoTipo  = idAlimentoTipo;
        trNombre          = nombre;
        trDescripcion     = descripcion;
        trEstado          = estado;
        trFechaCreacion   = fechaCreacion;
        trFechaModifica   = fechaModifica;
    }
    
    @Override
    public String toString() {
        return getClass().getName()
        + "\n trIdAlimentoTipo: "+ getTrIdAlimentoTipo  ()
        + "\n trNombre        : "+ getTrNombre          ()
        + "\n trDescripcion   : "+ getTrDescripcion     ()
        + "\n trEstado        : "+ getTrEstado          ()
        + "\n trFechaCreacion : "+ getTrFechaCreacion   ()
        + "\n trFechaModifica : "+ getTrFechaModifica   ()
        + "\n --------------------------- " ;
    }
}
