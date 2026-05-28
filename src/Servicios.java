import java.util.ArrayList;
import java.util.List;

public class Servicios {
    private CargarDatos cargador;
    private int cantCamiones;
    private int cantPaquetes;
    private List<Camion> camiones;
    private List<Paquete> paquetes;

    public Servicios(String pathCamiones, String pathPaquetes) {
        this.cargador = new CargarDatos();
        // ===Camiones===
        CamionData c = cargador.cargarCamiones(pathCamiones);
        this.cantCamiones = c.getCantCamiones();
        this.camiones = c.getCamiones();
        // ===Paquetes===
        PaqueteData p = cargador.cargarPaquetes(pathPaquetes);
        this.cantPaquetes = p.getCantPaquetes();
        this.paquetes = p.getPaquetes();
    }

    public void imprimirCamiones() {
        System.out.println(cantCamiones);
        for (Camion c : this.camiones) {
            System.out.println(c);
        }
    }

    public void imprimirPaquetes() {
        System.out.println(cantPaquetes);
        for (Paquete p : this.paquetes) {
            System.out.println(p);
        }
    }

    /*Servicio 1: Dado un código de paquete (String), retornar toda la información
    del paquete asociado. En caso de no existir, retornar null.*/
    public Paquete servicio1(String codigoPaquete){
        for (Paquete p : paquetes) {
            if (p.getCodigo().equals(codigoPaquete)) {
                return p;
            }
        }
        return null;
    }

    /*Servicio 2: Dado un booleano que indica si se buscan paquetes que
    contienen alimentos (true) o que no contienen alimentos (false), retornar el
    listado de paquetes correspondiente.*/
    public List<Paquete> servicio2(boolean contieneAlimentos) {
        ArrayList<Paquete> alimentos = new ArrayList<>();
        for (Paquete p : paquetes) {
            if (p.tieneAlimentos() == contieneAlimentos) {
                alimentos.add(p);
            }
        }
        return alimentos;
    }

    /*Servicio 3: Dados dos valores enteros que representan un nivel de urgencia
    mínimo y máximo, retornar todos los paquetes cuyo nivel de urgencia se
    encuentre dentro de ese rango (inclusive).*/
    public List<Paquete> servicio3(int urgenciaMinima, int urgenciaMaxima) {
        ArrayList<Paquete> urgentes = new ArrayList<>();
        for (Paquete p : paquetes) {
            if(p.getUrgencia()>=urgenciaMinima && p.getUrgencia()<=urgenciaMaxima) {
                urgentes.add(p);
            }
        }
        return urgentes;
    }

}

