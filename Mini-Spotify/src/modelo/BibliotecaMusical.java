package modelo;

public class BibliotecaMusical {
    private Cancion[] canciones;
    private String nombre;
    // atributos auxiliares
    private int contadoCatalogo;
    private int capacidadMaxima;

    public BibliotecaMusical(String nombre, int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.canciones = new Cancion[capacidadMaxima];
        this.contadoCatalogo = 0;
        this.nombre = nombre;
    }

    public void agregarCancion(Cancion e) {
        if (contadoCatalogo < capacidadMaxima) {
            canciones[contadoCatalogo] = e;
            contadoCatalogo++;
        } else {
            System.out.println("No se pueden agregar más canciones, capacidad máxima alcanzada");
        }
    }

    public Cancion buscarCancionPorTitulo(String titulo) {
        for (int i = 0; i < contadoCatalogo; i++) {
            if (canciones[i].getTitulo().equalsIgnoreCase(titulo)) {
                return canciones[i];
            }
        }
        return null;
    }

    public void listarCatalogo() {
        for (int i = 0; i < contadoCatalogo; i++) {
            System.out.println(canciones[i].getInfo());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
