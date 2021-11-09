package presentacion;

import java.util.*;
import negocio.*;

public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {
        int opcion = -1;
        var scanner = new Scanner(System.in);
        String nombrePelicula;
        CatalogoPelicula catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0) {
            System.out.println("ELEGIR OPCION: \n"
                    + "1.- Iniciar Catalogo de peliculas \n"
                    + "2.- Agregar Pelicula \n"
                    + "3.- Listar Peliculas \n"
                    + "4.- Buscar peliculas \n"
                    + "0.- Salir");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogo();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la pelicula = ");
                    nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3: 
                    catalogo.listarPeliculas();
                    break;
                case 4: 
                    System.out.println("Ingrese la pelicula que desea buscar");
                    nombrePelicula = scanner.nextLine();
                    catalogo.buscarPelicula(nombrePelicula);
                    break;
                case 0: 
                    System.out.println("Hasta Pronto");
            }
        }
    }
}
