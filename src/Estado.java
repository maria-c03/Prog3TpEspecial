import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Estado {
    // Paquetes que tiene asignado cada camión en el estado actual
    private HashMap<Camion, List<Paquete>> asignacionActual;
    // Espacio disponible real de cada camión
    private HashMap<Camion, Integer> capacidadDisponible;
    private int pesoNoAsignado;

    public Estado(List<Camion> camiones) {
        this.asignacionActual = new HashMap<>();
        this.capacidadDisponible = new HashMap<>();
        this.pesoNoAsignado = 0;
        for (Camion c : camiones) {
            this.asignacionActual.put(c, new ArrayList<>()); //agrego los pares clave valor con put
            this.capacidadDisponible.put(c, c.getCapacidadMaxCarga());
        }
    }

    public boolean puedeAgregarse(Camion c, Paquete p) {
        // Si tiene Alimentos solo puede ir en camiones refrigerados
        if (p.tieneAlimentos() && !c.isRefrigerado()) {
            return false;
        }
        //Si tengo espacio para el paquete en el camion se puede agregar
        return capacidadDisponible.get(c) >= p.getPeso();
    }

    public void agregarPaqueteACamion(Camion c, Paquete p) {
        asignacionActual.get(c).add(p);
        capacidadDisponible.put(c, capacidadDisponible.get(c) - p.getPeso());
    }

    public void removerPaqueteDeCamion(Camion c, Paquete p) {
        asignacionActual.get(c).remove(p);
        capacidadDisponible.put(c, capacidadDisponible.get(c) + p.getPeso());
    }

    public void sumarPesoNoAsignado(Paquete p) {
        this.pesoNoAsignado += p.getPeso();
    }

    public void restarPesoNoAsignado(Paquete p) {
        this.pesoNoAsignado -= p.getPeso();
    }

    public int getPesoNoAsignado() {
        return this.pesoNoAsignado;
    }

    public HashMap<Camion, List<Paquete>> getAsignacionActual() {
        HashMap<Camion, List<Paquete>> copia = new HashMap<>();
        for (Camion camion : asignacionActual.keySet()) {
            copia.put(
                    camion,
                    new ArrayList<>(asignacionActual.get(camion))
            );
        }
        return copia;
    }
}