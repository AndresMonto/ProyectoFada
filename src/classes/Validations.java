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
    
    
    public static boolean ValidTable(SudokuStructure st, JRootPane rootPane) {        
        boolean c = ValidColumn(st, rootPane);
        boolean r = ValidRow(st, rootPane);
        boolean m = ValidSubMatrix(st, rootPane);
        boolean result = (c && r && m);
        if(!result){
            if(!st.Default)
                st.Input.setForeground(Color.red);
        }
        return result;
    }
    
    private static boolean ValidColumn(SudokuStructure st, JRootPane rootPane) {
        boolean result = true;
        int column = st.Coordinate.y;
        for (int i = 0; i < MatrizSudoku.length; i++) {
            if(i != st.Coordinate.x && !st.Input.getText().equals("")){
                if(st.Input.getText().equals(MatrizSudoku[i][column].Input.getText())){
                    ShowErrorMassage(rootPane,st, new String[]{msjError,msjErrorTitle}, new Point(i+1, column+1), JOptionPane.WARNING_MESSAGE);
                    result = false;
                }
            }
        }
        return result;
    }
    
    private static boolean ValidRow(SudokuStructure st, JRootPane rootPane) {
        boolean result = true;
        int row = st.Coordinate.x;
        for (int j = 0; j < MatrizSudoku[0].length; j++) {
            if(j != st.Coordinate.y && !st.Input.getText().equals("")){
                if(st.Input.getText().equals(MatrizSudoku[row][j].Input.getText())){
                    ShowErrorMassage(rootPane,st, new String[]{msjError,msjErrorTitle}, new Point(row+1, j+1), JOptionPane.WARNING_MESSAGE);
                    result = false;
                }
            }
        }
        return result;
    }
    
    
    private static boolean ValidSubMatrix(SudokuStructure st, JRootPane rootPane) {
        String valor = st.Input.getText();
        
        int minimo_fila = st.Coordinate.x;
        int maximo_fila = st.Coordinate.x;
        int minimo_columna = st.Coordinate.y;
        int maximo_columna = st.Coordinate.y;
        boolean result = true;
                
        int mod = (st.Coordinate.x) % 3;
        
        minimo_fila -= mod;
        maximo_fila += (mod == 0) ? 2 : (mod == 1) ? mod : 0;
        
        mod = (st.Coordinate.y) % 3;
        
        minimo_columna -= mod;
        maximo_columna += (mod == 0) ? 2 : (mod == 1) ? mod : 0;

        for (int i = minimo_fila; i <= maximo_fila; i++) {
            for (int j = minimo_columna; j <= maximo_columna; j++) {
                if (i != st.Coordinate.x && j != st.Coordinate.y && !valor.equals("")) {
                    boolean search = MatrizSudoku[i][j].Input.getText().equals(valor); 
                    if (search){
                        ShowErrorMassage(rootPane,st, new String[]{msjError,msjErrorTitle}, new Point(i+1, j+1), JOptionPane.WARNING_MESSAGE);
                        if(result)
                            result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }
    
    public static void ValidGeneral(JRootPane rootPane) {                                         

        boolean result = true;
        boolean error = false;
        
        for (int i = 0; i < MatrizSudoku.length; i++) {
            for (int j = 0; j < MatrizSudoku[0].length; j++) {
                if(!MatrizSudoku[i][j].Default)
                    MatrizSudoku[i][j].Input.setForeground(new java.awt.Color(0, 163, 0));
                boolean valid = ValidTable(MatrizSudoku[i][j], rootPane);

                if(!valid || (valid && MatrizSudoku[i][j].Input.getText().equals(""))){
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
            ShowGeneralMassage(rootPane,new String[]{msjSuccess, msjSuccessTitle}, JOptionPane.INFORMATION_MESSAGE); 
        }else if(!error){
            ShowGeneralMassage(rootPane,new String[]{msjPartialSuccess, msjSuccessTitle}, JOptionPane.INFORMATION_MESSAGE); 
        }
    }
    
}
