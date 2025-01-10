import java.io.*;
import java.util.Scanner;

public class Lanzador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Preguntar al usuario si quiere guardar los resultados en un fichero por cada hilo
        System.out.println("¿Quieres guardar los resultados en un archivo? (si/no): ");
        String respuesta = scanner.next();

        // Convertir la respuesta en una variable booleana
        boolean guardarEnFichero = respuesta.equalsIgnoreCase("si");

        // Pedir los 4 números al usuario
        System.out.println("Introduce 4 números:");
        System.out.println("NUMERO 1:");
        int num1 = scanner.nextInt();
        System.out.println("NUMERO 2:");
        int num2 = scanner.nextInt();
        System.out.println("NUMERO 3:");
        int num3 = scanner.nextInt();
        System.out.println("NUMERO 4:");
        int num4 = scanner.nextInt();

        int[] numeros = {num1,num2,num3,num4};

        // Crear los objetos HiloPar para cada número
        for (int i = 0; i < numeros.length; i++) {
            new HiloPar(numeros[i],guardarEnFichero);  // Crear y lanzar el hilo para cada número

            }

        }

    }

