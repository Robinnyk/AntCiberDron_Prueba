package trApp.trConsoleApp;

public class trKGD {
    private String trCedula;
    private String trNombre;
    
    public trKGD(String trCedula, String trNombre) {
        this.trCedula = trCedula;
        this.trNombre = trNombre;
    }
    public String getCedula() {
        return trCedula;
    }
    public void setCedula(String trCedula) {
        this.trCedula = trCedula;
    }
    public String getNombre() {
        return trNombre;
    }
    public void setNombre(String trNombre) {
        this.trNombre = trNombre;
    }
    
    public void show(){
        System.out.println("[+] Alumno:");
        System.out.println(getCedula() + " | " + getNombre());
    }

    @Override
    public String toString(){
        return getClass().getName()
        + "\n cedula    : "+ getCedula()
        + "\n nombre    : "+ getNombre();
    }
}
