package principal;

import javax.swing.*;

import com.sun.jdi.event.ExceptionEvent;
import lectura.read;

public class proceso {
    Integer arrayNumberQuick[]; //Array para la clase
    Integer numberSizeArray; //Tamaño del array
    static final int zero = 0;

    /*Constructor de la clase proceso*/
    proceso(Integer numberSizeArray) {
        this.numberSizeArray = numberSizeArray; //variable de asignacion global para la clase
        try{
            setSizeArray();
            print();
            getPreQuickSort();
            print();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            JOptionPane.showMessageDialog(null, "Error -> code 25");
        }
    }
    /*Fin del constructor de la clase*/

    /*Asignacion del tamaño (array)*/
    public void setSizeArray() {
        arrayNumberQuick = new Integer[numberSizeArray];
        llenadoArray();
    }
    /*Fin de asignacion del tamaño*/

    /*Llenado del array*/
    private void llenadoArray() {
        try{
            for(int i = 0; i < arrayNumberQuick.length; i ++){
                arrayNumberQuick[i] = read.readInteger("Ingrese numero para la posicion (" + (i + 1) + ")");
            }
        }catch (Exception errorMessage) {
            JOptionPane.showMessageDialog(null, errorMessage.getMessage());
        }
    }
    /*Fin llenado array*/

    /*Referencia para el array*/
    private void getPreQuickSort() {
        preQuickSort_set_quickSortSizeArrayPosition(arrayNumberQuick);
        /**
        * 1. Se ejecuta el getPreQuickSort() para envar el array al metodo preQuickSort_set_quickSortSizeArrayPosition()*
         *2. El metodo preQuickSort_set_quickSortSizeArrayPosition() contiene el array del getPreQuickSort y punteros*
         *3. El metodo POST_set_quickSortProcs() me hace el proceso del ordenamiento y me retorna el array ordenado*
        * */
    }
    /*Fin de referencia*/

    /*Punteros metodo de proceso*/
    private void preQuickSort_set_quickSortSizeArrayPosition(Integer array[]) {
        POST_set_quickSortProcs(array, zero, array.length - 1);
    }
    /*Fin de punteros de metodo de proceso*/

    /*Proceso de ordenamiento*/
    private Integer[] POST_set_quickSortProcs(Integer arrayNumbersQuick[], Integer punteroIzquierdo, Integer punteroDerecho) {
        int i = punteroIzquierdo;
        int j = punteroDerecho;
        int auxiliarReferent, numberReferent;
        if(punteroIzquierdo >= punteroDerecho)
            return arrayNumbersQuick;
        if(punteroIzquierdo != punteroDerecho) {
            numberReferent = punteroIzquierdo;
            while(punteroIzquierdo != punteroDerecho) {
                while(arrayNumbersQuick[punteroDerecho] >= arrayNumbersQuick[numberReferent] && punteroIzquierdo < punteroDerecho) {
                    punteroDerecho --;
                    while(arrayNumbersQuick[punteroIzquierdo] < arrayNumbersQuick[numberReferent] && punteroIzquierdo < punteroDerecho) {
                        punteroIzquierdo ++;
                    }
                }
                if(punteroDerecho != punteroIzquierdo) {
                    auxiliarReferent = arrayNumbersQuick[punteroDerecho];
                    arrayNumbersQuick[punteroDerecho] = arrayNumbersQuick[punteroIzquierdo];
                    arrayNumberQuick[punteroIzquierdo] = auxiliarReferent;
                }
                if(punteroIzquierdo == punteroDerecho) {
                    POST_set_quickSortProcs(arrayNumbersQuick, i, punteroIzquierdo - 1);
                    POST_set_quickSortProcs(arrayNumbersQuick, punteroIzquierdo + 1, j);
                }
            }
        }else {
            return arrayNumbersQuick;
        }
        return  arrayNumbersQuick;
    }
    /*Fin proceso de ordenamiento*/

    /*Metodo de impresion*/
    private void print(/*Integer arrayNumbersQuick*/) {
        System.out.print("\n");
        for(int i = 0; i < arrayNumberQuick.length; i ++) {
            System.out.print(" " + arrayNumberQuick[i] + " ");
        }
        System.out.print("\n");
    }
    /*Fin metodo impresion*/
}
