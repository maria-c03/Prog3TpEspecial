import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CargarDatos {

    // ========CARGA DE CAMIONES========
    public CamionData cargarCamiones(String archivo) {
        ArrayList<Camion> camiones = new ArrayList<>();
        int total=0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;

            // Primera línea: cantidad total
            total = Integer.parseInt(br.readLine());

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                int id = Integer.parseInt(datos[0]);
                String patente = datos[1];
                boolean refrigerado = datos[2].equals("1");
                int capacidad = Integer.parseInt(datos[3]);

                Camion camion = new Camion(id, patente, refrigerado, capacidad);

                camiones.add(camion);
            }

            //System.out.println(total);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new CamionData(total,camiones);
    }

    // ========CARGA DE PAQUETES========
    public PaqueteData cargarPaquetes(String archivo) {
        ArrayList<Paquete> paquetes = new ArrayList<>();
        int total=0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;

            // Primera línea: cantidad total
            total = Integer.parseInt(br.readLine());

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                int id = Integer.parseInt(datos[0]);
                String codigo = datos[1];
                int peso = Integer.parseInt(datos[2]);
                boolean alimentos = datos[3].equals("1");
                int urgencia = Integer.parseInt(datos[4]);

                Paquete paquete = new Paquete(id, codigo, peso, alimentos, urgencia);

                paquetes.add(paquete);
            }

            //System.out.println(total);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new PaqueteData(total,paquetes);
    }
}
