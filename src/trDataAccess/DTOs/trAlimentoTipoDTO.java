package trDataAccess.DTOs;

public class trAlimentoTipoDTO {
    private Integer trIdAlimentoTipo;
    private String  trNombre        ;
    private String  trDescripcion   ;
    private String  trEstado        ;
    private String  trFechaCreacion ;
    private String  trFechaModifica ;

    public trAlimentoTipoDTO() {}
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
    public Integer getIdAlimentoTipo() {
        return trIdAlimentoTipo;
    }
    public void setIdAlimentoTipo(Integer idAlimentoTipo) {
        trIdAlimentoTipo = idAlimentoTipo;
    }
    public String getNombre() {
        return trNombre;
    }
    public void setNombre(String nombre) {
        trNombre = nombre;
    }
    public String getDescripcion() {
        return trDescripcion;
    }
    public void setDescripcion(String descripcion) {
        trDescripcion = descripcion;
    }
    public String getEstado() {
        return trEstado;
    }
    public void setEstado(String estado) {
        trEstado = estado;
    }
    public String getFechaCreacion() {
        return trFechaCreacion;
    }
    public void setFechaCreacion(String fechaCreacion) {
        trFechaCreacion = fechaCreacion;
    }
    public String getFechaModifica() {
        return trFechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        trFechaModifica = fechaModifica;
    }
    @Override
    public String toString() {
        return getClass().getName()
        + "\n IdAlimentoTipo: "+ getIdAlimentoTipo  ()
        + "\n Nombre        : "+ getNombre          ()
        + "\n Descripcion   : "+ getDescripcion     ()
        + "\n Estado        : "+ getEstado          ()
        + "\n FechaCreacion : "+ getFechaCreacion   ()
        + "\n FechaModifica : "+ getFechaModifica   ()
        + "\n --------------------------- " ;
    }
}
