package lectura;
import javax.swing.*;
//import java.util.Scanner;

public class read {
    //static Scanner teclado = new Scanner(System.in);
    public static int readInteger(String warning) {
        int n = 0, error = 0;
        do{
            try {
                error = 0;
                n = Integer.parseInt(JOptionPane.showInputDialog(warning));
            }catch(Exception e){
                error = 1;
                print("Error en la lectura, solo deben ser numeros enteros.");
            }finally {
                break;
            }
        }while( error == 1 );
        return n;
    }

    public static String readString(String warning) {
        String n = "";
        int error = 0;
        do{
            try{
                error = 0;
                n = JOptionPane.showInputDialog(null, warning);
            }catch(Exception e){
                error = 1;
                print("Error en la lectura, solo debe ser texto.");
            }finally {
                break;
            }
        }while( error == 1);
        return n;
    }

    public static void print(String warning) {
        JOptionPane.showMessageDialog(null, warning);
    }

    public static void printInt(int warning) {
        JOptionPane.showMessageDialog(null, warning);
    }

}
