import java.util.ArrayList;
import java.util.Collections;

public class Greedy {

    public Greedy() {
    }
    /**
     * -¿Cuales son los candidatos?
     * CANDIDATOS = los paquetes ordenados por peso de forma descendente.
     *
     * -¿Estrategia de seleccion?
     * Elejimos dentro del conjunto de paquetes el de mayor peso, seleccionamos al primer candidato de la lista ordenada.
     * Luego determinamos si es un posible candidato verificando si cumple con que su peso sea menor igual a la capacidad disponible del camion,
     * de serlo se agrega a la solucion, se lo marca agregado para no consideralo para otro camion y se modifica la capacidad disponible de dicho camion.
     * Si el paquete no se agrego a ningun camion se suma al peso no asignado y por ultimo se elimina el paquete de los candidatos.
     *
     * -Cosideraciones respecto a encontrar o no solucion
     * Para saber si obtuve una solucion se evalua que todos los candidatos hayan sido considerados.
     * Como puede suceder que no hayan camiones o paquetes no habra solucion por lo cual se devuelve null.
     * Esto sera controlado en el main donde si la solcion es null monstrara "No hay solucion"
     *
     * -Complejidad temporal= por el ordenamiento tendremos O(n log n) y como por cada paquete recorro los camiones O(n * m) donde n es la cantidad de paquetes y m la cantidad de camiones.
     * Entonces tendremos una complejidad total O(n log n + n*m)
     */

    public SolucionGreedy getSolucion(ArrayList<Camion> camiones, ArrayList<Paquete> paquetesCandidatos) {
        boolean agregado;
        int i;
        if (paquetesCandidatos.isEmpty() || camiones.isEmpty()) {
            return null;
        }
        ArrayList<Paquete> candidatos = new ArrayList<>(paquetesCandidatos);
        Collections.sort(candidatos, new ComparatorPesoDesc());
        SolucionGreedy solucion = new SolucionGreedy(camiones);
        while (!candidatos.isEmpty()) {
            Paquete mejorCandidato = candidatos.get(0);
            i = 0;
            solucion.setCandidatosConsiderados();
            agregado = false;
            while (i < camiones.size() && !agregado) {
                Camion c = camiones.get(i);
                // Si es refrigerado agrego el paquete sin importa si tiene alimentos
                // Si no es refrigerado lo agrego solo si no tiene alimentos
                if (c.isRefrigerado() || !mejorCandidato.tieneAlimentos()) {
                    if (factible(mejorCandidato.getPeso(), c.getCapacidadDisponible())) {
                        solucion.agregarPaquete(c, mejorCandidato); // si el candidato cumple el requerimiento lo agrego a mi solucion
                        agregado = true;
                        c.setCapacidadDisponible(c.getCapacidadDisponible() - mejorCandidato.getPeso());
                    }
                }
                i++;
            }
            if (!agregado) {
                solucion.sumarPesoNoAsignado(mejorCandidato);
            }
            candidatos.remove(mejorCandidato);
        }
        return solucion;
    }

    //un candidato cumple si su peso es menor igual a la capacidad disponible del camion
    public boolean factible(int pesoPaquete, int capacidadDisponible) {
        return pesoPaquete <= capacidadDisponible;
    }


}
