import trApp.trConsoleApp.trSistemaRuso;

public class App {
    public static void main(String[] args)  {

        try{
            trSistemaRuso sistema = new trSistemaRuso();
            sistema.iniciar();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        

    }
}