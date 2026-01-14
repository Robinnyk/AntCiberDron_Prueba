package trDataAccess.DTOs;

public class trVWHormigaDTO {
    private String trIdHormiga    ;
    private String trTipo ;
    private String trSexo ;
    private String trEstadoHormiga    ;
    private String trNombre   ;
    private String trDescripcion  ;
    private String trEstado   ;
    private String trFechaCreacion    ;
    private String trFechaModifica    ;

    public trVWHormigaDTO(String idHormiga, String tipo, String sexo, String estadoHormiga, String nombre,
            String descripcion, String estado, String fechaCreacion, String fechaModifica) {
        trIdHormiga = idHormiga;
        trTipo = tipo;
        trSexo = sexo;
        trEstadoHormiga = estadoHormiga;
        trNombre = nombre;
        trDescripcion = descripcion;
        trEstado = estado;
        trFechaCreacion = fechaCreacion;
        trFechaModifica = fechaModifica;
    }
    public String getIdHormiga() {
        return trIdHormiga;
    }
    public void setIdHormiga(String idHormiga) {
        trIdHormiga = idHormiga;
    }
    public String getTipo() {
        return trTipo;
    }
    public void setTipo(String tipo) {
        trTipo = tipo;
    }
    public String getSexo() {
        return trSexo;
    }
    public void setSexo(String sexo) {
        trSexo = sexo;
    }
    public String getEstadoHormiga() {
        return trEstadoHormiga;
    }
    public void setEstadoHormiga(String estadoHormiga) {
        trEstadoHormiga = estadoHormiga;
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
        + "\n  IdHormiga        : "+ getIdHormiga    ()
        + "\n  Tipo            : "+ getTipo          ()
        + "\n  Sexo            : "+ getSexo          ()
        + "\n  EstadoHormiga   : "+ getEstadoHormiga ()
        + "\n  Nombre          : "+ getNombre        ()
        + "\n  Descripcion     : "+ getDescripcion   ()
        + "\n  Estado          : "+ getEstado        ()
        + "\n  FechaCreacion   : "+ getFechaCreacion ()
        + "\n  FechaModifica   : "+ getFechaModifica ()
        + "\n-----------------------------------";
    }
}
