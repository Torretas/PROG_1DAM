package TeoriaFicheros;

/**
 * The type Caballo.
 */
public class Caballo {
    private String nombre;
    private String color;
    private int edad;
    private int carrerasGanadas;

    /**
     * Instantiates a new Caballo.
     *
     * @param n  the n
     * @param c  the c
     * @param e  the e
     * @param cg the cg
     */
    Caballo(String n, String c, int e, int cg) {
        this.nombre = n;
        this.color = c;
        this.edad = e;
        this.carrerasGanadas = cg;
    }

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Cabalga.
     */
    public void cabalga() {
        System.out.println("Tocoto tocotoc tocotoc");
    }

    /**
     * Relincha.
     */
    public void relincha() {
        System.out.println("Yieeeeeeeeeeeha");
    }
}
