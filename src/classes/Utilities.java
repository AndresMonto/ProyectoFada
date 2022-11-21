/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import Classes.Move;
import Classes.Validations;
import java.awt.Color;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
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
    
    protected static SudokuStructure[][]  MatrizSudoku = new  SudokuStructure[9][9];
    private static ArrayList<Move>  Moves = new ArrayList<>();

    protected static int Play = 0;
    private static int Table = 0;
    
    private final static String msjHistory = "Valor %d ubicado en la fila %d y en la columna %d";
    
    private static BufferedReader getBuffered(String link) {

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
    
    private static JSONArray ReadJSON(boolean resolved) {
        
        String cadenaJson = "";
    
        try{
            String ruta = "src\\Resource\\data.json";
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
        datosSoudoku = datosSoudoku.getJSONArray(Table).getJSONArray(resolved ? 1 : 0 );
        return datosSoudoku;
    }
    
    
    public static void ChargeMatrix(JPanel jPanel2, JTextArea textA, JRootPane rootPane, int table, boolean resolved) {
        Table = table;
        JSONArray datosSoudoku =  ReadJSON(resolved);
        
        for (int i = 0; i < datosSoudoku.length(); i++) {
            for (int j = 0; j < datosSoudoku.getJSONArray(0).length(); j++) {
                JTextField input = CreateTextField(datosSoudoku, i, j);
                jPanel2.add(input); 
                MatrizSudoku[i][j] = new SudokuStructure(input, input.getText(), new Point(i, j), !input.getText().equals(""));
                AddActionToTextField(MatrizSudoku[i][j], textA, rootPane);
            }
        }
    }
    
    private static void AddActionToTextField(SudokuStructure st, JTextArea textA, JRootPane rootPane){
        st.Input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTextKeyReleased(st, textA, rootPane);
            }
        });
    }
    
    private static void JTextKeyReleased(SudokuStructure st, JTextArea textA, JRootPane rootPane) {
       try {
           int value = Integer.parseInt( st.Input.getText());
           if(value >= 0 && value <= 9){
               if(!st.Default)
                   st.Input.setForeground(new java.awt.Color(0, 163, 0));
               Validations.ValidTable(st, rootPane);
               AddPlay(st);
               AddHistory(textA, String.format(msjHistory, value, st.Coordinate.x+1, st.Coordinate.y+1));
           }else{
               st.Input.setText("");
           }
       } catch (Exception e) {
           st.Input.setText("");
       }
        
    }
    
    private static void AddPlay(SudokuStructure st) {
        Moves.add(new Move(st.PrevValue, new Point(st.Coordinate.x, st.Coordinate.y)));
        if(Moves.size() > 1)
            Play++;
        MatrizSudoku[st.Coordinate.x][st.Coordinate.y].PrevValue = st.Input.getText();
        
    }
    
    public static void MoveForward() {
        Play += Play < (Moves.size()-0) ? 1 : 0;
        ResetValues();
    }
    
    public static void MoveBack() {
        Play -= Play > 0 ? 1 : 0;
        ResetValues();
    }
    
    private static JTextField CreateTextField(JSONArray datosSoudoku, int i, int j) {
        
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
    
    
    public static void ResetValues(boolean resolved) {

        JSONArray datosSoudoku =  ReadJSON(resolved);
        
        for (int i = 0; i < datosSoudoku.length(); i++) {
            for (int j = 0; j < datosSoudoku.getJSONArray(0).length(); j++) {
                String value = String.valueOf(datosSoudoku.getJSONArray(i).getInt(j));
                value = value.trim().equals("0") ? "" : value.trim();
                MatrizSudoku[i][j].Input.setText(value);
            }
        }

    }
    public static void ResetValues() {
        if(Moves.size() > 0){
            Move m = Moves.get(Play);
            MatrizSudoku[m.Coordenate.x][m.Coordenate.y].Input.setText(m.Value);
        }
    }
    
    public static void AddHistory(JTextArea textA,String msj) {
        if(!msj.equals(""))
            textA.append(msj + "\n");
        else
            textA.setText(msj);   
    }
   
    
    protected static void ShowErrorMassage(JRootPane rootPane, SudokuStructure st, String[] msj, Point location, int type) {
        JOptionPane.showMessageDialog(rootPane, String.format(msj[0], st.Input.getText(), st.Coordinate.x+1, st.Coordinate.y+1, location.x, location.y), msj[1],type);
    }
    
    protected static void ShowGeneralMassage(JRootPane rootPane, String[] msj, int type) {
        JOptionPane.showMessageDialog(rootPane, msj[0] , msj[1],type);
    }
}
