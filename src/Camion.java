public class Camion {
    private int id;
    private String patente;
    private boolean refrigerado;
    private int capacidadMaxCarga;
    private int capacidadDisponible;

    public Camion(int id, String patente, boolean refrigerado, int capacidadMaxCarga) {
        this.id = id;
        this.patente = patente;
        this.refrigerado = refrigerado;
        this.capacidadMaxCarga = capacidadMaxCarga;
        this.capacidadDisponible = capacidadMaxCarga;
    }

    public int getId() {
        return id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }

    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    public int getCapacidadMaxCarga() {
        return capacidadMaxCarga;
    }

    public void setCapacidadMaxCarga(int capacidadMaxCarga) {
        this.capacidadMaxCarga = capacidadMaxCarga;
    }
    public void setCapacidadDisponible(int capacidadDisponible) {
        this.capacidadDisponible = capacidadDisponible;
    }
    public int getCapacidadDisponible() {
        return capacidadDisponible;
    }

    @Override
    public String toString() {
        return  id + ";" + patente + ";" + refrigerado + ";" + capacidadMaxCarga;
    }
}
