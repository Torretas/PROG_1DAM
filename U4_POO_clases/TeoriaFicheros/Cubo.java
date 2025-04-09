package TeoriaFicheros;

public class Cubo {

    // Atributos

    int capacidad;  // volumen max en litros
    int contenido;  // contenido actual en litros

    // Metodos

    // Constructor

    Cubo(int c) {
        this.capacidad = c;
    }

    int getCapacidad() {
        return this.capacidad;
    }
    int getContenido() {
        return this.contenido;
    }

    void setCapacidad(int c) {
        this.capacidad = c;
    }
    void setContenido(int c) {
        this.contenido = c;
    }

    void llena() {
        this.contenido = this.capacidad;
    }
    void vacio() {
        this.contenido = 0;
    }
    void pinta() {
        for(int nivel = this.capacidad; nivel > 0; nivel--) {
            if(this.contenido >= nivel) {
                System.out.println("#~~~~~#");
            } else {
                System.out.println("#     #");
            }
        }
        System.out.println("#######");
    }

    void vuelcaEn(Cubo destino) {
        int libres = destino.getCapacidad() - destino.getContenido();

        if (libres > 0) {
            destino.setContenido(destino.getContenido() + this.contenido);
        }
    }
}
