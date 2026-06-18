import java.util.*;

public class Servicios {
    private CargarDatos cargador;
    private int cantCamiones;
    private int cantPaquetes;
    private List<Camion> camiones;
    private List<Paquete> paquetes;
    private HashMap<String, Paquete> paquetesPorCodigo;
    private HashMap<Boolean, List<Paquete>> paquetesPorAlimentos;
    private TreeMap<Integer, List<Paquete>> paquetesPorUrgencia;

    /*La complejidad temporal del constructor es  O(c) + O(p) + O(p) + O(p) + O(p log u) =  O(c + p log u) y en el peor caso O(c + p log p)*/
    public Servicios(String pathCamiones, String pathPaquetes) {
        this.cargador = new CargarDatos();
        // ===Camiones===   complejidad O(c) donde c es la cantidad de camiones
        CamionData c = cargador.cargarCamiones(pathCamiones);
        this.cantCamiones = c.getCantCamiones();
        this.camiones = c.getCamiones();
        // ===Paquetes===   complejidad O(p) donde p es la cantidad de paquetes
        PaqueteData p = cargador.cargarPaquetes(pathPaquetes);
        this.cantPaquetes = p.getCantPaquetes();
        this.paquetes = p.getPaquetes();

        //paquetes por codigo
        this.paquetesPorCodigo = new HashMap<>();
        //paquetes con o sin alimentos
        paquetesPorAlimentos = new HashMap<>();
        paquetesPorAlimentos.put(true, new ArrayList<>());
        paquetesPorAlimentos.put(false, new ArrayList<>());
        //paquetes por urgencia
        this.paquetesPorUrgencia = new TreeMap<>();

        for (Paquete paquete : paquetes) {
            //asigno paquetes por codigo --> complejidad O(p) por el for, donde el put() del hashmap cuesta O(1)
            paquetesPorCodigo.put(paquete.getCodigo(), paquete);

            //asigno paquetes por alimento -->  complejidad O(p) por el for, donde el get() y el add() cuestan O(1) cada uno
            boolean tieneAlimento = paquete.tieneAlimentos();
            List<Paquete> conAlimento = paquetesPorAlimentos.get(tieneAlimento);
            conAlimento.add(paquete);

            //asigno paquetes por urgencia -->  complejidad O(p log p) donde p es la cantidad de paquetes, si cada paquete tiene una urgencia distinta
            // donde O(log u) es por su containsKey donde u es la cantidad de niveles de urgencia distintos(al igual que su put() y get()) y el add() es O(1)
            int urgencia = paquete.getUrgencia();
            if (!paquetesPorUrgencia.containsKey(urgencia)) {
                paquetesPorUrgencia.put(urgencia, new ArrayList<>());
            }
            List<Paquete> urgentes = paquetesPorUrgencia.get(urgencia);
            urgentes.add(paquete);
        }
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

    public ArrayList<Camion> getCamiones() {
        return new ArrayList<>(camiones);
    }
    public ArrayList<Paquete> getPaquetes() {
        return new ArrayList<>(paquetes);
    }

    /*Servicio 1: Dado un código de paquete (String), retornar toda la información
    del paquete asociado. En caso de no existir, retornar null
    complejidad temporal O(1) ya que el get() es O(1) en hashmap.*/
    public Paquete servicio1(String codigoPaquete){
        return paquetesPorCodigo.get(codigoPaquete);
    }

    /*Servicio 2: Dado un booleano que indica si se buscan paquetes que
    contienen alimentos (true) o que no contienen alimentos (false), retornar el
    listado de paquetes correspondiente.
    complejidad O(p) donde p es la cantidad de paquetes.
    get() es O(1), luego por el new debe copiar todos los elementos de la lista
    cuya complejidad es O(p).*/
    public List<Paquete> servicio2(boolean contieneAlimentos) {
        return new ArrayList<>(paquetesPorAlimentos.get(contieneAlimentos));
    }

    /*Servicio 3: Dados dos valores enteros que representan un nivel de urgencia
    mínimo y máximo, retornar todos los paquetes cuyo nivel de urgencia se
    encuentre dentro de ese rango (inclusive)
    complejidad O(log p + p)= O(p) donde p es la cantidad de paquetes.
    La búsqueda de los límites en un TreeMap cuesta O(log u) donde u es la cantidad de niveles de urgencia distintos,
    recorrer la lista y agregarlos cuesta O(p).
    .*/
    public List<Paquete> servicio3(int urgenciaMinima, int urgenciaMaxima) {
        ArrayList<Paquete> urgentes = new ArrayList<>();
        NavigableMap<Integer, List<Paquete>> rango =
                paquetesPorUrgencia.subMap(
                        urgenciaMinima, true,
                        urgenciaMaxima, true);

        for (List<Paquete> lista : rango.values()) {
            urgentes.addAll(lista);
        }
        return urgentes;
    }
}
