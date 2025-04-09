package TeoriaFicheros;

/**
* Clase que representa a una persona con nombre y edad
* @author Alejandro Torres
*
* */

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private double altura;


    public Persona() {
        this.nombre = "Desconocido";
        this.edad = 0;
        this.altura = 0.0;
    }

    /**
     * Constructor parametrizado de la clase Persona
     * @param nombre Nombre de la persona
     * @param edad Edad de la persona
     * */

    public Persona(String nombre, String apellido, int edad, double altura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.altura = altura;
    }

    /**
    * Obtiene el nombre de la persona
    * @return El nombre de la persona
    *
     */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // Getter para la edad
    public int getEdad() {
        return edad;
    }
    // Setter para la edad
    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.out.println("Edad no válida.");
        }
    }
    // Getter para la altura
    public double getAltura() {
        return altura;
    }

    // Setter para la altura
    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        } else {
            System.out.println("Altura no válida.");
        }
    }

    // Metodo para saludar
    public void saludar() {
        System.out.println("¡Hola! Me llamo " + nombre + ".");
    }

    // Metodo para verificar si es mayor de edad
    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public static void main(String[] args) {

        // Crear una instancia de Persona usando el constructor por defecto
        Persona persona1 = new Persona();
        System.out.println("Persona 1 (Constructor por defecto):");
        persona1.saludar();
        System.out.println("Nombre: " + persona1.getNombre());
        System.out.println("Es mayor de edad: " + persona1.esMayorDeEdad());
        System.out.println();

        // Crear una instancia de Persona usando el constructor parametrizado
        Persona persona2 = new Persona("Juan","Torres", 25, 1.75);
        System.out.println("Persona 2 (Constructor parametrizado):");
        persona2.saludar();
        System.out.println("Nombre: " + persona2.getNombre());
        System.out.println("Edad: " + persona2.esMayorDeEdad());
        System.out.println("IMC: " + persona2.calcularIMC(68));  // suponiendo que el peso es 68 kg
        System.out.println();

        // Modificar los atributos de persona1 usando setters
        persona1.setNombre("Ana");
        persona1.setApellido("Torres");
        persona1.setEdad(17);
        persona1.setAltura(1.65);
        System.out.println("Persona 1 después de modificar los atributos:");
        persona1.saludar();
        System.out.println("Nombre: " + persona1.getNombre());
        System.out.println("Apellido: " + persona1.getApellido());


        System.out.println("Es mayor de edad: " + persona1.esMayorDeEdad());
        System.out.println("IMC: " + persona1.calcularIMC(55));  // suponiendo que el peso es 55 kg
    }

    private String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double calcularIMC(double peso) {
        if (altura > 0) {
            return peso / (altura * altura);
        } else {
            System.out.println("Altura no válida para calcular IMC.");
            return -1;
        }
    }
}


