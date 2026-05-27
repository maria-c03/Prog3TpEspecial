import java.util.ArrayList;
import java.util.List;

public class PaqueteData {
    private int cantPaquetes;
    private List<Paquete> paquetes;

    public PaqueteData(int cantPaquetes,  ArrayList<Paquete> paquetes) {
        this.cantPaquetes = cantPaquetes;
        this.paquetes = new ArrayList<Paquete>(paquetes);
    }

    public List<Paquete> getPaquetes() {
        return new ArrayList<>(paquetes);
    }

    public int getCantPaquetes() {
        return cantPaquetes;
    }
}
