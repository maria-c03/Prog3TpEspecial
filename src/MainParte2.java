public class MainParte2 {
    public static void main(String[] args) {
        String pathCamiones = "src/resources/Camiones.csv";
        //caso no hay camiones
        //String pathCamiones = "src/resources/Camiones2.csv";

        String pathPaquetes = "src/resources/Paquetes.csv";
        //caso no hay paquetes
        //String pathPaquetes = "src/resources/Paquetes2.csv";

        Servicios servicio = new Servicios(pathCamiones, pathPaquetes);

        /*Backtracking
        Solución obtenida: cada camión con los paquetes asignados.
        Peso no asignado: <peso total de paquetes sin asignar> kg.
        Métrica para analizar el costo de la solución (cantidad de
        estados generados).*/
        Backtracking bc = new Backtracking();
        System.out.println("Solución Backtracking");
        SolucionBacktracking solBacktraking = bc.getSolucion(servicio.getCamiones(), servicio.getPaquetes());
        if(solBacktraking != null){
            solBacktraking.imprimirSolucion();
        }else {
            System.out.println("No hay solución");
        }

        System.out.println();

        /*Greedy
        Solución obtenida: cada camión con los paquetes asignados.
        Peso no asignado: <peso total de paquetes sin asignar> kg.
        Métrica para analizar el costo de la solución (cantidad de
        candidatos considerados).*/
        Greedy gr = new Greedy();
        System.out.println("Solución Greedy");
        SolucionGreedy solGreedy = gr.getSolucion(servicio.getCamiones(), servicio.getPaquetes());
        if(solGreedy != null){
            solGreedy.imprimirSolucion();
        }else{
            System.out.println("No hay solución");
        }
    }
}
