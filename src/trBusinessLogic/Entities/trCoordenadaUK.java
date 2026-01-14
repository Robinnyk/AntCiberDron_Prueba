package trBusinessLogic.Entities;

public class trCoordenadaUK {
    
    private String  trGeoposicion;
    private String  trTipoArsenal;
    private Boolean trAccion;


    public trCoordenadaUK(String geoposicion, String tipoArsenal, Boolean accion) {
        trGeoposicion = geoposicion;
        trTipoArsenal = tipoArsenal;
        trAccion = accion;
    }


    public String getGeoposicion() {
        return trGeoposicion;
    }


    public void setGeoposicion(String geoposicion) {
        trGeoposicion = geoposicion;
    }


    public String getTipoArsenal() {
        return trTipoArsenal;
    }


    public void setTipoArsenal(String tipoArsenal) {
        trTipoArsenal = tipoArsenal;
    }


    public Boolean getAccion() {
        return trAccion;
    }


    public void setAccion(Boolean accion) {
        trAccion = accion;
    }


    @Override
    public String toString(){
        return getClass().getName()
        + "\n Geoposicion    : "+ getGeoposicion    ()
        + "\n TipoArsenal    : "+ getTipoArsenal    ()
        + "\n Accion         : "+ getAccion         ();
    }
}
