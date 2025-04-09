package TeoriaFicheros;

public class Perro extends Animal {

    private String raza;

    public Perro(int edad, String nombre, String raza) {
        super(edad, nombre);
        this.raza = raza;
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: Guau");
    }
}
