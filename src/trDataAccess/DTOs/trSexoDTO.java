package trDataAccess.DTOs;

public class trSexoDTO {
    private Integer trIdSexo       ;
    private String  trNombre       ;
    private String  trDescripcion  ;
    private String  trEstado       ;
    private String  trFechaCreacion;
    private String  trFechaModifica;
    
    public trSexoDTO() {
    }
    public trSexoDTO(String nombre, String descripcion) {
        trIdSexo = 0;
        trNombre = nombre;
        trDescripcion = descripcion;
    }
    public trSexoDTO(Integer idSexo, String nombre, String descripcion, String estado, String fechaCreacion,
            String fechaModifica) {
        trIdSexo = idSexo;
        trNombre = nombre;
        trDescripcion = descripcion;
        trEstado = estado;
        trFechaCreacion = fechaCreacion;
        trFechaModifica = fechaModifica;
    }
    public Integer getIdSexo() {
        return trIdSexo;
    }
    public void setIdSexo(Integer idSexo) {
        trIdSexo = idSexo;
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
    public String toString(){
        return getClass().getName()
        + "\n IdSexo        : "+ getIdSexo      ()
        + "\n Nombre        : "+ getNombre      ()
        + "\n Descripcion   : "+ getDescripcion ()
        + "\n Estado        : "+ getEstado      ()
        + "\n FechaCreacion : "+ getFechaCreacion ()
        + "\n FechaModifica : "+ getFechaModifica ();
    }
}
