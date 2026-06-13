import java.util.ArrayList;

public class Backtracking {
    private SolucionBacktracking solucion;
    private int mejorPesoNoAsignado; //peso que decido no asignar a un camion
    private int estadosGenerados;

    public Backtracking() {
        this.solucion = null;
        this.mejorPesoNoAsignado = Integer.MAX_VALUE;  //inicializo en un valor alto para el peor caso
        this.estadosGenerados = 0;
    }

    /**
     * Planteo Backtracking
     * -¿Como se genera el arbol de exploracion?
     * Arrancamos con un arbol vacio donde en cada nivel del arbol el algoritmo agrega un paquete
     *
     * nivel 0                                                                              [C1=[] C2=[] C3=[] []]
     * nivel 1                    [C1=[P1] C2=[] C3[] []]               [C1=[] C2=[P1] C3=[] []]              [C1=[] C2=[] C3=[P1] []]         [C1=[] C2=[] C3=[]noAsignarPaquete[P1]]
     * nivel 2      [C1=P1,P2] C2=[] C3=[] C1=[P1] C2=[P2] C3=[] C1=[P1] C2=[] C3=[P2]]   ....
     * :
     * nivel n     hasta ocupar la capacidad maxima de los camiones
     *
     * -Complejidad temporal= en el peor caso O((k+1)^n) donde k = cantidad de camiones, 1 es la opcion de no asignar el paquete y es n = cantidad de paquetes(profundidad del arbol).
     *
     * -¿Cuales son los estados finales y solucion?
     * ESTADO FINAL = ocurre cuando considere todos los paquetes, es decir, decidir si se asigna o no el paquete a un camion
     * ES SOLUCION = quiero solo guardar la mejor solucion, que en este caso seria cuando tengo la menor cantidad de peso asignado
     * -¿Posible poda?
     * poda: si el peso de mi paguete es mayor al de la mejor solucion podo
     */

    public SolucionBacktracking getSolucion(ArrayList<Camion> camiones, ArrayList<Paquete> paquetes) {
        Estado estado = new Estado(camiones);
        backtracking(camiones, paquetes, estado, 0);
        if(solucion == null) {
            return new SolucionBacktracking(estadosGenerados);
        }
        solucion.setEstadosGenerados(estadosGenerados);
        return this.solucion;
    }

    private void backtracking(ArrayList<Camion> camiones, ArrayList<Paquete> paquetes, Estado estado, int indexPaquete) {
        estadosGenerados++;
        //estado final
        if (esEstadoFinal(indexPaquete, paquetes.size())) {
            if (esMejorSolucion(estado)) {
                guardarSolucion(estado);
            }
        } else {
            Paquete paqueteActual = paquetes.get(indexPaquete);
            for (Camion camion : camiones) { //por cada camion pregunto si puede asignarse el paquete
                if (estado.puedeAgregarse(camion, paqueteActual)) {
                    estado.agregarPaqueteACamion(camion, paqueteActual);
                    backtracking(camiones, paquetes, estado, indexPaquete + 1);
                    estado.removerPaqueteDeCamion(camion, paqueteActual);
                }
            }
            if(!poda(estado.getPesoNoAsignado())){
                estado.sumarPesoNoAsignado(paqueteActual);
                backtracking(camiones, paquetes, estado, indexPaquete + 1);
                estado.restarPesoNoAsignado(paqueteActual);
            }
        }
    }

    private boolean esEstadoFinal(int indexPaquete, int tamPaquetes) {
        return indexPaquete >= tamPaquetes;
    }
    //busco minimizar el peso de los paquetes que no estan asignados a ningun camion
    private boolean esMejorSolucion(Estado estado) {
        if(estado.getPesoNoAsignado() < mejorPesoNoAsignado){
            mejorPesoNoAsignado = estado.getPesoNoAsignado();
            return true;
        }
        return false;
    }

    private void guardarSolucion(Estado estado) {
        solucion = new SolucionBacktracking(estado);
    }

    private boolean poda(int peso) {
        return peso >= mejorPesoNoAsignado;
    }

}
