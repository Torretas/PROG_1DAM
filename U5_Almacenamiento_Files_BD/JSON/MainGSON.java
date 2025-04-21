package JSON;

import com.google.gson.Gson;

public class
MainGSON {
    public static void main(String[] args) {
        Usuario user =  new Usuario("Miguel", "miguel@g.com");

        Gson gson = new Gson();

        String json = gson.toJson(user);
        System.out.println("JSON generado: "+ json);

        Usuario nuevoUsuario = gson.fromJson(json,  Usuario.class);
        System.out.println("Usuario recuperado: " + nuevoUsuario);
    }
}
