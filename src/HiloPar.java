import java.io.*;
import java.nio.Buffer;

public class HiloPar implements Runnable{
    private Thread hilo;
    private static int numHilo=0;
    private int numero;

    private boolean guardarEnFichero;
    public HiloPar(int nume, boolean guardarEnFichero){
        this.numero = nume;
        numHilo++;
        hilo = new Thread(this,"Hilo"+numHilo);
        this.guardarEnFichero = guardarEnFichero;
        hilo.start();
    }


    // Método para comprobar si un número es primo
    public boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;  // Los números menores o iguales a 1 no son primos
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {  // Solo verificamos hasta la raíz cuadrada del número
            if (numero % i == 0) {
                return false;  // Si es divisible por cualquier número distinto de 1 o sí mismo, no es primo
            }
        }
        return true;  // Si no se encontró ningún divisor, es primo
    }

    @Override
    public void run() {
        // Registrar tiempo de inicio.
        long startTime = System.currentTimeMillis();

        // Comprobamos que el número sea primo o no.
        String tipo;
        if(esPrimo(numero)){
            tipo = "PRIMO";
        }else{
            tipo = "NO PRIMO";
        }
        // Registrar el tiempo de fin
        long endTime = System.currentTimeMillis();
        // Calcular el tiempo de procesamiento
        long tiempoTotal = endTime - startTime;

        // Mostrar los resultados
        System.out.println("Número: " + numero + ", "+hilo.getName() +
                ", Tiempo: " + tiempoTotal + " ms, " + tipo);


        File nombreFichero = new File("C:\\Users\\AlejandroMartínezJim\\Desktop\\DAM\\ActividadUF1-4\\src\\resultado.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero, true))) {  // true -> append
            writer.write("Número: " + numero + ", "+hilo.getName() +
                    ", Tiempo: " + tiempoTotal + " ms, " + tipo);
            writer.newLine();  // Nueva línea después de cada resultado
        } catch (IOException e) {
            e.printStackTrace();  // Manejo de excepciones en caso de error de escritura
        }


    }
}
