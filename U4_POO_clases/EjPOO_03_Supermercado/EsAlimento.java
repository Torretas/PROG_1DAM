package EjPOO_03_Supermercado;

import java.time.LocalDate;

public interface EsAlimento {

    public void setCaducidad(LocalDate fc);
    public LocalDate getCaducidad();
    public int getCalorias();
}

