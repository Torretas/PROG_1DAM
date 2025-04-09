package TeoriaFicheros;

public class PruebaCubo {
    public static void main(String[] args) {
        Cubo cubito = new Cubo(2);
        Cubo cubazo = new Cubo(7);

        System.out.println(cubito);

        System.out.println("Pinto el cubito:");
        cubito.pinta();
        System.out.println();
        System.out.println("Pinto el cubazo:");
        cubazo.pinta();

        System.out.println("Lleno el cubito hasta arriba...");
        cubito.llena();
        System.out.println("Pinto el cubito, ahora está lleno:");
        cubito.pinta();

        System.out.println("Vuelco el cubito en el cubazo...");
        cubito.vuelcaEn(cubazo);
        System.out.println("Pinto el cubazo de nuevo, algo relleno por el contenido del cubito:");
        cubazo.pinta();





    }
}
