/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import classes.SudokuStructure;
import classes.Utilities;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author Administrador
 */
public class Validations extends Utilities{
    
    
    private final static String msjErrorTitle = "Ojo con eso manit@!";
    private final static String msjError = "Oe compa, el valor %s ubicado en la fila %d y en la columna %d \nse repite en: la fila %d y la columna %d.";
    
    private final static String msjSuccessTitle = "Buena esa manit@!";
    private final static String msjSuccess = "Sudoku completado correctamente ;)";
    
    private final static String msjPartialSuccess = "Sin errores ;)";
    
    
    public static boolean validTable(SudokuStructure st, JRootPane rootPane) {        
        boolean c = validColumn(st, rootPane);
        boolean r = validRow(st, rootPane);
        boolean m = validSubMatrix(st, rootPane);
        boolean result = (c && r && m);
        if(!result){
            if(!st.defaultValue)
                st.input.setForeground(Color.red);
        }
        return result;
    }
    
    private static boolean validColumn(SudokuStructure st, JRootPane rootPane) {
        boolean result = true;
        int column = st.coordinate.y;
        for (int i = 0; i < matrixSudoku.length; i++) {
            if(i != st.coordinate.x && !st.input.getText().equals("")){
                if(st.input.getText().equals(matrixSudoku[i][column].input.getText())){
                    showErrorMassage(rootPane,st, new String[]{msjError,msjErrorTitle}, new Point(i+1, column+1), JOptionPane.WARNING_MESSAGE);
                    result = false;
                }
            }
        }
        return result;
    }
    
    private static boolean validRow(SudokuStructure st, JRootPane rootPane) {
        boolean result = true;
        int row = st.coordinate.x;
        for (int j = 0; j < matrixSudoku[0].length; j++) {
            if(j != st.coordinate.y && !st.input.getText().equals("")){
                if(st.input.getText().equals(matrixSudoku[row][j].input.getText())){
                    showErrorMassage(rootPane,st, new String[]{msjError,msjErrorTitle}, new Point(row+1, j+1), JOptionPane.WARNING_MESSAGE);
                    result = false;
                }
            }
        }
        return result;
    }
    
    
    private static boolean validSubMatrix(SudokuStructure st, JRootPane rootPane) {
        String valor = st.input.getText();
        
        int minimo_fila = st.coordinate.x;
        int maximo_fila = st.coordinate.x;
        int minimo_columna = st.coordinate.y;
        int maximo_columna = st.coordinate.y;
        boolean result = true;
                
        int mod = (st.coordinate.x) % 3;
        
        minimo_fila -= mod;
        maximo_fila += (mod == 0) ? 2 : (mod == 1) ? mod : 0;
        
        mod = (st.coordinate.y) % 3;
        
        minimo_columna -= mod;
        maximo_columna += (mod == 0) ? 2 : (mod == 1) ? mod : 0;

        for (int i = minimo_fila; i <= maximo_fila; i++) {
            for (int j = minimo_columna; j <= maximo_columna; j++) {
                if (i != st.coordinate.x && j != st.coordinate.y && !valor.equals("")) {
                    boolean search = matrixSudoku[i][j].input.getText().equals(valor); 
                    if (search){
                        showErrorMassage(rootPane,st, new String[]{msjError,msjErrorTitle}, new Point(i+1, j+1), JOptionPane.WARNING_MESSAGE);
                        if(result)
                            result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }
    
    public static void validGeneral(JRootPane rootPane) {                                         

        boolean result = true;
        boolean error = false;
        
        for (int i = 0; i < matrixSudoku.length; i++) {
            for (int j = 0; j < matrixSudoku[0].length; j++) {
                if(!matrixSudoku[i][j].defaultValue)
                    matrixSudoku[i][j].input.setForeground(new java.awt.Color(0, 163, 0));
                boolean valid = validTable(matrixSudoku[i][j], rootPane);

                if(!valid || (valid && matrixSudoku[i][j].input.getText().equals(""))){
                    if(result){
                        result = !result;
                    }                    
                }
                
               if(!valid){
                   error = true;
               }
            }
        }
        
        if(result){
            showGeneralMassage(rootPane,new String[]{msjSuccess, msjSuccessTitle}, JOptionPane.INFORMATION_MESSAGE); 
        }else if(!error){
            showGeneralMassage(rootPane,new String[]{msjPartialSuccess, msjSuccessTitle}, JOptionPane.INFORMATION_MESSAGE); 
        }
    }
    
}
