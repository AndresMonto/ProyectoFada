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
import javax.swing.JButton;
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
    
    private static boolean blank = true;
    private static int change = 0;
    
    protected static SudokuStructure[][]  matrixSudoku = new  SudokuStructure[9][9];
    private static ArrayList<Move> moves = new ArrayList<>();

    protected static int play = 0;
    private static int table = 0;
    
    private final static String msjHistory = "Valor %d ubicado en la fila %d y en la columna %d";
    private final static String msjClueTitle = "Ahí le va un consejo ;)";
    private final static String msjClue = "En la fila %d y en la columna %d podrías ingresar el valor %s";
    private final static String msjEnding = "Puntaje: 1 \nTiempo: 1";
    
    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
          while (true) {
            try {
              Thread.sleep(1000);
              System.out.println("Me imprimo cada segundo");
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
    };
    
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
    
    private static JSONArray readJSON(boolean resolved) {
        String cadenaJson = "";
    
        try{
            String ruta = "src\\main\\java\\Resource\\data.json";
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
        datosSoudoku = datosSoudoku.getJSONArray(table).getJSONArray(resolved ? 1 : 0 );
        return datosSoudoku;
    }
    
    
    public static void chargeMatrix(JPanel jPanel2, JTextArea textA, JRootPane rootPane, int table, boolean resolved) {
        Thread hilo = new Thread(runnable);
        hilo.start();
        table = table;
        JSONArray datosSoudoku =  readJSON(resolved);
        
        for (int i = 0; i < datosSoudoku.length(); i++) {
            for (int j = 0; j < datosSoudoku.getJSONArray(0).length(); j++) {
                JTextField input = createTextField(datosSoudoku, i, j);
                jPanel2.add(input); 
                matrixSudoku[i][j] = new SudokuStructure(input, input.getText(), new Point(i, j), !input.getText().equals(""));
                addActionToTextField(matrixSudoku[i][j], textA, rootPane);
            }
        }
    }
    
    private static void addActionToTextField(SudokuStructure st, JTextArea textA, JRootPane rootPane){
        st.input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextKeyReleased(st, textA, rootPane);
            }
        });
    }
    
    private static void jTextKeyReleased(SudokuStructure st, JTextArea textA, JRootPane rootPane) {
       try {
           int value = Integer.parseInt( st.input.getText());
           if(value >= 1 && value <= 9){
               if(!st.defaultValue)
                   st.input.setForeground(new java.awt.Color(0, 163, 0));
               Validations.validTable(st, rootPane);
               addPlayToMoves(st);
               addHistory(textA, String.format(msjHistory, value, st.coordinate.x+1, st.coordinate.y+1));
           }else{
               st.input.setText("");
           }
       } catch (Exception e) {
           st.input.setText("");
       }
        
    }
    
    private static void addPlayToMoves(SudokuStructure st) {
        moves.add(new Move(st.prevValue, new Point(st.coordinate.x, st.coordinate.y)));
        if(moves.size() > 1)
            play++;
        matrixSudoku[st.coordinate.x][st.coordinate.y].prevValue = st.input.getText();
    }
    
    public static void moveForward() {
        play += play < (moves.size()-0) ? 1 : 0;
        resetValues();
    }
    
    public static void moveBack() {
        resetValues();
        play -= play > 0 ? 1 : 0;
    }
    
    private static JTextField createTextField(JSONArray datosSoudoku, int i, int j) {
        
        JTextField input = new JTextField();
        input.setName("id"+i+""+j);
        input.setLocation(j*40,i*40);
        input.setSize(40, 40);
        input.setHorizontalAlignment(CENTER);
        input.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));

        if(j % 3 == 0){
            if(change % 3 != 0)
                blank = !blank;
            if(j == 0 && i % 3 == 0)
                blank = !blank;
            change++;
        }

        if(!blank)
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
    
    public static void resetValues(boolean resolved) {

        JSONArray datosSoudoku =  readJSON(resolved);
        
        for (int i = 0; i < datosSoudoku.length(); i++) {
            for (int j = 0; j < datosSoudoku.getJSONArray(0).length(); j++) {
                String value = String.valueOf(datosSoudoku.getJSONArray(i).getInt(j));
                value = value.trim().equals("0") ? "" : value.trim();
                matrixSudoku[i][j].input.setText(value);
                matrixSudoku[i][j].defaultValue = !value.equals("");
                
                matrixSudoku[i][j].input.setEditable(value == "");

                if(value.equals(""))
                    matrixSudoku[i][j].input.setForeground(new java.awt.Color(0, 163, 0));
                else
                    matrixSudoku[i][j].input.setForeground(Color.black);
            }
        }

    }
    
    public static void resetValues(JButton jb) {
        table = table == 0 ? 1 : 0;
        jb.setText("🐍 Cambiar de Tablero " + (table == 0 ? "Difícil" : "Fácil"));
        resetValues(false);
    }
    
    public static void resetValues() {
        if(moves.size() > 0){
            Move m = moves.get(play);
            matrixSudoku[m.coordenate.x][m.coordenate.y].input.setText(m.value);
        }
    }
    
    public static void getClue() {
        boolean given = false;
        for (int i = 0; i < matrixSudoku.length && !given; i++) {
            for (int j = 0; j < matrixSudoku[0].length && !given; j++) {
                SudokuStructure obj = matrixSudoku[i][j];
                String value = obj.input.getText();
                if(value.equals("")){
                    JSONArray datosSoudoku = readJSON(true);
                    showGeneralMassage(null, new String[]{String.format(msjClue, obj.coordinate.x+1 , obj.coordinate.y+1, datosSoudoku.getJSONArray(i).getInt(j) ),msjClueTitle}, JOptionPane.INFORMATION_MESSAGE);
                    given = true;
                }
            }
        }
    }
    
    public static void addHistory(JTextArea textA,String msj) {
        if(!msj.equals(""))
            textA.append(msj + "\n");
        else
            textA.setText(msj);   
    }
   
    
    public static void showEndingMassage(JRootPane rootPane) {
        JOptionPane.showMessageDialog(rootPane, msjEnding, "Resultado",JOptionPane.INFORMATION_MESSAGE);
    }
    
    protected static void showErrorMassage(JRootPane rootPane, SudokuStructure st, String[] msj, Point location, int type) {
        JOptionPane.showMessageDialog(rootPane, String.format(msj[0], st.input.getText(), st.coordinate.x+1, st.coordinate.y+1, location.x, location.y), msj[1],type);
    }
    
    protected static void showGeneralMassage(JRootPane rootPane, String[] msj, int type) {
        JOptionPane.showMessageDialog(rootPane, msj[0] , msj[1],type);
    }
}
