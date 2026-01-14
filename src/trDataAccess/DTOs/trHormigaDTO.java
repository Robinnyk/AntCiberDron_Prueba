package trDataAccess.DTOs;

public class trHormigaDTO {

    private Integer trIdHormiga     ; 
    private Integer trIdHormigaTipo ; 
    private Integer trIdSexo        ; 
    private Integer trIdEstado      ; 
    private String  trNombre        ; 
    private String  trDescripcion   ; 
    private String  trEstado        ; 
    private String  trFechaCreacion ; 
    private String  trFechaModifica ;

    public trHormigaDTO() {}
    public trHormigaDTO(Integer idHormiga, Integer idHormigaTipo, Integer idSexo, Integer idEstado, String nombre,
            String descripcion) {
        trIdHormiga = idHormiga;
        trIdHormigaTipo = idHormigaTipo;
        trIdSexo = idSexo;
        trIdEstado = idEstado;
        trNombre = nombre;
        trDescripcion = descripcion;
    }
    public trHormigaDTO(Integer idHormiga, Integer idHormigaTipo, Integer idSexo, Integer idEstado, String nombre,
            String descripcion, String estado, String fechaCreacion, String fechaModifica) {
        trIdHormiga = idHormiga;
        trIdHormigaTipo = idHormigaTipo;
        trIdSexo = idSexo;
        trIdEstado = idEstado;
        trNombre = nombre;
        trDescripcion = descripcion;
        trEstado = estado;
        trFechaCreacion = fechaCreacion;
        trFechaModifica = fechaModifica;
    }
    public Integer getIdHormiga() {
        return trIdHormiga;
    }
    public void setIdHormiga(Integer idHormiga) {
        trIdHormiga = idHormiga;
    }
    public Integer getIdHormigaTipo() {
        return trIdHormigaTipo;
    }
    public void setIdHormigaTipo(Integer idHormigaTipo) {
        trIdHormigaTipo = idHormigaTipo;
    }
    public Integer getIdSexo() {
        return trIdSexo;
    }
    public void setIdSexo(Integer idSexo) {
        trIdSexo = idSexo;
    }
    public Integer getIdEstado() {
        return trIdEstado;
    }
    public void setIdEstado(Integer idEstado) {
        trIdEstado = idEstado;
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
        + "\n IdHormiga     : "+ getIdHormiga       ()
        + "\n IdHormigaTipo : "+ getIdHormigaTipo   ()
        + "\n IdSexo        : "+ getIdSexo          ()
        + "\n IdEstado      : "+ getIdEstado        ()  
        + "\n Nombre        : "+ getNombre          ()
        + "\n Descripcion   : "+ getDescripcion     ()
        + "\n Estado        : "+ getEstado          ()
        + "\n FechaCreacion : "+ getFechaCreacion   ()
        + "\n FechaModifica : "+ getFechaModifica   ();
    }
}
