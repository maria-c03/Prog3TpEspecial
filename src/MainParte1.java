public class MainParte1 {
    public static void main(String[] args) {
        String pathCamiones = "src/resources/Camiones.csv";
        String pathPaquetes = "src/resources/Paquetes.csv";
        Servicios servicio = new Servicios(pathCamiones,pathPaquetes);

        servicio.imprimirCamiones();
        System.out.println();
        servicio.imprimirPaquetes();

        System.out.println();

        System.out.println("paquete por codigo");
        System.out.println(servicio.servicio1("P001"));
        System.out.println();

        System.out.println("paquetes con alimentos");
        System.out.println(servicio.servicio2(true));
        System.out.println();

        System.out.println("paquetes por urgencia");
        System.out.println(servicio.servicio3(80,100));

        //hacer main para parte 2
    }
}

