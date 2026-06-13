public class MainParte2 {
    public static void main(String[] args) {
        String pathCamiones = "src/resources/Camiones.csv";
        //String pathCamiones = "src/resources/Camiones2.csv";

        String pathPaquetes = "src/resources/Paquetes.csv";
       // String pathPaquetes = "src/resources/Paquetes2.csv";

        Servicios servicio = new Servicios(pathCamiones, pathPaquetes);
        Backtracking bc = new Backtracking();

        /*CONSULTAR....SI EL PAQUETE TIENE PESO 0
         Solucion Backtracking
        Camion: 102 no contien paquetes
        Camión: 100 | Paquete: 1 peso: 0kg
        Camion: 101 no contien paquetes
        Peso total de paquetes sin asignar: 0
        Estados generados: 3

        CASO NO TENGO PAQUETES/CAMIONES

        */
        /*Backtracking
        Solución obtenida: cada camión con los paquetes asignados.
        Peso no asignado: <peso total de paquetes sin asignar> kg.
        Métrica para analizar el costo de la solución (cantidad de
        estados generados).*/
        System.out.println("Solución Backtracking");
        SolucionBacktracking sol = bc.getSolucion(servicio.getCamiones(), servicio.getPaquetes());
        sol.imprimirSolucion();


        /*Greedy
        Solución obtenida: cada camión con los paquetes asignados.
        Peso no asignado: <peso total de paquetes sin asignar> kg.
        Métrica para analizar el costo de la solución (cantidad de
        candidatos considerados).*/
        System.out.println("Solución Greedy");

    }
}
