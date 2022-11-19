/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Funcion {

    public int[][] MatrizZudo = new int[9][9];
    public int[][] MatrizSolucion = new int[9][9];
   public  ArrayList<Integer> HistorialJugada= new ArrayList<>();

    public BufferedReader getBuffered(String link) {

        FileReader lector = null;
        BufferedReader br = null;
        try {
            File Arch = new File(link);
            if (!Arch.exists()) {
                System.out.println("No existe el archivo");
            } else {
                lector = new FileReader(link);
                br = new BufferedReader(lector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return br;
    }

    public void CargarSudoku() {
        try {
            //ruta de tu archivo
            String ruta = "src\\logica\\matriz.txt";
            BufferedReader br = getBuffered(ruta);
            //leemos la primera linea
            String linea = br.readLine();
            //contador
            int contador = 0;
            while (linea != null) {
                String[] values = linea.split(",");
                //recorremos el arrar de string
                for (int i = 0; i < values.length; i++) {
                    //se obtiene el primer caracter de el arreglo de strings
                    MatrizZudo[contador][i] = Integer.parseInt(values[i]);
                }
                contador++;
                linea = br.readLine();
            }
        } catch (IOException e) {

        }
    }

    // METODO PARA COMPROBAR LOS VALORES.
    public boolean comprobar_valor(String valor1) {

        if (String.valueOf(valor1).equalsIgnoreCase("")) {
            return false;
        } else {
            int valor = Integer.valueOf(valor1);
            if (valor >= 0 && valor < 10) {
                return true;
            } else {
                return false;
            }
        }

    }
    //METODO PARA COMPROBAR FILAS.

    public boolean existe_fila(int numero, int fila) {

        boolean resultado = false;
        // int a = MatrizZudo[0][2];
        for (int i = 0; i < MatrizZudo.length; i++) {
            if (numero == 0) {
            } else {
                if (MatrizZudo[fila][i] == numero) {
                    resultado = true;
                    break;
                }
            }
        }
        return resultado;

    }

    //METODO PARA COMPROBAR COLUMNAS.
    public boolean existe_columna(int numero, int columna) {

        boolean resultado = false;
        //int a = MatrizZudo[7][0];
        for (int i = 0; i < MatrizZudo.length; i++) {
            if (MatrizZudo[i][columna] == numero) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    public boolean existe_caja(int valor, int fila, int columna) {

        //VARIABLES.
        int minimo_fila;
        int maximo_fila;
        int minimo_columna;
        int maximo_columna;
        boolean resultado = false;

        //DETERMINAMOS LAS FILAS DE LA CAJA.
        if (fila >= 0 && fila < 3) {
            minimo_fila = 0;
            maximo_fila = 2;
        } else if (fila >= 3 && fila < 6) {
            minimo_fila = 3;
            maximo_fila = 5;
        } else {
            minimo_fila = 6;
            maximo_fila = 8;
        }

        //DETERMINAMOS LAS COLUMNAS DE LA CAJA.
        if (columna >= 0 && columna < 3) {
            minimo_columna = 0;
            maximo_columna = 2;
        } else if (columna >= 3 && columna < 6) {
            minimo_columna = 3;
            maximo_columna = 5;
        } else {
            minimo_columna = 6;
            maximo_columna = 8;
        }

        //RECORREMOS EL RANGO DE LA CAJA, Y BUSCAMOS EL VALOR.
        for (int f = minimo_fila; f <= maximo_fila; f++) {
            for (int c = minimo_columna; c <= maximo_columna; c++) {
                if (valor == 0) {
                } else {
                    if (MatrizZudo[f][c] == valor) {
                        resultado = true;
                        break;

                    }
                }
            }
        }
        //REGRESAMOS EL VALOR BOOLEANO.
        return resultado;

    }

    //METODO QUE DETECTA SI EL JUEGO FUE TERMINADO.
    public static boolean terminado(int[][] matriz) {

        boolean resultado = true;

        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[0].length; c++) {
                if (matriz[f][c] == 0) {
                    resultado = false;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "terminado");
        return resultado;

    }

    public void SudokuSolucion() {
        try {
            //ruta de tu archivo
            String ruta = "src\\logica\\solucion.txt";
            BufferedReader br = getBuffered(ruta);
            //leemos la primera linea
            String linea = br.readLine();
            //contador
            int contador = 0;
            while (linea != null) {
                String[] values = linea.split(",");
                //recorremos el arrar de string
                for (int i = 0; i < values.length; i++) {
                    //se obtiene el primer caracter de el arreglo de strings
                    MatrizSolucion[contador][i] = Integer.parseInt(values[i]);
                }
                contador++;
                linea = br.readLine();
            }
        } catch (IOException e) {

        }
    }
    
    public void HistorialPartidas (int a){
        HistorialJugada.add(a);
    }
    public  String  mostrarjugadas(){
        String resultado="";
        for (int i = 0; i < HistorialJugada.size(); i++) {
            int a =i+1;
            resultado+="jugada numero :"
                    +a+", puso el numero :" +HistorialJugada.get(i)+"\n";
            
        }
        return resultado;
        
    }

   public boolean CompararResultado(){
       boolean res =true;
       
      if(MatrizZudo.equals(MatrizSolucion)){
          res=true;
      }else{
      res=false;
      }
   
      return res;
   }

}
