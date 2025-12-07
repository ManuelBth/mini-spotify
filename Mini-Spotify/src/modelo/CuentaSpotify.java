package modelo;

public class CuentaSpotify {
    private String usuario;
    private String password;
    private Playlist[] playlists;
    private BibliotecaMusical[] biblioteca;
    private boolean sesionIniciada;

    private int capacidadBiblioteca;
    private int capacidadPlaylist;
    private int contadorPlaylist;
    private int contadorBiblioteca;
    private int auxIndexPlaylist, auxIndexCancion;

    public CuentaSpotify(String usuario, String password, int capacidadBiblioteca, int capacidadPlaylists) {
        this.usuario = usuario;
        this.password = password;
        this.capacidadBiblioteca = capacidadBiblioteca;
        this.capacidadPlaylist = capacidadPlaylists;
        this.biblioteca = new BibliotecaMusical[capacidadBiblioteca];
        this.playlists = new Playlist[capacidadPlaylists];
    }

    public void iniciarSesion(String usuario, String password) {
        if (this.usuario.equals(usuario) && this.password.equals(password)) {
            System.out.println("Sesion iniciada corretamente.");
            sesionIniciada = true;
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    public void agregarPlaylist(Playlist nuevaPlaylist) {
        if (sesionIniciada && contadorPlaylist < capacidadPlaylist) {
            playlists[contadorPlaylist] = nuevaPlaylist;
            contadorPlaylist++;
            System.out.println("Playlist agregada correctamente.");
        } else {
            System.out.println("No se puede agregar la playlist. Limite alcanzado o sesion no iniciada.");
        }
    }

    public void agregarCancionAPlaylist(int playlist, Cancion c) {
        playlists[playlist - 1].agregarCancion(c);
        System.out.println("La canción: " + c.getTitulo() + "se ha agregado a la playlist correctamente");
    }

    public void listarPlaylist() {
        System.out.println("Playlists del usuario: \n");
        for (int i = 0; i < contadorPlaylist; i++) {
            System.out.println((i + 1) + ". " + playlists[i].getNombre());
        }
        System.out.println("====================================================\n");
    }

    public void verPlaylist(int n) {
        playlists[n - 1].listarCanciones();
    }

    public void agregarBiblioteca(BibliotecaMusical nuevBiblioteca) {
        if (sesionIniciada && contadorBiblioteca < capacidadBiblioteca) {
            biblioteca[contadorBiblioteca] = nuevBiblioteca;
            contadorBiblioteca++;
            System.out.println("Se ha agregado correctamente la biblioteca: " + nuevBiblioteca.getNombre());
        } else {
            System.out.println("No se puede agregar la biblioteca. Límite alcanzado o sesesión no iniciada.");
        }
    }

    public void agregarCacionABiblioteca(int bibliotecas, Cancion c) {
        biblioteca[bibliotecas - 1].agregarCancion(c);
        System.out.println("La canción: " + c.getTitulo() + "se ha agregado a la Biblioteca correctamente");
    }

    public void buscarCancionEnBiblioteca(String nombre) {
        for (int i = 0; i < contadorBiblioteca; i++) {
            if (biblioteca[i].buscarCancionPorTitulo(nombre).getTitulo().equalsIgnoreCase(nombre)) {
                System.out.println(
                        "Se ha encontrado la cancion " + biblioteca[i].buscarCancionPorTitulo(nombre).getTitulo()
                                + "en la biblioteca " + biblioteca[i].getNombre());
                return;
            }
        }
    }

    public void listarBiblioteca() {
        System.out.println("Bibliotecas del usuario: \n");
        for (int i = 0; i < contadorBiblioteca; i++) {
            System.out.println((i + 1) + ". " + biblioteca[i].getNombre());
        }
        System.out.println("====================================================\n");
    }

    public void verBiblioteca(int n) {
        biblioteca[n - 1].listarCatalogo();
    }

    public void reproducir(int indexPlaylist, int indexCancion) {
        this.auxIndexPlaylist = indexPlaylist - 1;
        this.auxIndexCancion = indexCancion - 1;
        playlists[auxIndexPlaylist].reproducirCancion(auxIndexCancion);
    }

    public void detenerCancion() {
        if (auxIndexCancion == 0 && auxIndexPlaylist == 0) {
            System.out.println("No hay ninguna cancion reproduciendose");
        } else {
            playlists[auxIndexPlaylist].detenerCancion(auxIndexCancion);
            auxIndexCancion = 0;
            auxIndexPlaylist = 0;
        }
    }

    public void cerrarSesion() {
        this.sesionIniciada = false;
    }

    public boolean isSesionIniciada() {
        return sesionIniciada;
    }
}
