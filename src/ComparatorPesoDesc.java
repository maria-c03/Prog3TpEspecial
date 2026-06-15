import java.util.Comparator;

public class ComparatorPesoDesc implements Comparator<Paquete> {
    @Override
    public int compare(Paquete p1, Paquete p2) {
        return Integer.compare(p2.getPeso(), p1.getPeso());
    }
}
