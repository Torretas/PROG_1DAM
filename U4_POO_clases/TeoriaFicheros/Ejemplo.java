package TeoriaFicheros;

public class Ejemplo {

    static String nacionalidad = "Española";

    static void mostrarNacionalidad(){
        System.out.println("Nacionalidad: " + nacionalidad);
    }

    public static void main(String[] args) {
        Ejemplo ej1 = new Ejemplo();
        Ejemplo ej2 = new Ejemplo();

        // Aquí la salida muestra el mismo valor
        System.out.println(ej1.nacionalidad);
        System.out.println(ej2.nacionalidad);

        Math.random();

        //Ejemplo.mostrarNacionalidad();

        //Un cambio en un objeto, afecta al resto:
        ej1.nacionalidad = "Francesa";
        System.out.println(ej1.nacionalidad);
        //En el otro objeto también:
        System.out.println(ej2.nacionalidad);

    }
}