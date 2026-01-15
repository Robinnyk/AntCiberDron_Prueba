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

    public Integer getTrIdHormiga() {
        return trIdHormiga;
    }

    public void setTrIdHormiga(Integer trIdHormiga) {
        this.trIdHormiga = trIdHormiga;
    }

    public Integer getTrIdHormigaTipo() {
        return trIdHormigaTipo;
    }

    public void setTrIdHormigaTipo(Integer trIdHormigaTipo) {
        this.trIdHormigaTipo = trIdHormigaTipo;
    }

    public Integer getTrIdSexo() {
        return trIdSexo;
    }

    public void setTrIdSexo(Integer trIdSexo) {
        this.trIdSexo = trIdSexo;
    }

    public Integer getTrIdEstado() {
        return trIdEstado;
    }

    public void setTrIdEstado(Integer trIdEstado) {
        this.trIdEstado = trIdEstado;
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

    public trHormigaDTO(Integer trIdHormiga, Integer trIdHormigaTipo, Integer trIdSexo, Integer trIdEstado,
            String trNombre, String trDescripcion, String trEstado, String trFechaCreacion, String trFechaModifica) {
        this.trIdHormiga = trIdHormiga;
        this.trIdHormigaTipo = trIdHormigaTipo;
        this.trIdSexo = trIdSexo;
        this.trIdEstado = trIdEstado;
        this.trNombre = trNombre;
        this.trDescripcion = trDescripcion;
        this.trEstado = trEstado;
        this.trFechaCreacion = trFechaCreacion;
        this.trFechaModifica = trFechaModifica;
    }

    public trHormigaDTO(Integer trIdHormiga, Integer trIdHormigaTipo, Integer trIdSexo, Integer trIdEstado,
            String trNombre, String trDescripcion) {
        this.trIdHormiga = trIdHormiga;
        this.trIdHormigaTipo = trIdHormigaTipo;
        this.trIdSexo = trIdSexo;
        this.trIdEstado = trIdEstado;
        this.trNombre = trNombre;
        this.trDescripcion = trDescripcion;
    }

    public trHormigaDTO() {}
 
    

    @Override
    public String toString() {
        return getClass().getName()
        + "\n trIdHormiga     : "+ getTrIdHormiga()
        + "\n trIdHormigaTipo : "+ getTrIdHormigaTipo()
        + "\n trIdSexo        : "+ getTrIdSexo()
        + "\n trIdEstado      : "+ getTrIdEstado()  
        + "\n trNombre        : "+ getTrNombre()
        + "\n trDescripcion   : "+ getTrDescripcion()
        + "\n trEstado        : "+ getTrEstado()
        + "\n trFechaCreacion : "+ getTrFechaCreacion()
        + "\n trFechaModifica : "+ getTrFechaModifica();
    }
}
