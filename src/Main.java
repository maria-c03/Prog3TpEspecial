public static void main(String[] args) {
    String pathCamiones = "src/resources/Camiones.csv";
    String pathPaquetes = "src/resources/Paquetes.csv";
    Servicios servicio = new Servicios(pathCamiones,pathPaquetes);

    servicio.imprimirPaquetes();
    servicio.imprimirCamiones();

}
