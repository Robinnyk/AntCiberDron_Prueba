package trDataAccess.DTOs;

public class trFaVWHormigaDTO {

    private String trFaIdHormiga;
    private String trFaTipo;
    private String trFaSexo;
    private String trFaEstadoHormiga;
    private String trFaNombre;
    private String trFaDescripcion;
    private String trFaEstado;
    private String trFaFechaCreacion;
    private String trFaFechaModifica;

    public String getTrFaIdHormiga() {
        return trFaIdHormiga;
    }

    public void setTrFaIdHormiga(String trFaIdHormiga) {
        this.trFaIdHormiga = trFaIdHormiga;
    }

    public String getTrFaTipo() {
        return trFaTipo;
    }

    public void setTrFaTipo(String trFaTipo) {
        this.trFaTipo = trFaTipo;
    }

    public String getTrFaSexo() {
        return trFaSexo;
    }

    public void setTrFaSexo(String trFaSexo) {
        this.trFaSexo = trFaSexo;
    }

    public String getTrFaEstadoHormiga() {
        return trFaEstadoHormiga;
    }

    public void setTrFaEstadoHormiga(String trFaEstadoHormiga) {
        this.trFaEstadoHormiga = trFaEstadoHormiga;
    }

    public String getTrFaNombre() {
        return trFaNombre;
    }

    public void setTrFaNombre(String trFaNombre) {
        this.trFaNombre = trFaNombre;
    }

    public String getTrFaDescripcion() {
        return trFaDescripcion;
    }

    public void setTrFaDescripcion(String trFaDescripcion) {
        this.trFaDescripcion = trFaDescripcion;
    }

    public String getTrFaEstado() {
        return trFaEstado;
    }

    public void setTrFaEstado(String trFaEstado) {
        this.trFaEstado = trFaEstado;
    }

    public String getTrFaFechaCreacion() {
        return trFaFechaCreacion;
    }

    public void setTrFaFechaCreacion(String trFaFechaCreacion) {
        this.trFaFechaCreacion = trFaFechaCreacion;
    }

    public String getTrFaFechaModifica() {
        return trFaFechaModifica;
    }

    public void setTrFaFechaModifica(String trFaFechaModifica) {
        this.trFaFechaModifica = trFaFechaModifica;
    }

    public trFaVWHormigaDTO(String trFaIdHormiga, String trFaTipo, String trFaSexo, String trFaEstadoHormiga,
            String trFaNombre, String trFaDescripcion, String trFaEstado, String trFaFechaCreacion,
            String trFaFechaModifica) {
        this.trFaIdHormiga = trFaIdHormiga;
        this.trFaTipo = trFaTipo;
        this.trFaSexo = trFaSexo;
        this.trFaEstadoHormiga = trFaEstadoHormiga;
        this.trFaNombre = trFaNombre;
        this.trFaDescripcion = trFaDescripcion;
        this.trFaEstado = trFaEstado;
        this.trFaFechaCreacion = trFaFechaCreacion;
        this.trFaFechaModifica = trFaFechaModifica;
    }

    
    @Override
    public String toString() {
        return getClass().getName()
                + "\n  trIdHormiga      : " + getTrFaIdHormiga()
                + "\n  trTipo           : " + getTrFaTipo()
                + "\n  trSexo           : " + getTrFaSexo()
                + "\n  trEstadoHormiga  : " + getTrFaEstadoHormiga()
                + "\n  trNombre         : " + getTrFaNombre()
                + "\n  trDescripcion    : " + getTrFaDescripcion()
                + "\n  trEstado         : " + getTrFaEstado()
                + "\n  trFechaCreacion  : " + getTrFaFechaCreacion()
                + "\n  trFechaModifica  : " + getTrFaFechaModifica()
                + "\n-----------------------------------";
    }
}
