package negocio;

import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;

public interface CatalogoPelicula {

    String NOMBRE_RECURSO = "pelicas.txt";
    void agregarPelicula(String nombrePelicula);
    void listarPeliculas();
    void buscarPelicula( String buscar) ;
    void iniciarCatalogo();
}
