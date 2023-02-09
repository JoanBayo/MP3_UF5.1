import java.util.ArrayList;
import java.util.List;

public class proves {
    public static void main(String[] args) {
        String[] letras = {"a", "b", "c", "d", "e", "f"};
        List<String> palabras = new ArrayList<>();
        generarCombinaciones(letras, "", palabras);
        for(String palabra: palabras){
            System.out.println(palabra);
        }
    }

    public static void generarCombinaciones(String[] letras, String combinacionActual, List<String> palabras) {
        if (combinacionActual.length() > 2) {
            palabras.add(combinacionActual);
        } else {
            for (int i = 0; i < letras.length; i++) {
                generarCombinaciones(letras, combinacionActual + letras[i], palabras);
            }
        }
    }
}