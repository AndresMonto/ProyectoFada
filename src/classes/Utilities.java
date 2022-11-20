/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Administrador
 */
public class Utilities {
    
    private static boolean Blank = true;
    private static int Change = 0;
    private final static String msjError = "Oe compa, ya existe ese valor en: la fila %d y la columna %d";
    
    public static BufferedReader getBuffered(String link) {

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
    
    public static JSONArray ReadJSON () {
        
        String cadenaJson = "";
    
        try{
            String ruta = "src\\logica\\data.json";
            BufferedReader br = getBuffered(ruta);
            String linea = br.readLine();
            int contador = 0;
            while (linea != null) {
                cadenaJson += linea;
                contador++;
                linea = br.readLine();
            }
        } catch (IOException e) {}
        
        JSONObject objetoJson = new JSONObject(cadenaJson);
        JSONArray datosSoudoku = objetoJson.getJSONArray("data");
        return datosSoudoku;
    }
    
    public static JTextField CreateTextField(JSONArray datosSoudoku, int i, int j) {
        
        JTextField input = new JTextField();
        input.setName("id"+i+""+j);
        input.setLocation(j*40,i*40);
        input.setSize(40, 40);
        input.setHorizontalAlignment(CENTER);
        input.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));

        if(j % 3 == 0){
            if(Change % 3 != 0)
                Blank = !Blank;
            if(j == 0 && i % 3 == 0)
                Blank = !Blank;
            Change++;
        }

        if(!Blank)
            input.setBackground(Color.lightGray);

        String value = String.valueOf(datosSoudoku.getJSONArray(i).getInt(j));
        value = value.trim().equals("0") ? "" : value.trim();
        input.setEditable(value == "");
        input.setFont(new java.awt.Font("Arial Narrow", 1, 16));
        
        if(value.equals(""))
            input.setForeground(new java.awt.Color(0, 163, 0));
        
        input.setText(value);
        return input;
    }
    
    public static void ValidTable(SudokuStructure st, SudokuStructure[][] MatrizSudoku, JRootPane rootPane) {
        boolean c = ValidColumn(st, MatrizSudoku, rootPane);
        boolean r = ValidRow(st, MatrizSudoku, rootPane);
        boolean m = ValidSubMatrix(st, MatrizSudoku, rootPane);
        if(!c || !r || !m){
            if(!st.Default)
                st.Input.setForeground(Color.red);
        }
    }
    
    private static boolean ValidColumn(SudokuStructure st, SudokuStructure[][] MatrizSudoku, JRootPane rootPane) {
        boolean resultado = true;
        int column = st.Coordinate.y;
        for (int i = 0; i < MatrizSudoku.length; i++) {
            if(i != st.Coordinate.x && !st.Input.getText().equals("")){
                if(st.Input.getText().equals(MatrizSudoku[i][column].Input.getText())){
                    JOptionPane.showMessageDialog(rootPane, String.format(msjError, i+1, column+1));
                    resultado = false;
                }
            }
        }
        return resultado;
    }
    
    private static boolean ValidRow(SudokuStructure st, SudokuStructure[][] MatrizSudoku, JRootPane rootPane) {
        boolean resultado = true;
        int row = st.Coordinate.x;
        for (int j = 0; j < MatrizSudoku[0].length; j++) {
            if(j != st.Coordinate.y && !st.Input.getText().equals("")){
                if(st.Input.getText().equals(MatrizSudoku[row][j].Input.getText())){
                    JOptionPane.showMessageDialog(rootPane, String.format(msjError, row+1, j+1));
                    resultado = false;
                }
            }
        }
        return resultado;
    }
    
    
    private static boolean ValidSubMatrix(SudokuStructure st, SudokuStructure[][] MatrizSudoku, JRootPane rootPane) {
        String valor = st.Input.getText();
        
        int minimo_fila = st.Coordinate.x;
        int maximo_fila = st.Coordinate.x;
        int minimo_columna = st.Coordinate.y;
        int maximo_columna = st.Coordinate.y;
        boolean resultado = true;
                
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
                        JOptionPane.showMessageDialog(rootPane, String.format(msjError, i+1, j+1));
                        if(resultado)
                            resultado = false;
                        break;
                    }
                }
            }
        }
        return resultado;
    }
}
