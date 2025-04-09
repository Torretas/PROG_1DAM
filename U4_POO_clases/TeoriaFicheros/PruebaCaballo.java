package TeoriaFicheros;

public class PruebaCaballo {
    public static void main(String[] args) {
        // Tengo que instanciar

        Caballo a = new Caballo("Pepe", "negro", 6, 100);
        Caballo b = new Caballo("Maria", "blanco", 5, 200);

        System.out.println("Hola, me llamo " + a.getNombre());
        a.cabalga();
        a.relincha();

        b.getNombre();

    }
}
