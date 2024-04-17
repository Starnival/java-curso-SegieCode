import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Clase scanner 
        Scanner scanner = new Scanner(System.in);

        // Declaraciones y asignaciones
        String palabra = "josue";
        int intentosMaximos = 3;
        int intentos = 0;
        boolean palabraAdivinada = false;
        
        // Arreglos
        char[] letrasAdivinadas = new char[palabra.length()];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }


        while (!palabraAdivinada && intentos < intentosMaximos) {

            //                                           Convierte una array de Char a String
            System.out.println("Palabras a Adivinar: " + String.valueOf(letrasAdivinadas) + "  (" + palabra.length() + " letras)"); 
            
            System.out.print("Introduce una letra ===> ");

            char letra = Character.toLowerCase(scanner.next().charAt(0)); // Recibimos el caracter en minusculas

            boolean letraCorrecta = false;

            for (int i = 0; i < palabra.length(); i++) {
                
                if (palabra.charAt(i) == letra && letrasAdivinadas[i] != letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Incorrecto! Te quedan: " + (intentosMaximos - intentos) + " Intentos");
            }

            if (String.valueOf(letrasAdivinadas).equals(palabra)) {
                palabraAdivinada = true;
                System.out.println("¡Felicidades! Has adivinado la palabra secreta: (" + palabra + ")");
            }

        }

        if (!palabraAdivinada) {
            System.out.println("No tienes mas intentos. ¡GAME OVER!");
        }

        scanner.close();
    }
}

