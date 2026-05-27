public class Paquete {
    private int id;
    private String codigo;
    private int peso;
    private boolean alimentos;
    private int urgencia;

    public Paquete() {}
    public Paquete(int id, String codigo, int peso, boolean alimentos, int urgencia) {
        this.id = id;
        this.codigo = codigo;
        this.peso = peso;
        this.alimentos = alimentos;
        this.urgencia = urgencia;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public boolean isAlimentos() {
        return alimentos;
    }

    public void setAlimentos(boolean alimentos) {
        this.alimentos = alimentos;
    }

    public int getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }

    @Override
    public String toString() {
        return   id + ";" + codigo  + ";" + peso + ";" + alimentos + ";" + urgencia;
    }
}
