import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolucionBacktracking {
    private HashMap<Camion, List<Paquete>> paquetesAsignados;
    private int pesoNoAsignado;
    private int estadosGenerados;

    public SolucionBacktracking(Estado estado) {
        // this.property = new ArrayList<>(listParam); Esto es similar a la linea 12, se copia para no romper encapsulamiento
        this.paquetesAsignados = copiarPaquetesAsignados(estado.getAsignacionActual());
        this.pesoNoAsignado = estado.getPesoNoAsignado();
        this.estadosGenerados = 0;
    }

    public SolucionBacktracking(int estadosGenerados) {
        this.paquetesAsignados = new HashMap<>();
        this.pesoNoAsignado = 0;
        this.estadosGenerados = estadosGenerados;
    }

    public int getPeso() {
        return pesoNoAsignado;
    }

    public int getEstadosGenerados() {
        return estadosGenerados;
    }

    public void setEstadosGenerados(int estadosGenerados) {
        this.estadosGenerados = estadosGenerados;
    }

    public HashMap<Camion, List<Paquete>> copiarPaquetesAsignados(HashMap<Camion, List<Paquete>> paquetesAsignados) {
        HashMap<Camion, List<Paquete>> copia = new HashMap<>();
        for (Camion camion : paquetesAsignados.keySet()) {
            copia.put(camion,new ArrayList<>(paquetesAsignados.get(camion)));
        }
        return copia;
    }
    public void imprimirSolucion(){
        if(paquetesAsignados.isEmpty()){
            System.out.println("No hay camiones para asignar los paquetes");
        }
        for (HashMap.Entry<Camion, List<Paquete>> entrada : paquetesAsignados.entrySet()) {
            Camion camion = entrada.getKey();
            List<Paquete> paquetes = entrada.getValue();
            if(paquetes.isEmpty()){
                System.out.println("Camion: " + camion.getId() + " no contien paquetes" );
            }
            for(Paquete paquete : paquetes){
                System.out.println("Camión: " + camion.getId() + " | Paquete: " + paquete.getId() +" peso: "+ paquete.getPeso() + "kg");
            }
        }
        System.out.println("Peso total de paquetes sin asignar: " + pesoNoAsignado);
        System.out.println("Estados generados: " +  estadosGenerados);
    }
}