package principal;
import lectura.read;

public class main {
    public static void main(String[] args) {
        int numberSizeArray = read.readInteger("Ingrese tamaño del arreglo.");
        new proceso(numberSizeArray);
    }
}
