package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    public static void main(String[] args) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
            System.out.println("Conexión correcta...");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
