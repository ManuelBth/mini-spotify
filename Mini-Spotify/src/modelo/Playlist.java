package modelo;

public class Playlist {

    private String nombre;
    private Cancion[] canciones;

    // atributos auxiliares del arreglo
    private int contadorCanciones;
    private int maxCanciones; // Representa la longitud del arreglo de canciones

    public Playlist(String nombre, int maxCanciones) {
        this.nombre = nombre;
        this.maxCanciones = maxCanciones;
        this.canciones = new Cancion[this.maxCanciones];
        this.contadorCanciones = 0;
    }

    public void agregarCancion(Cancion nuevCancion) {
        if (contadorCanciones < maxCanciones) {
            canciones[contadorCanciones] = nuevCancion;
            contadorCanciones++;
        } else {
            System.out.println("No se pueden agregar más canciones. La playlist está llena");
        }
    }

    public void listarCanciones() {
        for (int i = 0; i < contadorCanciones; i++) {
            System.out.println((i + 1) + ". " + canciones[i].getTitulo() + " - " + canciones[i].getArtista());
        }
    }

    public void reproducirCancion(int indice) {
        if (indice >= 0 && indice < contadorCanciones) {
            canciones[indice].reproducir();
        } else {
            System.out.println("Indice no válido");
        }
    }

    public void detenerCancion(int indice) {
        if (indice >= 0 && indice < contadorCanciones) {
            canciones[indice].detener();
        } else {
            System.out.println("Indice no válido");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean estaLlena() {
        return contadorCanciones >= maxCanciones;
    }

}
