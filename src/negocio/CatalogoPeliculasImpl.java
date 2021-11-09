package negocio;

import datos.AccesoDatos;
import datos.AccesoDatosImpl;
import domain.Pelicula;
import excepciones.AccesoDatosEx;
import excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements CatalogoPelicula {

    private final AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();

    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
            System.out.println("ERROR : " + ex.getMessage());
        }

    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            peliculas.forEach(pelicula->{
                System.out.println("pelicula = " + pelicula);
            });
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace();
            System.out.println("ERROR : " + ex.getMessage());
        }

    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado= this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace();
            System.out.println("ERROR : " + ex.getMessage());
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogo() {
        try {
            if(datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
            System.out.println("ERROR : " + ex.getMessage());
        }
    }

}
