import java.util.Scanner;
import modelo.BibliotecaMusical;
import modelo.Cancion;
import modelo.CuentaSpotify;
import modelo.Playlist;

public class App {
    // Creamos el objeto para leer la terminal.
    private static Scanner scanner = new Scanner(System.in);

    // Creamos el usuario
    private static CuentaSpotify cuenta = new CuentaSpotify("Juan", "123", 3, 3);

    // Creamos una biblioteca y una playlist
    private static Playlist playlist1 = new Playlist("Mix Melendi", 10);
    private static BibliotecaMusical biblioteca1 = new BibliotecaMusical("Biblioteca Manuel Medrano", 10);

    public static void main(String[] args) throws Exception {

        Cancion cancion1 = new Cancion("Tu jardin", 120, "Melendi");
        Cancion cancion2 = new Cancion("Sin Remitente", 160, "Melendi");
        Cancion cancion3 = new Cancion("Tocado y Hundido", 140, "Melendi");
        Cancion cancion4 = new Cancion("Un violinista", 120, "Melendi");
        playlist1.agregarCancion(cancion1);
        playlist1.agregarCancion(cancion2);
        playlist1.agregarCancion(cancion3);
        playlist1.agregarCancion(cancion4);
        Cancion cancion5 = new Cancion("Afuera del planeta", 120, "Manuel Medrano");
        Cancion cancion6 = new Cancion("La Distancia", 160, "Manuel Medrano");
        Cancion cancion7 = new Cancion("Un beso al desayuno", 140, "Manuel Medrano");
        Cancion cancion8 = new Cancion("Yo solo nado contigo", 120, "Manuel Medrano");
        biblioteca1.agregarCancion(cancion5);
        biblioteca1.agregarCancion(cancion6);
        biblioteca1.agregarCancion(cancion7);
        biblioteca1.agregarCancion(cancion8);

        mostrarMenuPrincipal();
    }

    public static void mostrarMenuPrincipal() {
        int opcion = 0;
        boolean salir = false;

        do {
            // Imprimir el menú
            System.out.println("\n=== MINI-SPOTIFY ===");
            if (!cuenta.isSesionIniciada()) {
                System.out.println("1. Iniciar sesión");
            } else {
                System.out.println("1. Sesion iniciada");
            }
            System.out.println("2. Gestionar Biblioteca Musical");
            System.out.println("3. Gestionar Playlists");
            System.out.println("4. Reproducir Canciones");
            System.out.println("5. Cerrar sesión");
            System.out.println("6. Salir del programa");
            System.out.print("Seleccione una opción: ");

            // Leer la entrada del usuario
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                switch (opcion) {
                    case 1:
                        iniciarSesion();
                        break;
                    case 2:
                        gestionarBiblioteca();
                        break;
                    case 3:
                        gestionarPlaylists();
                        break;
                    case 4:
                        reproducirCanciones();
                        break;
                    case 5:
                        // cerrarSesion();
                        break;
                    case 6:
                        System.out.println("Saliendo del programa. ¡Hasta pronto!");
                        salir = true;
                        break;
                    default:
                        System.out.println("⚠️ Opción no válida. Por favor, ingrese un número del 1 al 6.");
                }
            } else {
                System.out.println("⚠️ Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpiar la entrada inválida
            }

        } while (!salir);
    }

    public static void iniciarSesion() {
        if (!cuenta.isSesionIniciada()) {

            System.out.println("Por favor ingrese su usuario: \n");
            String user_aux = scanner.nextLine();
            System.out.println("Por favor ingrese su contrasena: \n");
            String pass_aux = scanner.nextLine();
            cuenta.iniciarSesion(user_aux, pass_aux);
            cuenta.agregarBiblioteca(biblioteca1);
            cuenta.agregarPlaylist(playlist1);
        } else {
            System.out.println(
                    "\n=============================================\n Cuenta ya iniciada. \n=============================================\n");
        }
    }

    public static void gestionarBiblioteca() {
        if (!cuenta.isSesionIniciada()) {
            System.out.println("Debes iniciar sesión para ingresar a esta opción.");
        } else {
            subMenu1();
        }
    }

    public static void subMenu1() {
        int opcion = 0;
        boolean volver = false;

        do {
            System.out.println("\n=== BIBLIOTECA MUSICAL ===");
            System.out.println("1. Listar canciones");
            System.out.println("2. Agregar canción");
            System.out.println("3. Buscar por nombre");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            // Leer la entrada del usuario
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                switch (opcion) {
                    case 1:
                        listarBib();
                        break;
                    case 2:
                        agregarCancion();
                        break;
                    case 3:
                        buscarCancionPorNombre();
                        break;
                    case 4:
                        System.out.println("🔙 Volviendo al menú principal...");
                        volver = true;
                        break;
                    default:
                        System.out.println("⚠️ Opción no válida. Por favor, ingrese un número del 1 al 4.");
                }
            } else {
                System.out.println("⚠️ Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpiar la entrada inválida
            }

        } while (!volver);
    }

    public static void listarBib() {
        cuenta.listarBiblioteca();
        System.out.println("Ingresa el número de la biblioteca");
        int n = scanner.nextInt();
        cuenta.verBiblioteca(n);
    }

    public static void agregarCancion() {
        System.out.println("Inserta el nombre de la cancion");
        String n_c = scanner.nextLine();
        System.out.println("Inserta la duracion de la canción.");
        int d_c = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserta el artista de la cancion");
        String a_c = scanner.nextLine();
        Cancion c_aux = new Cancion(n_c, d_c, a_c);
        cuenta.listarBiblioteca();
        System.out.println("Ingresa el nombre de la biblioteca a la que quieres agregar la cancion");
        int n = scanner.nextInt();
        scanner.nextLine();
        cuenta.agregarCacionABiblioteca(n, c_aux);
    }

    public static void buscarCancionPorNombre() {
        System.out.println("Ingresa el nombre de la cancion");
        String n_c = scanner.nextLine();
        cuenta.buscarCancionEnBiblioteca(n_c);
    }

    public static void gestionarPlaylists() {
        if (!cuenta.isSesionIniciada()) {
            System.out.println("Debes iniciar sesión para ingresar a esta opción.");
        } else {
            subMenu2();
        }
    }

    public static void subMenu2() {
        int opcion = 0;
        boolean volver = false;

        do {
            System.out.println("\n=== BIBLIOTECA MUSICAL ===");
            System.out.println("1. Crear playlist");
            System.out.println("2. Listar Playlist");
            System.out.println("3. Agregar canción a Playlist");
            System.out.println("4. Ver canciones");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");

            // Leer la entrada del usuario
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                switch (opcion) {
                    case 1:
                        crearPlaylist();
                        break;
                    case 2:
                        cuenta.listarPlaylist();
                        break;
                    case 3:
                        agregarCancionPlaylist();
                        break;
                    case 4:
                        verCancionesPlaylist();
                        break;
                    case 5:
                        System.out.println("Volviendo al menú principal...");
                        volver = true;
                        break;
                    default:
                        System.out.println("⚠️ Opción no válida. Por favor, ingrese un número del 1 al 4.");
                }
            } else {
                System.out.println("⚠️ Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpiar la entrada inválida
            }

        } while (!volver);
    }

    public static void crearPlaylist() {
        System.out.println("Ingrese el nombre de la playlist");
        String n_p = scanner.nextLine();
        System.out.println("Ingrese el numero maximo de canciones");
        int m_c = scanner.nextInt();
        scanner.nextLine();
        Playlist playlist = new Playlist(n_p, m_c);
        cuenta.agregarPlaylist(playlist);
        System.out.println("La Playlist: " + playlist.getNombre() + "ha sido agregada correctamente");
    }

    public static void agregarCancionPlaylist() {
        System.out.println("Inserta el nombre de la cancion");
        String n_c = scanner.nextLine();
        System.out.println("Inserta la duracion de la canción.");
        int d_c = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserta el artista de la cancion");
        String a_c = scanner.nextLine();
        Cancion c_aux = new Cancion(n_c, d_c, a_c);
        cuenta.listarPlaylist();
        System.out.println("Ingresa el numero de la playlist a la que quieres agregar la cancion");
        int n = scanner.nextInt();
        scanner.nextLine();
        cuenta.agregarCancionAPlaylist(n, c_aux);
    }

    public static void verCancionesPlaylist() {
        cuenta.listarPlaylist();
        System.out.println("Selecciones el numero de la playlist a la que desea ver sus canciones");
        int n = scanner.nextInt();
        cuenta.verPlaylist(n);
    }

    public static void reproducirCanciones() {
        if (!cuenta.isSesionIniciada()) {
            System.out.println("Debes iniciar sesión para ingresar a esta opción.");
        } else {
            subMenu3();
        }
    }

    public static void subMenu3() {
        int opcion = 0;
        boolean volver = false;

        do {
            System.out.println("\n=== BIBLIOTECA MUSICAL ===");
            System.out.println("1. Reproducir cancion desde la playlist");
            System.out.println("2. Detener reproduccion");
            System.out.println("3. Volver");
            System.out.print("Seleccione una opción: ");

            // Leer la entrada del usuario
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                switch (opcion) {
                    case 1:
                        reproducirCanciondePlaylist();
                        break;
                    case 2:
                        cuenta.detenerCancion();
                        break;
                    case 3:
                        System.out.println("Volviendo al menú principal...");
                        volver = true;
                        break;
                    default:
                        System.out.println("⚠️ Opción no válida. Por favor, ingrese un número del 1 al 4.");
                }
            } else {
                System.out.println("⚠️ Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpiar la entrada inválida
            }

        } while (!volver);
    }

    public static void reproducirCanciondePlaylist(){

        cuenta.listarPlaylist();
        System.out.println("Seleccione el numero de la playlist que desea escuchar");
        int n = scanner.nextInt();
        scanner.nextLine();
        cuenta.verPlaylist(n);
        System.out.println("Seleccione el indice de la cancion que desea escuchar");
        int m = scanner.nextInt();
        scanner.nextLine();
        cuenta.reproducir(n, m);
    }

}
