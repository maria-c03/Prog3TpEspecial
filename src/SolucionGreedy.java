import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolucionGreedy {
    private HashMap<Camion, List<Paquete>> asignacionActual;

    private int pesoNoAsignado;
    private int totalCandidatos;

    public SolucionGreedy(List<Camion> camiones){
        asignacionActual = new HashMap<>();
        for (Camion c : camiones) {
            this.asignacionActual.put(c, new ArrayList<>()); //agrego los pares clave valor con put
        }
    }

    public void setCandidatosConsiderados() {
        this.totalCandidatos++;
    }

    public void sumarPesoNoAsignado(Paquete p) {
        this.pesoNoAsignado += p.getPeso();
    }

    public void agregarPaquete(Camion c, Paquete p) {
        asignacionActual.get(c).add(p);
    }

    public void imprimirSolucion(){
        if(asignacionActual.isEmpty()){
            System.out.println("No hay camiones para asignar los paquetes");
        }
        for (HashMap.Entry<Camion, List<Paquete>> entrada : asignacionActual.entrySet()) {
            Camion camion = entrada.getKey();
            List<Paquete> paquetes = entrada.getValue();
            System.out.println("Camión: " + camion.getId() + " capacidad máxima: " + camion.getCapacidadMaxCarga());
            if(paquetes.isEmpty()){
                System.out.println("Camion: " + camion.getId() + " no contiene paquetes" );
            }
            for(Paquete paquete : paquetes){
                System.out.println("Paquete: " + paquete.getId() +" peso: "+ paquete.getPeso() + "kg");
            }
        }
        System.out.println("Peso total de paquetes sin asignar: " + pesoNoAsignado+"kg");
        System.out.println("Cantidad de candidatos: " +  totalCandidatos);
    }
}
