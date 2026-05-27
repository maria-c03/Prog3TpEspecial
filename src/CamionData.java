import java.util.ArrayList;
import java.util.List;

public class CamionData {
    private int cantCamiones;
    private List<Camion> camiones;

    public CamionData(int cantCamiones,  ArrayList<Camion> camiones) {
        this.cantCamiones = cantCamiones;
        this.camiones = new ArrayList<Camion>(camiones);
    }

    public List<Camion> getCamiones() {
        return new ArrayList<>(camiones);
    }

    public int getCantCamiones() {
        return cantCamiones;
    }

}
