import java.util.*;
import trBusinessLogic.Entities.*;
import trDataAccess.DTOs.*;
import trInfrastructure.AppException;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String usuario = "patmic";
        String clave = "123";
        int contIntentos = 0;
        int maxIntentos = 3;
        boolean autenticado = false;

        System.out.println("Inciando el programa....");
        System.out.println("");

        System.out.println("-------------------------------------------------");
        System.out.println("                 ANTCIBERDRON2K25                ");
        System.out.println("-------------------------------------------------");


        while (contIntentos < maxIntentos && !autenticado) {
            System.out.print("Usuario: ");
            String usuarioS = sc.nextLine();
            System.out.print("Contraseña: ");
            String claveS = sc.nextLine();

            if (usuarioS.equals(usuario) && claveS.equals(clave)) {
                autenticado = true;
                System.out.println("¡Ingreso de Sesión Exitoso!\n");
                System.out.println("-------------------------------------------------\n");
                System.out.println("Nombre: Robinson Alessandro Tandazo Reyes \n");
                System.out.println("Cedula: 175129211-9\n");
            } else {
                contIntentos++;
                System.out.println("Usuario o contraseña incorrectos.");
                System.out.println("Intento " + contIntentos + " de " + maxIntentos);
                if (contIntentos == maxIntentos) {
                    System.out.println("Número máximo de intentos alcanzado.");
                    System.out.println("Cerrando el programa...");
                    System.exit(0);
                }
            }
        }

        try {
            trEntomologo entomologo = new trEntomologo();
            Random rand = new Random();

            
            List<trHObrera> hormigasSesion = new ArrayList<>();
            List<trAlimentoExistenteDTO> alimentosSesion = new ArrayList<>();

            int hormigaCount = 0;
            int alimentoCount = 0;

            boolean salir = false;
            while (!salir) {
                System.out.println("\n--------------------- MENÚ ------------------------\n");
                System.out.println("1) Cosechar Hormiga");
                System.out.println("2) Cosechar Alimento");
                System.out.println("3) Inyectar Genoma");
                System.out.println("4) Alimentar Hormiga");
                System.out.println("5) Salir");
                System.out.print(" Por favor, elige una opción de las anteriores: ");
                int opc = Integer.parseInt(sc.nextLine());

                switch (opc) {
                    case 1:
                        hormigaCount++;
                        trHObrera h = new trHObrera();
                        h.data.setTrNombre("Hormiga " + hormigaCount);
                        h.data.setTrDescripcion("Hormiga cosechada");
                        h.data.setTrIdHormigaTipo(rand.nextInt(5) + 1);
                        h.data.setTrIdSexo(rand.nextInt(4) + 1);
                        h.data.setTrIdEstado(1); 

                        System.out.print("Cosechando " + h.data.getTrNombre());
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(300);
                            System.out.print(".");
                        }
                        entomologo.guardarHormiga(h.data);
                        hormigasSesion.add(h);

                        System.out.printf("\n%-12s | %-10s | %-8s | %-5s\n",
                                "Hormiga", "Tipo", "Sexo", "Estado");
                        System.out.printf("%-12s | %-10s | %-8s | %-5s\n",
                                h.data.getTrNombre(),
                                entomologo.getTrNombreHormigaTipo(h.data.getTrIdHormigaTipo()),
                                entomologo.getTrNombreSexo(h.data.getTrIdSexo()),
                                entomologo.getTrNombreEstado(h.data.getTrIdEstado()));
                        break;

                    case 2:
                        alimentoCount++;
                        trAlimentoExistenteDTO a = new trAlimentoExistenteDTO();
                        a.setTrDescripcion("Alimento " + alimentoCount);
                        a.setTrIdAlimentoTipo(rand.nextInt(4) + 1);
                        a.setTrIdEstadoAlimento(rand.nextInt(2) + 1);
                        a.setTrGenoma(null);

                        System.out.print("Cosechando " + a.getTrDescripcion());
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(300);
                            System.out.print(".");
                        }
                        entomologo.guardarAlimento(a);
                        alimentosSesion.add(a);

                        String tipoA = (a.getTrIdAlimentoTipo() == 1) ? "Carnívoro"
                                : (a.getTrIdAlimentoTipo() == 2) ? "Herbívoro"
                                : (a.getTrIdAlimentoTipo() == 3) ? "Omnívoro"
                                : "Nectarívoro";

                        String estadoA = (a.getTrIdEstadoAlimento() == 1) ? "SALUDABLE" : "PODRIDO";

                        System.out.printf("\n%-15s | %-10s | %-8s\n", "Alimento", "Tipo", "Estado");
                        System.out.printf("%-15s | %-10s | %-8s\n", a.getTrDescripcion(), tipoA, estadoA);
                        break;

                    case 3:
                        System.out.print("Inyectando genomas a todos los alimentos");
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(300);
                            System.out.print(".");
                        }
                        String[] genomas = {"X", "XX", "XY"};
                        for (trAlimentoExistenteDTO alimento : alimentosSesion) {
                            String genomaAleatorio = genomas[rand.nextInt(genomas.length)];
                            alimento.setTrGenoma(genomaAleatorio);
                            // Actualizamos solo descripción para mostrar
                            alimento.setTrDescripcion(alimento.getTrDescripcion() + " [" + genomaAleatorio + "]");
                            System.out.printf("%-20s -> Genoma: %s\n", alimento.getTrDescripcion(),
                                    alimento.getTrGenoma());
                        }
                        System.out.println("Genomas inyectados exitosamente a todos los alimentos.");
                        break;

                    case 4:
                        if (hormigasSesion.isEmpty() || alimentosSesion.isEmpty()) {
                            System.out.println("No hay hormigas o alimentos disponibles.");
                            break;
                        }
                        System.out.println("Hormigas disponibles:");
                        for (int i = 0; i < hormigasSesion.size(); i++) {
                            trHObrera hormiga = hormigasSesion.get(i);
                            System.out.printf("%d. %s | Sexo: %s | Estado: %s\n", i + 1,
                                    hormiga.data.getTrNombre(),
                                    entomologo.getTrNombreSexo(hormiga.data.getTrIdSexo()),
                                    entomologo.getTrNombreEstado(hormiga.data.getTrIdEstado()));
                        }
                        System.out.print("Selecciona el número de la hormiga: ");
                        int hIndex = Integer.parseInt(sc.nextLine()) - 1;
                        trHObrera hormigaSelec = hormigasSesion.get(hIndex);

                        System.out.println("Alimentos disponibles:");
                        for (int i = 0; i < alimentosSesion.size(); i++) {
                            trAlimentoExistenteDTO alimento = alimentosSesion.get(i);
                            String genomaMuestra = (alimento.getTrGenoma() == null) ? "Sin genoma" : alimento.getTrGenoma();
                            System.out.printf("%d. %s | Tipo: %d | Genoma: %s\n", i + 1,
                                    alimento.getTrDescripcion(),
                                    alimento.getTrIdAlimentoTipo(),
                                    genomaMuestra);
                        }
                        System.out.print("Selecciona el número del alimento: ");
                        int aIndex = Integer.parseInt(sc.nextLine()) - 1;
                        trAlimentoExistenteDTO alimentoSelec = alimentosSesion.get(aIndex);

                        
                        hormigaSelec.transformarse(alimentoSelec);
                        hormigaSelec.cambiarSexo(alimentoSelec);

                        System.out.printf("La hormiga %s ahora tiene sexo: %s\n",
                                hormigaSelec.data.getTrNombre(),
                                entomologo.getTrNombreSexo(hormigaSelec.data.getTrIdSexo()));
                        break;

                    case 5:
                        salir = true;
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }
            }

        } catch (AppException | InterruptedException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
