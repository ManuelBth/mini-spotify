package modelo;

public class Cancion extends Multimedia implements Reproducible{
    // artista: artista propio, los demás son heredados.
    private String artista;

    public Cancion(String titulo, int duracion, String artista) {
        super(titulo, duracion);
        this.artista = artista;
    }

    public Cancion() {
        super();
        this.artista = "Desconocido";
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @Override
    public String getInfo() {
        return "Canción: " + getTitulo() + ", Duracion: " + getDuracion() + ", Artista: " + this.artista;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo la cancion: " + getTitulo() + " del artista : " + this.artista);
    }

    @Override
    public void detener() {
        System.out.println("Deteniendo la canción: " + getTitulo() + " del artista : " + this.artista);
    }

    @Override
    public String toString(){
        return getInfo();
    }
}
