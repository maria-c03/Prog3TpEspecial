public static void main(String[] args) {
    String pathCamiones = "src/resources/Camiones.csv";
    String pathPaquetes = "src/resources/Paquetes.csv";
    Servicios servicio = new Servicios(pathCamiones,pathPaquetes);

    servicio.imprimirPaquetes();
    //servicio.imprimirCamiones();

//    System.out.println(servicio.servicio1("P001"));
//    System.out.println(servicio.servicio2(true));
    System.out.println(servicio.servicio3(80,100));
}
