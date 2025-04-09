package TeoriaFicheros;



public abstract class Animal {

    private int edad;
    private String nombre;

    /**
     * Constructor parametrizado de clase abstracta Animal
     * @param edad
     * @param nombre
     */
    public Animal(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }
    /**
     *
     * @return edad
     */
    public int getEdad() {
        return edad;
    }
    /**
     *
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    /**
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo concreto que simula al animal durmiendo
     */
    public void dormir() {
        System.out.println(nombre + "está durmiendo.");
    }
    /**
     * Metodo abstracto que es implementado por las subclases
     */
    public abstract void hacerSonido();

}
