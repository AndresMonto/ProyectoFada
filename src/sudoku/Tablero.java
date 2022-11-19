/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import static javax.swing.SwingConstants.CENTER;
import logica.Funcion;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author Luis Lopez
 */
public class Tablero extends javax.swing.JFrame {

    /**
     * Creates new form Tablero
     */
    public Tablero() {
        initComponents();
        cargarMAtriz();
        f.SudokuSolucion();
    }
    public Funcion f = new Funcion();
    
    public int[][] MatrizZudo = new int[9][9];
    
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
    
    public JSONArray ReadJSON () {
        
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

    public void cargarMAtriz() {
        
        boolean blank = true;
        int change = 0;
        JSONArray datosSoudoku = ReadJSON();
        
        for (int i = 0; i < datosSoudoku.length(); i++) {
            for (int j = 0; j < datosSoudoku.getJSONArray(0).length(); j++) {
                javax.swing.JTextField input = new javax.swing.JTextField();
                input.setName("id"+i);
                input.setLocation(j*30,i*30);
                input.setSize(30, 30);
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
                if(!value.equals("")){
                    input.setFont(new java.awt.Font("Arial Narrow", 1, 16));
                }else{
                    if(value.equals("5")){
                        input.setForeground(new java.awt.Color(0, 163, 0));
                    }else{
                        input.setForeground(Color.red);
                    }
                }
                
                input.setText(value);
                
                jPanel1.add(input); 
                
                MatrizZudo[i][j] = datosSoudoku.getJSONArray(i).getInt(j);
            }
        }
        
        
        
        f.CargarSudoku();
        txt00.setText(String.valueOf(f.MatrizZudo[0][0]));
        txt00.setEditable(false);
        txt01.setText(String.valueOf(f.MatrizZudo[0][1]));
        txt01.setEditable(false);
        txt04.setText(String.valueOf(f.MatrizZudo[0][4]));
        txt04.setEditable(false);
        txt05.setText(String.valueOf(f.MatrizZudo[0][5]));
        txt05.setEditable(false);
        txt08.setText(String.valueOf(f.MatrizZudo[0][8]));
        txt08.setEditable(false);
        txt10.setText(String.valueOf(f.MatrizZudo[1][0]));
        txt10.setEditable(false);
        txt12.setText(String.valueOf(f.MatrizZudo[1][2]));
        txt12.setEditable(false);
        txt14.setText(String.valueOf(f.MatrizZudo[1][4]));
        txt14.setEditable(false);
        txt16.setText(String.valueOf(f.MatrizZudo[1][6]));
        txt16.setEditable(false);
        txt17.setText(String.valueOf(f.MatrizZudo[1][7]));
        txt17.setEditable(false);
        txt18.setText(String.valueOf(f.MatrizZudo[1][8]));
        txt18.setEditable(false);
        txt21.setText(String.valueOf(f.MatrizZudo[2][1]));
        txt21.setEditable(false);
        txt22.setText(String.valueOf(f.MatrizZudo[2][2]));
        txt22.setEditable(false);
        txt30.setText(String.valueOf(f.MatrizZudo[3][0]));
        txt30.setEditable(false);
        txt31.setText(String.valueOf(f.MatrizZudo[3][1]));
        txt31.setEditable(false);
        txt32.setText(String.valueOf(f.MatrizZudo[3][2]));
        txt32.setEditable(false);
        txt34.setText(String.valueOf(f.MatrizZudo[3][4]));
        txt34.setEditable(false);
        txt35.setText(String.valueOf(f.MatrizZudo[3][5]));
        txt35.setEditable(false);
        txt37.setText(String.valueOf(f.MatrizZudo[3][7]));
        txt37.setEditable(false);
        txt38.setText(String.valueOf(f.MatrizZudo[3][8]));
        txt38.setEditable(false);
        txt50.setText(String.valueOf(f.MatrizZudo[5][0]));
        txt50.setEditable(false);
        txt52.setText(String.valueOf(f.MatrizZudo[5][2]));
        txt52.setEditable(false);
        txt54.setText(String.valueOf(f.MatrizZudo[5][4]));
        txt54.setEditable(false);
        txt55.setText(String.valueOf(f.MatrizZudo[5][5]));
        txt55.setEditable(false);
        txt57.setText(String.valueOf(f.MatrizZudo[5][7]));
        txt57.setEditable(false);
        txt58.setText(String.valueOf(f.MatrizZudo[5][8]));
        txt58.setEditable(false);
        txt65.setText(String.valueOf(f.MatrizZudo[6][5]));
        txt65.setEditable(false);
        txt67.setText(String.valueOf(f.MatrizZudo[6][7]));
        txt67.setEditable(false);
        txt72.setText(String.valueOf(f.MatrizZudo[7][2]));
        txt72.setEditable(false);
        txt74.setText(String.valueOf(f.MatrizZudo[7][4]));
        txt74.setEditable(false);
        txt80.setText(String.valueOf(f.MatrizZudo[8][0]));
        txt80.setEditable(false);
        txt82.setText(String.valueOf(f.MatrizZudo[8][2]));
        txt82.setEditable(false);
        txt84.setText(String.valueOf(f.MatrizZudo[8][4]));
        txt84.setEditable(false);
        txt86.setText(String.valueOf(f.MatrizZudo[8][6]));
        txt86.setEditable(false);
        txt87.setText(String.valueOf(f.MatrizZudo[8][7]));
        txt87.setEditable(false);
        txt88.setText(String.valueOf(f.MatrizZudo[8][8]));
        txt88.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        txt01 = new javax.swing.JTextField();
        txt02 = new javax.swing.JTextField();
        txt03 = new javax.swing.JTextField();
        txt04 = new javax.swing.JTextField();
        txt05 = new javax.swing.JTextField();
        txt06 = new javax.swing.JTextField();
        txt07 = new javax.swing.JTextField();
        txt08 = new javax.swing.JTextField();
        txt00 = new javax.swing.JTextField();
        txt11 = new javax.swing.JTextField();
        txt12 = new javax.swing.JTextField();
        txt13 = new javax.swing.JTextField();
        txt14 = new javax.swing.JTextField();
        txt15 = new javax.swing.JTextField();
        txt16 = new javax.swing.JTextField();
        txt17 = new javax.swing.JTextField();
        txt18 = new javax.swing.JTextField();
        txt10 = new javax.swing.JTextField();
        txt21 = new javax.swing.JTextField();
        txt22 = new javax.swing.JTextField();
        txt23 = new javax.swing.JTextField();
        txt24 = new javax.swing.JTextField();
        txt25 = new javax.swing.JTextField();
        txt26 = new javax.swing.JTextField();
        txt27 = new javax.swing.JTextField();
        txt28 = new javax.swing.JTextField();
        txt20 = new javax.swing.JTextField();
        txt31 = new javax.swing.JTextField();
        txt32 = new javax.swing.JTextField();
        txt33 = new javax.swing.JTextField();
        txt34 = new javax.swing.JTextField();
        txt35 = new javax.swing.JTextField();
        txt36 = new javax.swing.JTextField();
        txt37 = new javax.swing.JTextField();
        txt38 = new javax.swing.JTextField();
        txt30 = new javax.swing.JTextField();
        txt41 = new javax.swing.JTextField();
        txt42 = new javax.swing.JTextField();
        txt43 = new javax.swing.JTextField();
        txt44 = new javax.swing.JTextField();
        txt45 = new javax.swing.JTextField();
        txt46 = new javax.swing.JTextField();
        txt47 = new javax.swing.JTextField();
        txt48 = new javax.swing.JTextField();
        txt40 = new javax.swing.JTextField();
        txt51 = new javax.swing.JTextField();
        txt52 = new javax.swing.JTextField();
        txt53 = new javax.swing.JTextField();
        txt54 = new javax.swing.JTextField();
        txt55 = new javax.swing.JTextField();
        txt56 = new javax.swing.JTextField();
        txt57 = new javax.swing.JTextField();
        txt58 = new javax.swing.JTextField();
        txt50 = new javax.swing.JTextField();
        txt61 = new javax.swing.JTextField();
        txt62 = new javax.swing.JTextField();
        txt63 = new javax.swing.JTextField();
        txt64 = new javax.swing.JTextField();
        txt65 = new javax.swing.JTextField();
        txt66 = new javax.swing.JTextField();
        txt67 = new javax.swing.JTextField();
        txt68 = new javax.swing.JTextField();
        txt60 = new javax.swing.JTextField();
        txt71 = new javax.swing.JTextField();
        txt72 = new javax.swing.JTextField();
        txt73 = new javax.swing.JTextField();
        txt74 = new javax.swing.JTextField();
        txt75 = new javax.swing.JTextField();
        txt76 = new javax.swing.JTextField();
        txt77 = new javax.swing.JTextField();
        txt78 = new javax.swing.JTextField();
        txt70 = new javax.swing.JTextField();
        txt81 = new javax.swing.JTextField();
        txt82 = new javax.swing.JTextField();
        txt83 = new javax.swing.JTextField();
        txt84 = new javax.swing.JTextField();
        txt85 = new javax.swing.JTextField();
        txt86 = new javax.swing.JTextField();
        txt87 = new javax.swing.JTextField();
        txt88 = new javax.swing.JTextField();
        txt80 = new javax.swing.JTextField();
        mostrarNick = new javax.swing.JLabel();
        error = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtHistorialJ = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        txt01.setBackground(new java.awt.Color(153, 153, 153));
        txt01.setAlignmentX(0.0F);
        txt01.setAlignmentY(0.0F);
        txt01.setAutoscrolls(false);
        txt01.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt02.setBackground(new java.awt.Color(153, 153, 153));
        txt02.setAlignmentX(0.0F);
        txt02.setAlignmentY(0.0F);
        txt02.setAutoscrolls(false);
        txt02.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt02ActionPerformed(evt);
            }
        });
        txt02.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt02KeyReleased(evt);
            }
        });

        txt03.setAlignmentX(0.0F);
        txt03.setAlignmentY(0.0F);
        txt03.setAutoscrolls(false);
        txt03.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt03.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt03KeyReleased(evt);
            }
        });

        txt04.setAlignmentX(0.0F);
        txt04.setAlignmentY(0.0F);
        txt04.setAutoscrolls(false);
        txt04.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt05.setAlignmentX(0.0F);
        txt05.setAlignmentY(0.0F);
        txt05.setAutoscrolls(false);
        txt05.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt05.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt05KeyReleased(evt);
            }
        });

        txt06.setBackground(new java.awt.Color(153, 153, 153));
        txt06.setAlignmentX(0.0F);
        txt06.setAlignmentY(0.0F);
        txt06.setAutoscrolls(false);
        txt06.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt06.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt06KeyReleased(evt);
            }
        });

        txt07.setBackground(new java.awt.Color(153, 153, 153));
        txt07.setAlignmentX(0.0F);
        txt07.setAlignmentY(0.0F);
        txt07.setAutoscrolls(false);
        txt07.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt07.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt07KeyReleased(evt);
            }
        });

        txt08.setBackground(new java.awt.Color(153, 153, 153));
        txt08.setAlignmentX(0.0F);
        txt08.setAlignmentY(0.0F);
        txt08.setAutoscrolls(false);
        txt08.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt00.setBackground(new java.awt.Color(153, 153, 153));
        txt00.setAlignmentX(0.0F);
        txt00.setAlignmentY(0.0F);
        txt00.setAutoscrolls(false);
        txt00.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt00.setName("txt00"); // NOI18N
        txt00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt00ActionPerformed(evt);
            }
        });

        txt11.setBackground(new java.awt.Color(153, 153, 153));
        txt11.setAlignmentX(0.0F);
        txt11.setAlignmentY(0.0F);
        txt11.setAutoscrolls(false);
        txt11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt11KeyReleased(evt);
            }
        });

        txt12.setBackground(new java.awt.Color(153, 153, 153));
        txt12.setAlignmentX(0.0F);
        txt12.setAlignmentY(0.0F);
        txt12.setAutoscrolls(false);
        txt12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt13.setAlignmentX(0.0F);
        txt13.setAlignmentY(0.0F);
        txt13.setAutoscrolls(false);
        txt13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt13KeyReleased(evt);
            }
        });

        txt14.setAlignmentX(0.0F);
        txt14.setAlignmentY(0.0F);
        txt14.setAutoscrolls(false);
        txt14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt15.setAlignmentX(0.0F);
        txt15.setAlignmentY(0.0F);
        txt15.setAutoscrolls(false);
        txt15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt15KeyReleased(evt);
            }
        });

        txt16.setBackground(new java.awt.Color(153, 153, 153));
        txt16.setAlignmentX(0.0F);
        txt16.setAlignmentY(0.0F);
        txt16.setAutoscrolls(false);
        txt16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt17.setBackground(new java.awt.Color(153, 153, 153));
        txt17.setAlignmentX(0.0F);
        txt17.setAlignmentY(0.0F);
        txt17.setAutoscrolls(false);
        txt17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt18.setBackground(new java.awt.Color(153, 153, 153));
        txt18.setAlignmentX(0.0F);
        txt18.setAlignmentY(0.0F);
        txt18.setAutoscrolls(false);
        txt18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt10.setBackground(new java.awt.Color(153, 153, 153));
        txt10.setAlignmentX(0.0F);
        txt10.setAlignmentY(0.0F);
        txt10.setAutoscrolls(false);
        txt10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt21.setBackground(new java.awt.Color(153, 153, 153));
        txt21.setAlignmentX(0.0F);
        txt21.setAlignmentY(0.0F);
        txt21.setAutoscrolls(false);
        txt21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt22.setBackground(new java.awt.Color(153, 153, 153));
        txt22.setAlignmentX(0.0F);
        txt22.setAlignmentY(0.0F);
        txt22.setAutoscrolls(false);
        txt22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt23.setAlignmentX(0.0F);
        txt23.setAlignmentY(0.0F);
        txt23.setAutoscrolls(false);
        txt23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt23KeyReleased(evt);
            }
        });

        txt24.setAlignmentX(0.0F);
        txt24.setAlignmentY(0.0F);
        txt24.setAutoscrolls(false);
        txt24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt24KeyReleased(evt);
            }
        });

        txt25.setAlignmentX(0.0F);
        txt25.setAlignmentY(0.0F);
        txt25.setAutoscrolls(false);
        txt25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt25KeyReleased(evt);
            }
        });

        txt26.setBackground(new java.awt.Color(153, 153, 153));
        txt26.setAlignmentX(0.0F);
        txt26.setAlignmentY(0.0F);
        txt26.setAutoscrolls(false);
        txt26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt26KeyReleased(evt);
            }
        });

        txt27.setBackground(new java.awt.Color(153, 153, 153));
        txt27.setAlignmentX(0.0F);
        txt27.setAlignmentY(0.0F);
        txt27.setAutoscrolls(false);
        txt27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt27KeyReleased(evt);
            }
        });

        txt28.setBackground(new java.awt.Color(153, 153, 153));
        txt28.setAlignmentX(0.0F);
        txt28.setAlignmentY(0.0F);
        txt28.setAutoscrolls(false);
        txt28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt28.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt28KeyReleased(evt);
            }
        });

        txt20.setBackground(new java.awt.Color(153, 153, 153));
        txt20.setAlignmentX(0.0F);
        txt20.setAlignmentY(0.0F);
        txt20.setAutoscrolls(false);
        txt20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt20KeyReleased(evt);
            }
        });

        txt31.setAlignmentX(0.0F);
        txt31.setAlignmentY(0.0F);
        txt31.setAutoscrolls(false);
        txt31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt32.setAlignmentX(0.0F);
        txt32.setAlignmentY(0.0F);
        txt32.setAutoscrolls(false);
        txt32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt33.setBackground(new java.awt.Color(153, 153, 153));
        txt33.setAlignmentX(0.0F);
        txt33.setAlignmentY(0.0F);
        txt33.setAutoscrolls(false);
        txt33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt33.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt33KeyReleased(evt);
            }
        });

        txt34.setBackground(new java.awt.Color(153, 153, 153));
        txt34.setAlignmentX(0.0F);
        txt34.setAlignmentY(0.0F);
        txt34.setAutoscrolls(false);
        txt34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt35.setBackground(new java.awt.Color(153, 153, 153));
        txt35.setAlignmentX(0.0F);
        txt35.setAlignmentY(0.0F);
        txt35.setAutoscrolls(false);
        txt35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt36.setAlignmentX(0.0F);
        txt36.setAlignmentY(0.0F);
        txt36.setAutoscrolls(false);
        txt36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt36.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt36KeyReleased(evt);
            }
        });

        txt37.setAlignmentX(0.0F);
        txt37.setAlignmentY(0.0F);
        txt37.setAutoscrolls(false);
        txt37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt38.setAlignmentX(0.0F);
        txt38.setAlignmentY(0.0F);
        txt38.setAutoscrolls(false);
        txt38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt30.setAlignmentX(0.0F);
        txt30.setAlignmentY(0.0F);
        txt30.setAutoscrolls(false);
        txt30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt41.setAlignmentX(0.0F);
        txt41.setAlignmentY(0.0F);
        txt41.setAutoscrolls(false);
        txt41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt41.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt41KeyReleased(evt);
            }
        });

        txt42.setAlignmentX(0.0F);
        txt42.setAlignmentY(0.0F);
        txt42.setAutoscrolls(false);
        txt42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt42.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt42KeyReleased(evt);
            }
        });

        txt43.setBackground(new java.awt.Color(153, 153, 153));
        txt43.setAlignmentX(0.0F);
        txt43.setAlignmentY(0.0F);
        txt43.setAutoscrolls(false);
        txt43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt43ActionPerformed(evt);
            }
        });
        txt43.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt43KeyReleased(evt);
            }
        });

        txt44.setBackground(new java.awt.Color(153, 153, 153));
        txt44.setAlignmentX(0.0F);
        txt44.setAlignmentY(0.0F);
        txt44.setAutoscrolls(false);
        txt44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt44.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt44KeyReleased(evt);
            }
        });

        txt45.setBackground(new java.awt.Color(153, 153, 153));
        txt45.setAlignmentX(0.0F);
        txt45.setAlignmentY(0.0F);
        txt45.setAutoscrolls(false);
        txt45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt45.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt45KeyReleased(evt);
            }
        });

        txt46.setAlignmentX(0.0F);
        txt46.setAlignmentY(0.0F);
        txt46.setAutoscrolls(false);
        txt46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt46.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt46KeyReleased(evt);
            }
        });

        txt47.setAlignmentX(0.0F);
        txt47.setAlignmentY(0.0F);
        txt47.setAutoscrolls(false);
        txt47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt47.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt47KeyReleased(evt);
            }
        });

        txt48.setAlignmentX(0.0F);
        txt48.setAlignmentY(0.0F);
        txt48.setAutoscrolls(false);
        txt48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt48.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt48KeyReleased(evt);
            }
        });

        txt40.setAlignmentX(0.0F);
        txt40.setAlignmentY(0.0F);
        txt40.setAutoscrolls(false);
        txt40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt40ActionPerformed(evt);
            }
        });
        txt40.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt40KeyReleased(evt);
            }
        });

        txt51.setAlignmentX(0.0F);
        txt51.setAlignmentY(0.0F);
        txt51.setAutoscrolls(false);
        txt51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt51ActionPerformed(evt);
            }
        });
        txt51.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt51KeyReleased(evt);
            }
        });

        txt52.setAlignmentX(0.0F);
        txt52.setAlignmentY(0.0F);
        txt52.setAutoscrolls(false);
        txt52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt53.setBackground(new java.awt.Color(153, 153, 153));
        txt53.setAlignmentX(0.0F);
        txt53.setAlignmentY(0.0F);
        txt53.setAutoscrolls(false);
        txt53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt53.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt53KeyReleased(evt);
            }
        });

        txt54.setBackground(new java.awt.Color(153, 153, 153));
        txt54.setAlignmentX(0.0F);
        txt54.setAlignmentY(0.0F);
        txt54.setAutoscrolls(false);
        txt54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt55.setBackground(new java.awt.Color(153, 153, 153));
        txt55.setAlignmentX(0.0F);
        txt55.setAlignmentY(0.0F);
        txt55.setAutoscrolls(false);
        txt55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt56.setAlignmentX(0.0F);
        txt56.setAlignmentY(0.0F);
        txt56.setAutoscrolls(false);
        txt56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt56.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt56KeyReleased(evt);
            }
        });

        txt57.setAlignmentX(0.0F);
        txt57.setAlignmentY(0.0F);
        txt57.setAutoscrolls(false);
        txt57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt58.setAlignmentX(0.0F);
        txt58.setAlignmentY(0.0F);
        txt58.setAutoscrolls(false);
        txt58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt50.setAlignmentX(0.0F);
        txt50.setAlignmentY(0.0F);
        txt50.setAutoscrolls(false);
        txt50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt61.setBackground(new java.awt.Color(153, 153, 153));
        txt61.setAlignmentX(0.0F);
        txt61.setAlignmentY(0.0F);
        txt61.setAutoscrolls(false);
        txt61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt61ActionPerformed(evt);
            }
        });
        txt61.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt61KeyReleased(evt);
            }
        });

        txt62.setBackground(new java.awt.Color(153, 153, 153));
        txt62.setAlignmentX(0.0F);
        txt62.setAlignmentY(0.0F);
        txt62.setAutoscrolls(false);
        txt62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt62ActionPerformed(evt);
            }
        });
        txt62.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt62KeyReleased(evt);
            }
        });

        txt63.setAlignmentX(0.0F);
        txt63.setAlignmentY(0.0F);
        txt63.setAutoscrolls(false);
        txt63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt63.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt63KeyReleased(evt);
            }
        });

        txt64.setAlignmentX(0.0F);
        txt64.setAlignmentY(0.0F);
        txt64.setAutoscrolls(false);
        txt64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt64.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt64KeyReleased(evt);
            }
        });

        txt65.setAlignmentX(0.0F);
        txt65.setAlignmentY(0.0F);
        txt65.setAutoscrolls(false);
        txt65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt66.setBackground(new java.awt.Color(153, 153, 153));
        txt66.setAlignmentX(0.0F);
        txt66.setAlignmentY(0.0F);
        txt66.setAutoscrolls(false);
        txt66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt66.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt66KeyReleased(evt);
            }
        });

        txt67.setBackground(new java.awt.Color(153, 153, 153));
        txt67.setAlignmentX(0.0F);
        txt67.setAlignmentY(0.0F);
        txt67.setAutoscrolls(false);
        txt67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt68.setBackground(new java.awt.Color(153, 153, 153));
        txt68.setAlignmentX(0.0F);
        txt68.setAlignmentY(0.0F);
        txt68.setAutoscrolls(false);
        txt68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt68.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt68KeyReleased(evt);
            }
        });

        txt60.setBackground(new java.awt.Color(153, 153, 153));
        txt60.setAlignmentX(0.0F);
        txt60.setAlignmentY(0.0F);
        txt60.setAutoscrolls(false);
        txt60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt60.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt60KeyReleased(evt);
            }
        });

        txt71.setBackground(new java.awt.Color(153, 153, 153));
        txt71.setAlignmentX(0.0F);
        txt71.setAlignmentY(0.0F);
        txt71.setAutoscrolls(false);
        txt71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt71.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt71KeyReleased(evt);
            }
        });

        txt72.setBackground(new java.awt.Color(153, 153, 153));
        txt72.setAlignmentX(0.0F);
        txt72.setAlignmentY(0.0F);
        txt72.setAutoscrolls(false);
        txt72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt73.setAlignmentX(0.0F);
        txt73.setAlignmentY(0.0F);
        txt73.setAutoscrolls(false);
        txt73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt73.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt73KeyReleased(evt);
            }
        });

        txt74.setAlignmentX(0.0F);
        txt74.setAlignmentY(0.0F);
        txt74.setAutoscrolls(false);
        txt74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt75.setAlignmentX(0.0F);
        txt75.setAlignmentY(0.0F);
        txt75.setAutoscrolls(false);
        txt75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt75.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt75KeyReleased(evt);
            }
        });

        txt76.setBackground(new java.awt.Color(153, 153, 153));
        txt76.setAlignmentX(0.0F);
        txt76.setAlignmentY(0.0F);
        txt76.setAutoscrolls(false);
        txt76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt76.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt76KeyReleased(evt);
            }
        });

        txt77.setBackground(new java.awt.Color(153, 153, 153));
        txt77.setAlignmentX(0.0F);
        txt77.setAlignmentY(0.0F);
        txt77.setAutoscrolls(false);
        txt77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt77.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt77KeyReleased(evt);
            }
        });

        txt78.setBackground(new java.awt.Color(153, 153, 153));
        txt78.setAlignmentX(0.0F);
        txt78.setAlignmentY(0.0F);
        txt78.setAutoscrolls(false);
        txt78.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt78.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt78KeyReleased(evt);
            }
        });

        txt70.setBackground(new java.awt.Color(153, 153, 153));
        txt70.setAlignmentX(0.0F);
        txt70.setAlignmentY(0.0F);
        txt70.setAutoscrolls(false);
        txt70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt70.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt70KeyReleased(evt);
            }
        });

        txt81.setBackground(new java.awt.Color(153, 153, 153));
        txt81.setAlignmentX(0.0F);
        txt81.setAlignmentY(0.0F);
        txt81.setAutoscrolls(false);
        txt81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt81.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt81KeyReleased(evt);
            }
        });

        txt82.setBackground(new java.awt.Color(153, 153, 153));
        txt82.setAlignmentX(0.0F);
        txt82.setAlignmentY(0.0F);
        txt82.setAutoscrolls(false);
        txt82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt83.setAlignmentX(0.0F);
        txt83.setAlignmentY(0.0F);
        txt83.setAutoscrolls(false);
        txt83.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt83.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt83KeyReleased(evt);
            }
        });

        txt84.setAlignmentX(0.0F);
        txt84.setAlignmentY(0.0F);
        txt84.setAutoscrolls(false);
        txt84.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt85.setAlignmentX(0.0F);
        txt85.setAlignmentY(0.0F);
        txt85.setAutoscrolls(false);
        txt85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt85.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt85KeyReleased(evt);
            }
        });

        txt86.setBackground(new java.awt.Color(153, 153, 153));
        txt86.setAlignmentX(0.0F);
        txt86.setAlignmentY(0.0F);
        txt86.setAutoscrolls(false);
        txt86.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt87.setBackground(new java.awt.Color(153, 153, 153));
        txt87.setAlignmentX(0.0F);
        txt87.setAlignmentY(0.0F);
        txt87.setAutoscrolls(false);
        txt87.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt88.setBackground(new java.awt.Color(153, 153, 153));
        txt88.setAlignmentX(0.0F);
        txt88.setAlignmentY(0.0F);
        txt88.setAutoscrolls(false);
        txt88.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt80.setBackground(new java.awt.Color(153, 153, 153));
        txt80.setAlignmentX(0.0F);
        txt80.setAlignmentY(0.0F);
        txt80.setAutoscrolls(false);
        txt80.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jButton3.setText("Resolver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Ayuda");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Comprobar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton5KeyReleased(evt);
            }
        });

        TxtHistorialJ.setColumns(20);
        TxtHistorialJ.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        TxtHistorialJ.setRows(5);
        jScrollPane1.setViewportView(TxtHistorialJ);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Historial Jugadas");

        jButton6.setText("Reset");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("SUDOKU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt00, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt01, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt02, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt03, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt04, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txt05, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txt06, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txt07, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txt08, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(124, 124, 124)
                                .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt30, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt32, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt40, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt45, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt47, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt48, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt50, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt51, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt52, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt53, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt54, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt55, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt56, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt57, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt58, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt60, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt61, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt62, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt63, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt64, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt65, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt66, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt67, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt68, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt70, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt71, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt72, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt73, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt74, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt75, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt76, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt77, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt78, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt80, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt81, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt82, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt83, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt84, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt85, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt86, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt87, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt88, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mostrarNick, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 20, Short.MAX_VALUE)
                                .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(mostrarNick, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt00, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt01, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt02, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt03, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt04, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt05, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt06, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt07, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt08, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6)
                                    .addComponent(jButton5))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt30, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt32, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt40, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt45, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt47, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt48, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt50, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt51, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt52, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt53, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt54, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt55, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt56, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt57, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt58, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt60, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt61, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt62, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt63, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt64, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt65, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt66, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt67, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt68, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt70, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt71, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt72, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt73, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt74, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt75, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt76, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt77, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt78, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt80, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt81, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt82, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt83, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt84, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt85, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt86, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt87, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt88, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25))))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 550));

        jPanel1.setMinimumSize(new java.awt.Dimension(270, 270));
        jPanel1.setName("JP1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt00ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt00ActionPerformed

    private void txt02KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt02KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt02.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt02.getText()), 0)) {
                error.setText("el numero " + txt02.getText() + " ya esta en la fila");
                txt02.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt02.getText()), 2)) {
                    error.setText("el numero " + txt02.getText() + " ya esta en la columna");
                    txt02.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt02.getText()), 0, 2)) {
                        error.setText("el numero " + txt02.getText() + " ya esta en la caja");
                        txt02.setText("");
                    } else {
                        f.MatrizZudo[0][2] = Integer.valueOf(txt02.getText());
                        f.HistorialPartidas(f.MatrizZudo[0][2]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;

                    }
                }
            }
        } else {
            txt02.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[0][2] = 0;
        }
    }//GEN-LAST:event_txt02KeyReleased

    private void txt03KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt03KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt03.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt03.getText()), 0)) {
                error.setText("el numero " + txt03.getText() + " ya esta en la fila");
                txt03.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt03.getText()), 3)) {
                    error.setText("el numero " + txt03.getText() + " ya esta en la columna");
                    txt03.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt03.getText()), 0, 3)) {
                        error.setText("el numero " + txt03.getText() + " ya esta en la caja");
                        txt03.setText("");
                    } else {
                        f.MatrizZudo[0][3] = Integer.valueOf(txt03.getText());
                        f.HistorialPartidas(f.MatrizZudo[0][3]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt03.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[0][3] = 0;
        }
    }//GEN-LAST:event_txt03KeyReleased

    private void txt05KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt05KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt05KeyReleased

    private void txt06KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt06KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt06.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt06.getText()), 0)) {
                error.setText("el numero " + txt06.getText() + " ya esta en la fila");
                txt06.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt06.getText()), 6)) {
                    error.setText("el numero " + txt06.getText() + " ya esta en la columna");
                    txt06.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt06.getText()), 0, 6)) {
                        error.setText("el numero " + txt06.getText() + " ya esta en la caja");
                        txt06.setText("");
                    } else {
                        f.MatrizZudo[0][6] = Integer.valueOf(txt06.getText());
                        f.HistorialPartidas(f.MatrizZudo[0][6]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt06.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[0][6] = 0;
        }
    }//GEN-LAST:event_txt06KeyReleased

    private void txt07KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt07KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt07.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt07.getText()), 0)) {
                error.setText("el numero " + txt07.getText() + " ya esta en la fila");
                txt07.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt07.getText()), 7)) {
                    error.setText("el numero " + txt07.getText() + " ya esta en la columna");
                    txt07.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt07.getText()), 0, 7)) {
                        error.setText("el numero " + txt07.getText() + " ya esta en la caja");
                        txt07.setText("");
                    } else {
                        f.MatrizZudo[0][7] = Integer.valueOf(txt07.getText());
                        f.HistorialPartidas(f.MatrizZudo[0][7]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt07.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[0][7] = 0;
        }
    }//GEN-LAST:event_txt07KeyReleased

    private void txt11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt11KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt11.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt11.getText()), 1)) {
                error.setText("el numero " + txt11.getText() + " ya esta en la fila");
                txt11.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt11.getText()), 1)) {
                    error.setText("el numero " + txt11.getText() + " ya esta en la columna");
                    txt11.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt11.getText()), 1, 1)) {
                        error.setText("el numero " + txt11.getText() + " ya esta en la caja");
                        txt11.setText("");
                    } else {
                        f.MatrizZudo[1][1] = Integer.valueOf(txt11.getText());
                        f.HistorialPartidas(f.MatrizZudo[1][1]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt11.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[1][1] = 0;
        }
    }//GEN-LAST:event_txt11KeyReleased

    private void txt13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt13KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt13.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt13.getText()), 1)) {
                error.setText("el numero " + txt13.getText() + " ya esta en la fila");
                txt13.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt13.getText()), 3)) {
                    error.setText("el numero " + txt13.getText() + " ya esta en la columna");
                    txt13.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt13.getText()), 1, 3)) {
                        error.setText("el numero " + txt13.getText() + " ya esta en la caja");
                        txt13.setText("");
                    } else {
                        f.MatrizZudo[1][3] = Integer.valueOf(txt13.getText());
                        f.HistorialPartidas(f.MatrizZudo[1][3]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt02.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[1][3] = 0;
        }
    }//GEN-LAST:event_txt13KeyReleased

    private void txt15KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt15KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt15.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt15.getText()), 1)) {
                error.setText("el numero " + txt15.getText() + " ya esta en la fila");
                txt15.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt15.getText()), 5)) {
                    error.setText("el numero " + txt15.getText() + " ya esta en la columna");
                    txt15.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt15.getText()), 1, 5)) {
                        error.setText("el numero " + txt03.getText() + " ya esta en la caja");
                        txt15.setText("");
                    } else {
                        f.MatrizZudo[1][5] = Integer.valueOf(txt15.getText());
                        f.HistorialPartidas(f.MatrizZudo[1][5]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt15.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[1][5] = 0;
        }
    }//GEN-LAST:event_txt15KeyReleased

    private void txt20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt20KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt20.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt20.getText()), 2)) {
                error.setText("el numero " + txt20.getText() + " ya esta en la fila");
                txt20.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt20.getText()), 0)) {
                    error.setText("el numero " + txt20.getText() + " ya esta en la columna");
                    txt20.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt20.getText()), 2, 0)) {
                        error.setText("el numero " + txt20.getText() + " ya esta en la caja");
                        txt20.setText("");
                    } else {
                        f.MatrizZudo[2][0] = Integer.valueOf(txt20.getText());
                        f.HistorialPartidas(f.MatrizZudo[2][0]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt20.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[2][0] = 0;
        }
    }//GEN-LAST:event_txt20KeyReleased

    private void txt23KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt23KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt23.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt23.getText()), 2)) {
                error.setText("el numero " + txt23.getText() + " ya esta en la fila");
                txt23.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt23.getText()), 3)) {
                    error.setText("el numero " + txt23.getText() + " ya esta en la columna");
                    txt23.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt23.getText()), 2, 3)) {
                        error.setText("el numero " + txt23.getText() + " ya esta en la caja");
                        txt23.setText("");
                    } else {
                        f.MatrizZudo[2][3] = Integer.valueOf(txt23.getText());
                        f.HistorialPartidas(f.MatrizZudo[2][3]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt23.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[2][3] = 0;
        }
    }//GEN-LAST:event_txt23KeyReleased

    private void txt24KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt24KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt24.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt24.getText()), 2)) {
                error.setText("el numero " + txt24.getText() + " ya esta en la fila");
                txt24.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt24.getText()), 4)) {
                    error.setText("el numero " + txt24.getText() + " ya esta en la columna");
                    txt24.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt24.getText()), 2, 4)) {
                        error.setText("el numero " + txt24.getText() + " ya esta en la caja");
                        txt24.setText("");
                    } else {
                        f.MatrizZudo[2][4] = Integer.valueOf(txt24.getText());
                        f.HistorialPartidas(f.MatrizZudo[2][4]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt24.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[2][4] = 0;
        }
    }//GEN-LAST:event_txt24KeyReleased

    private void txt25KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt25KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt25.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt25.getText()), 2)) {
                error.setText("el numero " + txt25.getText() + " ya esta en la fila");
                txt25.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt25.getText()), 5)) {
                    error.setText("el numero " + txt25.getText() + " ya esta en la columna");
                    txt25.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt25.getText()), 2, 5)) {
                        error.setText("el numero " + txt25.getText() + " ya esta en la caja");
                        txt25.setText("");
                    } else {
                        f.MatrizZudo[2][5] = Integer.valueOf(txt25.getText());
                        f.HistorialPartidas(f.MatrizZudo[2][5]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt25.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[2][5] = 0;
        }
    }//GEN-LAST:event_txt25KeyReleased

    private void txt26KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt26KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt26.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt26.getText()), 2)) {
                error.setText("el numero " + txt26.getText() + " ya esta en la fila");
                txt26.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt26.getText()), 6)) {
                    error.setText("el numero " + txt26.getText() + " ya esta en la columna");
                    txt26.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt26.getText()), 2, 6)) {
                        error.setText("el numero " + txt26.getText() + " ya esta en la caja");
                        txt26.setText("");
                    } else {
                        f.MatrizZudo[2][6] = Integer.valueOf(txt26.getText());
                        f.HistorialPartidas(f.MatrizZudo[2][6]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt26.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[2][6] = 0;
        }
    }//GEN-LAST:event_txt26KeyReleased

    private void txt27KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt27KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt27.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt27.getText()), 2)) {
                error.setText("el numero " + txt27.getText() + " ya esta en la fila");
                txt27.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt27.getText()), 7)) {
                    error.setText("el numero " + txt27.getText() + " ya esta en la columna");
                    txt27.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt27.getText()), 2, 7)) {
                        error.setText("el numero " + txt27.getText() + " ya esta en la caja");
                        txt27.setText("");
                    } else {
                        f.MatrizZudo[2][7] = Integer.valueOf(txt27.getText());
                        f.HistorialPartidas(f.MatrizZudo[2][7]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt27.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[2][7] = 0;
        }
    }//GEN-LAST:event_txt27KeyReleased

    private void txt28KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt28KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt28.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt28.getText()), 2)) {
                error.setText("el numero " + txt28.getText() + " ya esta en la fila");
                txt28.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt28.getText()), 8)) {
                    error.setText("el numero " + txt28.getText() + " ya esta en la columna");
                    txt28.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt28.getText()), 2, 8)) {
                        error.setText("el numero " + txt28.getText() + " ya esta en la caja");
                        txt28.setText("");
                    } else {
                        f.MatrizZudo[2][8] = Integer.valueOf(txt28.getText());
                        f.HistorialPartidas(f.MatrizZudo[2][8]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt28.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[2][8] = 0;
        }
    }//GEN-LAST:event_txt28KeyReleased

    private void txt33KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt33KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt33.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt33.getText()), 3)) {
                error.setText("el numero " + txt33.getText() + " ya esta en la fila");
                txt33.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt33.getText()), 3)) {
                    error.setText("el numero " + txt33.getText() + " ya esta en la columna");
                    txt33.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt33.getText()), 3, 3)) {
                        error.setText("el numero " + txt33.getText() + " ya esta en la caja");
                        txt33.setText("");
                    } else {
                        f.MatrizZudo[3][3] = Integer.valueOf(txt33.getText());
                        f.HistorialPartidas(f.MatrizZudo[3][3]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt33.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[3][3] = 0;
        }
    }//GEN-LAST:event_txt33KeyReleased

    private void txt36KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt36KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt36.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt36.getText()), 3)) {
                error.setText("el numero " + txt36.getText() + " ya esta en la fila");
                txt36.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt36.getText()), 6)) {
                    error.setText("el numero " + txt36.getText() + " ya esta en la columna");
                    txt36.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt36.getText()), 3, 6)) {
                        error.setText("el numero " + txt36.getText() + " ya esta en la caja");
                        txt36.setText("");
                    } else {
                        f.MatrizZudo[3][6] = Integer.valueOf(txt36.getText());
                        f.HistorialPartidas(f.MatrizZudo[3][6]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt36.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[3][6] = 0;
        }
    }//GEN-LAST:event_txt36KeyReleased

    private void txt40KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt40KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt40.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt40.getText()), 4)) {
                error.setText("el numero " + txt40.getText() + " ya esta en la fila");
                txt40.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt40.getText()), 0)) {
                    error.setText("el numero " + txt40.getText() + " ya esta en la columna");
                    txt40.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt40.getText()), 4, 0)) {
                        error.setText("el numero " + txt40.getText() + " ya esta en la caja");
                        txt40.setText("");
                    } else {
                        f.MatrizZudo[4][0] = Integer.valueOf(txt40.getText());
                        f.HistorialPartidas(f.MatrizZudo[4][0]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt40.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[4][0] = 0;
        }
    }//GEN-LAST:event_txt40KeyReleased

    private void txt41KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt41KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt41.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt41.getText()), 4)) {
                error.setText("el numero " + txt41.getText() + " ya esta en la fila");
                txt41.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt41.getText()), 1)) {
                    error.setText("el numero " + txt41.getText() + " ya esta en la columna");
                    txt41.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt41.getText()), 4, 1)) {
                        error.setText("el numero " + txt41.getText() + " ya esta en la caja");
                        txt41.setText("");
                    } else {
                        f.MatrizZudo[4][1] = Integer.valueOf(txt41.getText());
                        f.HistorialPartidas(f.MatrizZudo[4][1]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt41.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[4][1] = 0;
        }
    }//GEN-LAST:event_txt41KeyReleased

    private void txt42KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt42KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt42.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt42.getText()), 4)) {
                error.setText("el numero " + txt42.getText() + " ya esta en la fila");
                txt42.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt42.getText()), 2)) {
                    error.setText("el numero " + txt42.getText() + " ya esta en la columna");
                    txt42.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt42.getText()), 4, 2)) {
                        error.setText("el numero " + txt42.getText() + " ya esta en la caja");
                        txt42.setText("");
                    } else {
                        f.MatrizZudo[4][2] = Integer.valueOf(txt42.getText());
                        f.HistorialPartidas(f.MatrizZudo[4][2]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt42.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[4][2] = 0;
        }
    }//GEN-LAST:event_txt42KeyReleased

    private void txt43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt43ActionPerformed
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt43.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt43.getText()), 4)) {
                error.setText("el numero " + txt43.getText() + " ya esta en la fila");
                txt43.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt43.getText()), 3)) {
                    error.setText("el numero " + txt43.getText() + " ya esta en la columna");
                    txt43.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt43.getText()), 4, 3)) {
                        error.setText("el numero " + txt43.getText() + " ya esta en la caja");
                        txt43.setText("");
                    } else {
                        f.MatrizZudo[4][3] = Integer.valueOf(txt43.getText());
                        f.HistorialPartidas(f.MatrizZudo[4][3]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt02.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[4][3] = 0;
        }
    }//GEN-LAST:event_txt43ActionPerformed

    private void txt44KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt44KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt44.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt44.getText()), 4)) {
                error.setText("el numero " + txt44.getText() + " ya esta en la fila");
                txt44.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt44.getText()), 4)) {
                    error.setText("el numero " + txt44.getText() + " ya esta en la columna");
                    txt44.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt44.getText()), 4, 4)) {
                        error.setText("el numero " + txt03.getText() + " ya esta en la caja");
                        txt44.setText("");
                    } else {
                        f.MatrizZudo[4][4] = Integer.valueOf(txt44.getText());
                        f.HistorialPartidas(f.MatrizZudo[4][4]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt44.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[4][4] = 0;
        }
    }//GEN-LAST:event_txt44KeyReleased

    private void txt45KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt45KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt45.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt45.getText()), 4)) {
                error.setText("el numero " + txt45.getText() + " ya esta en la fila");
                txt45.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt45.getText()), 5)) {
                    error.setText("el numero " + txt45.getText() + " ya esta en la columna");
                    txt45.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt45.getText()), 4, 5)) {
                        error.setText("el numero " + txt45.getText() + " ya esta en la caja");
                        txt45.setText("");
                    } else {
                        f.MatrizZudo[4][5] = Integer.valueOf(txt45.getText());
                        f.HistorialPartidas(f.MatrizZudo[4][5]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt45.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[4][5] = 0;
        }
    }//GEN-LAST:event_txt45KeyReleased

    private void txt46KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt46KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt46.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt46.getText()), 4)) {
                error.setText("el numero " + txt46.getText() + " ya esta en la fila");
                txt46.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt46.getText()), 6)) {
                    error.setText("el numero " + txt46.getText() + " ya esta en la columna");
                    txt46.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt46.getText()), 4, 6)) {
                        error.setText("el numero " + txt46.getText() + " ya esta en la caja");
                        txt46.setText("");
                    } else {
                        f.MatrizZudo[4][6] = Integer.valueOf(txt46.getText());
                        f.HistorialPartidas(f.MatrizZudo[4][6]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt46.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[4][6] = 0;
        }
    }//GEN-LAST:event_txt46KeyReleased

    private void txt47KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt47KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt47.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt47.getText()), 4)) {
                error.setText("el numero " + txt47.getText() + " ya esta en la fila");
                txt47.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt47.getText()), 7)) {
                    error.setText("el numero " + txt47.getText() + " ya esta en la columna");
                    txt47.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt47.getText()), 4, 7)) {
                        error.setText("el numero " + txt47.getText() + " ya esta en la caja");
                        txt47.setText("");
                    } else {
                        f.MatrizZudo[4][7] = Integer.valueOf(txt47.getText());
                        f.HistorialPartidas(f.MatrizZudo[4][7]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt47.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[4][7] = 0;
        }
    }//GEN-LAST:event_txt47KeyReleased

    private void txt48KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt48KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt48.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt48.getText()), 4)) {
                error.setText("el numero " + txt48.getText() + " ya esta en la fila");
                txt48.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt48.getText()), 8)) {
                    error.setText("el numero " + txt48.getText() + " ya esta en la columna");
                    txt48.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt48.getText()), 4, 8)) {
                        error.setText("el numero " + txt48.getText() + " ya esta en la caja");
                        txt48.setText("");
                    } else {
                        f.MatrizZudo[4][8] = Integer.valueOf(txt48.getText());
                        f.HistorialPartidas(f.MatrizZudo[4][8]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt48.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[4][8] = 0;
        }
    }//GEN-LAST:event_txt48KeyReleased

    private void txt51KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt51KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt51.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt51.getText()), 5)) {
                error.setText("el numero " + txt51.getText() + " ya esta en la fila");
                txt51.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt51.getText()), 1)) {
                    error.setText("el numero " + txt51.getText() + " ya esta en la columna");
                    txt51.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt51.getText()), 5, 1)) {
                        error.setText("el numero " + txt51.getText() + " ya esta en la caja");
                        txt51.setText("");
                    } else {
                        f.MatrizZudo[5][1] = Integer.valueOf(txt51.getText());
                        f.HistorialPartidas(f.MatrizZudo[5][1]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt51.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[5][1] = 0;
        }
    }//GEN-LAST:event_txt51KeyReleased

    private void txt53KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt53KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt53.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt53.getText()), 5)) {
                error.setText("el numero " + txt53.getText() + " ya esta en la fila");
                txt53.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt53.getText()), 3)) {
                    error.setText("el numero " + txt53.getText() + " ya esta en la columna");
                    txt53.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt53.getText()), 5, 3)) {
                        error.setText("el numero " + txt53.getText() + " ya esta en la caja");
                        txt53.setText("");
                    } else {
                        f.MatrizZudo[5][3] = Integer.valueOf(txt53.getText());
                        f.HistorialPartidas(f.MatrizZudo[5][3]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt53.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[5][3] = 0;
        }
    }//GEN-LAST:event_txt53KeyReleased

    private void txt56KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt56KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt56.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt56.getText()), 5)) {
                error.setText("el numero " + txt56.getText() + " ya esta en la fila");
                txt56.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt56.getText()), 6)) {
                    error.setText("el numero " + txt56.getText() + " ya esta en la columna");
                    txt56.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt56.getText()), 5, 6)) {
                        error.setText("el numero " + txt56.getText() + " ya esta en la caja");
                        txt56.setText("");
                    } else {
                        f.MatrizZudo[5][6] = Integer.valueOf(txt56.getText());
                        f.HistorialPartidas(f.MatrizZudo[5][6]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt56.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[5][6] = 0;
        }
    }//GEN-LAST:event_txt56KeyReleased

    private void txt60KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt60KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt60.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt60.getText()), 6)) {
                error.setText("el numero " + txt60.getText() + " ya esta en la fila");
                txt60.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt60.getText()), 0)) {
                    error.setText("el numero " + txt60.getText() + " ya esta en la columna");
                    txt60.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt60.getText()), 6, 0)) {
                        error.setText("el numero " + txt60.getText() + " ya esta en la caja");
                        txt60.setText("");
                    } else {
                        f.MatrizZudo[6][0] = Integer.valueOf(txt60.getText());
                        f.HistorialPartidas(f.MatrizZudo[6][0]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt60.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[6][0] = 0;
        }
    }//GEN-LAST:event_txt60KeyReleased

    private void txt51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt51ActionPerformed

    private void txt61KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt61KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt61.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt61.getText()), 6)) {
                error.setText("el numero " + txt61.getText() + " ya esta en la fila");
                txt61.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt61.getText()), 1)) {
                    error.setText("el numero " + txt61.getText() + " ya esta en la columna");
                    txt61.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt61.getText()), 6, 1)) {
                        error.setText("el numero " + txt61.getText() + " ya esta en la caja");
                        txt61.setText("");
                    } else {
                        f.MatrizZudo[6][1] = Integer.valueOf(txt61.getText());
                        f.HistorialPartidas(f.MatrizZudo[6][1]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt61.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[6][1] = 0;
        }
    }//GEN-LAST:event_txt61KeyReleased

    private void txt62KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt62KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt62.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt62.getText()), 6)) {
                error.setText("el numero " + txt62.getText() + " ya esta en la fila");
                txt62.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt62.getText()), 2)) {
                    error.setText("el numero " + txt62.getText() + " ya esta en la columna");
                    txt62.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt62.getText()), 6, 2)) {
                        error.setText("el numero " + txt62.getText() + " ya esta en la caja");
                        txt62.setText("");
                    } else {
                        f.MatrizZudo[6][2] = Integer.valueOf(txt62.getText());
                        f.HistorialPartidas(f.MatrizZudo[6][2]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt62.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[6][2] = 0;
        }
    }//GEN-LAST:event_txt62KeyReleased

    private void txt63KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt63KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt63.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt63.getText()), 6)) {
                error.setText("el numero " + txt63.getText() + " ya esta en la fila");
                txt63.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt63.getText()), 3)) {
                    error.setText("el numero " + txt63.getText() + " ya esta en la columna");
                    txt63.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt63.getText()), 6, 3)) {
                        error.setText("el numero " + txt63.getText() + " ya esta en la caja");
                        txt63.setText("");
                    } else {
                        f.MatrizZudo[6][3] = Integer.valueOf(txt63.getText());
                        f.HistorialPartidas(f.MatrizZudo[6][3]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt63.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[6][3] = 0;
        }
    }//GEN-LAST:event_txt63KeyReleased

    private void txt64KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt64KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt64.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt64.getText()), 6)) {
                error.setText("el numero " + txt64.getText() + " ya esta en la fila");
                txt64.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt64.getText()), 4)) {
                    error.setText("el numero " + txt64.getText() + " ya esta en la columna");
                    txt64.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt64.getText()), 6, 4)) {
                        error.setText("el numero " + txt64.getText() + " ya esta en la caja");
                        txt64.setText("");
                    } else {
                        f.MatrizZudo[6][4] = Integer.valueOf(txt64.getText());
                        f.HistorialPartidas(f.MatrizZudo[6][4]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt64.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[6][4] = 0;
        }
    }//GEN-LAST:event_txt64KeyReleased

    private void txt66KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt66KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt66.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt66.getText()), 6)) {
                error.setText("el numero " + txt66.getText() + " ya esta en la fila");
                txt66.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt66.getText()), 6)) {
                    error.setText("el numero " + txt66.getText() + " ya esta en la columna");
                    txt66.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt66.getText()), 6, 6)) {
                        error.setText("el numero " + txt66.getText() + " ya esta en la caja");
                        txt66.setText("");
                    } else {
                        f.MatrizZudo[6][6] = Integer.valueOf(txt66.getText());
                        f.HistorialPartidas(f.MatrizZudo[6][6]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt66.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[6][6] = 0;
        }
    }//GEN-LAST:event_txt66KeyReleased

    private void txt68KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt68KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt68.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt68.getText()), 6)) {
                error.setText("el numero " + txt68.getText() + " ya esta en la fila");
                txt68.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt68.getText()), 8)) {
                    error.setText("el numero " + txt68.getText() + " ya esta en la columna");
                    txt68.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt68.getText()), 6, 8)) {
                        error.setText("el numero " + txt68.getText() + " ya esta en la caja");
                        txt68.setText("");
                    } else {
                        f.MatrizZudo[6][8] = Integer.valueOf(txt68.getText());
                        f.HistorialPartidas(f.MatrizZudo[6][8]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt68.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[6][8] = 0;
        }
    }//GEN-LAST:event_txt68KeyReleased

    private void txt70KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt70KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt70.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt70.getText()), 7)) {
                error.setText("el numero " + txt70.getText() + " ya esta en la fila");
                txt70.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt70.getText()), 0)) {
                    error.setText("el numero " + txt70.getText() + " ya esta en la columna");
                    txt70.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt70.getText()), 7, 0)) {
                        error.setText("el numero " + txt70.getText() + " ya esta en la caja");
                        txt70.setText("");
                    } else {
                        f.MatrizZudo[7][0] = Integer.valueOf(txt70.getText());
                        f.HistorialPartidas(f.MatrizZudo[7][0]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt70.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[7][0] = 0;
        }
    }//GEN-LAST:event_txt70KeyReleased

    private void txt71KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt71KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt71.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt71.getText()), 7)) {
                error.setText("el numero " + txt71.getText() + " ya esta en la fila");
                txt71.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt71.getText()), 1)) {
                    error.setText("el numero " + txt71.getText() + " ya esta en la columna");
                    txt71.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt71.getText()), 7, 1)) {
                        error.setText("el numero " + txt71.getText() + " ya esta en la caja");
                        txt71.setText("");
                    } else {
                        f.MatrizZudo[7][1] = Integer.valueOf(txt71.getText());
                        f.HistorialPartidas(f.MatrizZudo[7][1]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt71.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[7][1] = 0;
        }
    }//GEN-LAST:event_txt71KeyReleased

    private void txt73KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt73KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt73.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt73.getText()), 7)) {
                error.setText("el numero " + txt73.getText() + " ya esta en la fila");
                txt73.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt73.getText()), 3)) {
                    error.setText("el numero " + txt73.getText() + " ya esta en la columna");
                    txt73.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt73.getText()), 7, 3)) {
                        error.setText("el numero " + txt73.getText() + " ya esta en la caja");
                        txt73.setText("");
                    } else {
                        f.MatrizZudo[7][3] = Integer.valueOf(txt73.getText());
                        f.HistorialPartidas(f.MatrizZudo[7][3]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt73.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[7][3] = 0;
        }
    }//GEN-LAST:event_txt73KeyReleased

    private void txt75KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt75KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt75.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt75.getText()), 7)) {
                error.setText("el numero " + txt75.getText() + " ya esta en la fila");
                txt75.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt75.getText()), 5)) {
                    error.setText("el numero " + txt75.getText() + " ya esta en la columna");
                    txt75.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt75.getText()), 7, 5)) {
                        error.setText("el numero " + txt75.getText() + " ya esta en la caja");
                        txt75.setText("");
                    } else {
                        f.MatrizZudo[7][5] = Integer.valueOf(txt75.getText());
                        f.HistorialPartidas(f.MatrizZudo[7][5]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt75.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[7][5] = 0;
        }
    }//GEN-LAST:event_txt75KeyReleased

    private void txt76KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt76KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt76.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt76.getText()), 7)) {
                error.setText("el numero " + txt76.getText() + " ya esta en la fila");
                txt76.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt76.getText()), 6)) {
                    error.setText("el numero " + txt76.getText() + " ya esta en la columna");
                    txt76.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt76.getText()), 7, 6)) {
                        error.setText("el numero " + txt76.getText() + " ya esta en la caja");
                        txt76.setText("");
                    } else {
                        f.MatrizZudo[7][6] = Integer.valueOf(txt76.getText());
                        f.HistorialPartidas(f.MatrizZudo[7][6]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt76.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[7][6] = 0;
        }
    }//GEN-LAST:event_txt76KeyReleased

    private void txt77KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt77KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt77.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt77.getText()), 7)) {
                error.setText("el numero " + txt77.getText() + " ya esta en la fila");
                txt77.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt77.getText()), 7)) {
                    error.setText("el numero " + txt77.getText() + " ya esta en la columna");
                    txt77.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt77.getText()), 7, 7)) {
                        error.setText("el numero " + txt77.getText() + " ya esta en la caja");
                        txt77.setText("");
                    } else {
                        f.MatrizZudo[7][7] = Integer.valueOf(txt77.getText());
                        f.HistorialPartidas(f.MatrizZudo[7][7]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt77.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[7][7] = 0;
        }
    }//GEN-LAST:event_txt77KeyReleased

    private void txt78KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt78KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt78.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt78.getText()), 7)) {
                error.setText("el numero " + txt78.getText() + " ya esta en la fila");
                txt78.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt78.getText()), 8)) {
                    error.setText("el numero " + txt78.getText() + " ya esta en la columna");
                    txt78.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt78.getText()), 7, 8)) {
                        error.setText("el numero " + txt78.getText() + " ya esta en la caja");
                        txt78.setText("");
                    } else {
                        f.MatrizZudo[7][8] = Integer.valueOf(txt78.getText());
                        f.HistorialPartidas(f.MatrizZudo[7][8]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt78.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[7][8] = 0;
        }
    }//GEN-LAST:event_txt78KeyReleased

    private void txt81KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt81KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt81.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt81.getText()), 8)) {
                error.setText("el numero " + txt81.getText() + " ya esta en la fila");
                txt81.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt81.getText()), 1)) {
                    error.setText("el numero " + txt81.getText() + " ya esta en la columna");
                    txt81.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt81.getText()), 8, 1)) {
                        error.setText("el numero " + txt81.getText() + " ya esta en la caja");
                        txt81.setText("");
                    } else {
                        f.MatrizZudo[8][1] = Integer.valueOf(txt81.getText());
                        f.HistorialPartidas(f.MatrizZudo[8][1]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt81.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[8][1] = 0;
        }
    }//GEN-LAST:event_txt81KeyReleased

    private void txt83KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt83KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt83.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt83.getText()), 8)) {
                error.setText("el numero " + txt83.getText() + " ya esta en la fila");
                txt83.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt83.getText()), 3)) {
                    error.setText("el numero " + txt83.getText() + " ya esta en la columna");
                    txt83.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt83.getText()), 8, 3)) {
                        error.setText("el numero " + txt83.getText() + " ya esta en la caja");
                        txt83.setText("");
                    } else {
                        f.MatrizZudo[8][3] = Integer.valueOf(txt83.getText());
                        f.HistorialPartidas(f.MatrizZudo[8][3]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt83.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[8][3] = 0;
        }
    }//GEN-LAST:event_txt83KeyReleased

    private void txt85KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt85KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt85.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt85.getText()), 8)) {
                error.setText("el numero " + txt85.getText() + " ya esta en la fila");
                txt85.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt85.getText()), 5)) {
                    error.setText("el numero " + txt85.getText() + " ya esta en la columna");
                    txt85.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt85.getText()), 8, 5)) {
                        error.setText("el numero " + txt85.getText() + " ya esta en la caja");
                        txt85.setText("");
                    } else {
                        f.MatrizZudo[8][5] = Integer.valueOf(txt85.getText());
                        f.HistorialPartidas(f.MatrizZudo[8][5]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt85.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[8][5] = 0;
        }
    }//GEN-LAST:event_txt85KeyReleased

    private void txt43KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt43KeyReleased
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt43.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt43.getText()), 4)) {
                error.setText("el numero " + txt43.getText() + " ya esta en la fila");
                txt43.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt43.getText()), 3)) {
                    error.setText("el numero " + txt43.getText() + " ya esta en la columna");
                    txt43.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt43.getText()), 4, 3)) {
                        error.setText("el numero " + txt43.getText() + " ya esta en la caja");
                        txt43.setText("");
                    } else {
                        f.MatrizZudo[4][3] = Integer.valueOf(txt43.getText());
                        f.HistorialPartidas(f.MatrizZudo[4][3]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt43.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[4][3] = 0;
        }
    }//GEN-LAST:event_txt43KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        f.SudokuSolucion();
        txt00.setText(String.valueOf(f.MatrizSolucion[0][0]));
        txt01.setText(String.valueOf(f.MatrizSolucion[0][1]));
        txt02.setText(String.valueOf(f.MatrizSolucion[0][2]));
        txt03.setText(String.valueOf(f.MatrizSolucion[0][3]));
        txt04.setText(String.valueOf(f.MatrizSolucion[0][4]));
        txt05.setText(String.valueOf(f.MatrizSolucion[0][5]));
        txt06.setText(String.valueOf(f.MatrizSolucion[0][6]));
        txt07.setText(String.valueOf(f.MatrizSolucion[0][7]));
        txt08.setText(String.valueOf(f.MatrizSolucion[0][8]));
        txt10.setText(String.valueOf(f.MatrizSolucion[1][0]));
        txt11.setText(String.valueOf(f.MatrizSolucion[1][1]));
        txt12.setText(String.valueOf(f.MatrizSolucion[1][2]));
        txt13.setText(String.valueOf(f.MatrizSolucion[1][3]));
        txt14.setText(String.valueOf(f.MatrizSolucion[1][4]));
        txt15.setText(String.valueOf(f.MatrizSolucion[1][5]));
        txt16.setText(String.valueOf(f.MatrizSolucion[1][6]));
        txt17.setText(String.valueOf(f.MatrizSolucion[1][7]));
        txt18.setText(String.valueOf(f.MatrizSolucion[1][8]));
        txt20.setText(String.valueOf(f.MatrizSolucion[2][0]));
        txt21.setText(String.valueOf(f.MatrizSolucion[2][1]));
        txt22.setText(String.valueOf(f.MatrizSolucion[2][2]));
        txt23.setText(String.valueOf(f.MatrizSolucion[2][3]));
        txt24.setText(String.valueOf(f.MatrizSolucion[2][4]));
        txt25.setText(String.valueOf(f.MatrizSolucion[2][5]));
        txt26.setText(String.valueOf(f.MatrizSolucion[2][6]));
        txt27.setText(String.valueOf(f.MatrizSolucion[2][7]));
        txt28.setText(String.valueOf(f.MatrizSolucion[2][8]));
        txt30.setText(String.valueOf(f.MatrizSolucion[3][0]));
        txt31.setText(String.valueOf(f.MatrizSolucion[3][1]));
        txt32.setText(String.valueOf(f.MatrizSolucion[3][2]));
        txt33.setText(String.valueOf(f.MatrizSolucion[3][3]));
        txt34.setText(String.valueOf(f.MatrizSolucion[3][4]));
        txt35.setText(String.valueOf(f.MatrizSolucion[3][5]));
        txt36.setText(String.valueOf(f.MatrizSolucion[3][6]));
        txt37.setText(String.valueOf(f.MatrizSolucion[3][7]));
        txt38.setText(String.valueOf(f.MatrizSolucion[3][8]));
        txt40.setText(String.valueOf(f.MatrizSolucion[4][0]));
        txt41.setText(String.valueOf(f.MatrizSolucion[4][1]));
        txt42.setText(String.valueOf(f.MatrizSolucion[4][2]));
        txt43.setText(String.valueOf(f.MatrizSolucion[4][3]));
        txt44.setText(String.valueOf(f.MatrizSolucion[4][4]));
        txt45.setText(String.valueOf(f.MatrizSolucion[4][5]));
        txt46.setText(String.valueOf(f.MatrizSolucion[4][6]));
        txt47.setText(String.valueOf(f.MatrizSolucion[4][7]));
        txt48.setText(String.valueOf(f.MatrizSolucion[4][8]));
        txt50.setText(String.valueOf(f.MatrizSolucion[5][0]));
        txt51.setText(String.valueOf(f.MatrizSolucion[5][1]));
        txt52.setText(String.valueOf(f.MatrizSolucion[5][2]));
        txt53.setText(String.valueOf(f.MatrizSolucion[5][3]));
        txt54.setText(String.valueOf(f.MatrizSolucion[5][4]));
        txt55.setText(String.valueOf(f.MatrizSolucion[5][5]));
        txt56.setText(String.valueOf(f.MatrizSolucion[5][6]));
        txt57.setText(String.valueOf(f.MatrizSolucion[5][7]));
        txt58.setText(String.valueOf(f.MatrizSolucion[5][8]));
        txt60.setText(String.valueOf(f.MatrizSolucion[6][0]));
        txt61.setText(String.valueOf(f.MatrizSolucion[6][1]));
        txt62.setText(String.valueOf(f.MatrizSolucion[6][2]));
        txt63.setText(String.valueOf(f.MatrizSolucion[6][3]));
        txt64.setText(String.valueOf(f.MatrizSolucion[6][4]));
        txt65.setText(String.valueOf(f.MatrizSolucion[6][5]));
        txt66.setText(String.valueOf(f.MatrizSolucion[6][6]));
        txt67.setText(String.valueOf(f.MatrizSolucion[6][7]));
        txt68.setText(String.valueOf(f.MatrizSolucion[6][8]));
        txt70.setText(String.valueOf(f.MatrizSolucion[7][0]));
        txt71.setText(String.valueOf(f.MatrizSolucion[7][1]));
        txt72.setText(String.valueOf(f.MatrizSolucion[7][2]));
        txt73.setText(String.valueOf(f.MatrizSolucion[7][3]));
        txt74.setText(String.valueOf(f.MatrizSolucion[7][4]));
        txt75.setText(String.valueOf(f.MatrizSolucion[7][5]));
        txt76.setText(String.valueOf(f.MatrizSolucion[7][6]));
        txt77.setText(String.valueOf(f.MatrizSolucion[7][7]));
        txt78.setText(String.valueOf(f.MatrizSolucion[7][8]));
        txt80.setText(String.valueOf(f.MatrizSolucion[8][0]));
        txt81.setText(String.valueOf(f.MatrizSolucion[8][1]));
        txt82.setText(String.valueOf(f.MatrizSolucion[8][2]));
        txt83.setText(String.valueOf(f.MatrizSolucion[8][3]));
        txt84.setText(String.valueOf(f.MatrizSolucion[8][4]));
        txt85.setText(String.valueOf(f.MatrizSolucion[8][5]));
        txt86.setText(String.valueOf(f.MatrizSolucion[8][6]));
        txt87.setText(String.valueOf(f.MatrizSolucion[8][7]));
        txt88.setText(String.valueOf(f.MatrizSolucion[8][8]));
        jButton4.setEnabled(false);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:}
        //Medoto para Sugerir Ayuda;
        for (int i = 0; i < f.MatrizZudo.length; i++) {
            for (int j = 0; j < f.MatrizZudo.length; j++) {
                if (f.MatrizZudo[i][j] == 0) {
                    JOptionPane.showMessageDialog(null, "en la fila " + (i+1) + " columna " + (j+1) + " pon el numero " + f.MatrizSolucion[i][j]);
                    break;
                }
                if (j == 8) {
                    i++;
                    j=0;

                }

            }

            break;
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        f.HistorialJugada.clear();
       txt00.setText(String.valueOf(f.MatrizZudo[0][0]));
        txt01.setText(String.valueOf(f.MatrizZudo[0][1]));
        txt02.setText("");
        txt03.setText("");
        txt04.setText(String.valueOf(f.MatrizZudo[0][4]));
        txt05.setText(String.valueOf(f.MatrizZudo[0][5]));
        txt06.setText("");
        txt07.setText("");
        txt08.setText(String.valueOf(f.MatrizZudo[0][8]));
        txt10.setText(String.valueOf(f.MatrizZudo[1][0]));
        txt11.setText("");
        txt12.setText(String.valueOf(f.MatrizZudo[1][2]));
        txt13.setText("");
        txt14.setText(String.valueOf(f.MatrizZudo[1][4]));
        txt15.setText("");
        txt16.setText(String.valueOf(f.MatrizZudo[1][6]));
        txt17.setText(String.valueOf(f.MatrizZudo[1][7]));
        txt18.setText(String.valueOf(f.MatrizZudo[1][8]));
        txt20.setText("");
        txt21.setText(String.valueOf(f.MatrizZudo[2][1]));
        txt22.setText(String.valueOf(f.MatrizZudo[2][2]));
        txt23.setText("");
        txt24.setText("");
        txt25.setText("");
        txt26.setText("");
        txt27.setText("");
        txt28.setText("");
        txt30.setText(String.valueOf(f.MatrizZudo[3][0]));
        txt31.setText(String.valueOf(f.MatrizZudo[3][1]));
        txt32.setText(String.valueOf(f.MatrizZudo[3][2]));
        txt33.setText("");
        txt34.setText(String.valueOf(f.MatrizZudo[3][4]));
        txt35.setText(String.valueOf(f.MatrizZudo[3][5]));
        txt36.setText("");
        txt37.setText(String.valueOf(f.MatrizZudo[3][7]));
        txt38.setText(String.valueOf(f.MatrizZudo[3][8]));
        txt40.setText("");
        txt41.setText("");
        txt42.setText("");
        txt43.setText("");
        txt44.setText("");
        txt45.setText("");
        txt46.setText("");
        txt47.setText("");
        txt48.setText("");
        txt50.setText(String.valueOf(f.MatrizZudo[5][0]));
        txt51.setText("");
        txt52.setText(String.valueOf(f.MatrizZudo[5][2]));
        txt53.setText("");
        txt54.setText(String.valueOf(f.MatrizZudo[5][4]));
        txt55.setText(String.valueOf(f.MatrizZudo[5][5]));
        txt56.setText("");
        txt57.setText(String.valueOf(f.MatrizZudo[5][7]));
        txt58.setText(String.valueOf(f.MatrizZudo[5][8]));
        txt60.setText("");
        txt61.setText("");
        txt62.setText("");
        txt63.setText("");
        txt64.setText("");
        txt65.setText(String.valueOf(f.MatrizZudo[6][5]));
        txt66.setText("");
        txt67.setText(String.valueOf(f.MatrizZudo[6][7]));
        txt68.setText("");
        txt70.setText("");
        txt71.setText("");
        txt72.setText(String.valueOf(f.MatrizZudo[7][2]));
        txt73.setText("");
        txt74.setText(String.valueOf(f.MatrizZudo[7][4]));
        txt75.setText("");
        txt76.setText("");
        txt77.setText("");
        txt78.setText("");
        txt80.setText(String.valueOf(f.MatrizZudo[8][0]));
        txt81.setText("");
        txt82.setText(String.valueOf(f.MatrizZudo[8][2]));
        txt83.setText("");
        txt84.setText(String.valueOf(f.MatrizZudo[8][4]));
        txt85.setText("");
        txt86.setText(String.valueOf(f.MatrizZudo[8][6]));
        txt87.setText(String.valueOf(f.MatrizZudo[8][7]));
        txt88.setText(String.valueOf(f.MatrizZudo[8][8]));
       jButton4.setEnabled(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(f.CompararResultado()){
            JOptionPane.showMessageDialog(null, "Sudoku Completado con exito");
        }else{
            JOptionPane.showMessageDialog(null, "Sudoku Tiene Errores");
        }
        
   

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyReleased
        // TODO add your handling code here:
   
    }//GEN-LAST:event_jButton5KeyReleased

    private void txt02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt02ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt02ActionPerformed

    private void txt40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt40ActionPerformed

    private void txt62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt62ActionPerformed
        // TODO add your handling code here:
         int con = 0;
        if (f.comprobar_valor((txt62.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt62.getText()), 6)) {
                error.setText("el numero " + txt62.getText() + " ya esta en la fila");
                txt62.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt62.getText()), 2)) {
                    error.setText("el numero " + txt62.getText() + " ya esta en la columna");
                    txt62.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt62.getText()), 6, 2)) {
                        error.setText("el numero " + txt62.getText() + " ya esta en la caja");
                        txt62.setText("");
                    } else {
                        f.MatrizZudo[6][2] = Integer.valueOf(txt62.getText());
                        f.HistorialPartidas(f.MatrizZudo[6][2]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt62.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[6][2] = 0;
        }
    }//GEN-LAST:event_txt62ActionPerformed

    private void txt61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt61ActionPerformed
        // TODO add your handling code here:
        int con = 0;
        if (f.comprobar_valor((txt61.getText()))) {
            if (f.existe_fila(Integer.valueOf(txt61.getText()), 6)) {
                error.setText("el numero " + txt61.getText() + " ya esta en la fila");
                txt61.setText("");
            } else {
                if (f.existe_columna(Integer.valueOf(txt61.getText()), 1)) {
                    error.setText("el numero " + txt61.getText() + " ya esta en la columna");
                    txt61.setText("");
                } else {

                    if (f.existe_caja(Integer.valueOf(txt61.getText()), 6, 1)) {
                        error.setText("el numero " + txt61.getText() + " ya esta en la caja");
                        txt61.setText("");
                    } else {
                        f.MatrizZudo[6][1] = Integer.valueOf(txt61.getText());
                        f.HistorialPartidas(f.MatrizZudo[6][1]);
                           TxtHistorialJ.setText( f.mostrarjugadas());
                        error.setText("");
                        con++;
                    }
                }
            }
        } else {
            txt61.setText("");
        }
        if (con == 0) {
            f.MatrizZudo[6][1] = 0;
        }
    }//GEN-LAST:event_txt61ActionPerformed

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TxtHistorialJ;
    private javax.swing.JLabel error;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel mostrarNick;
    private javax.swing.JTextField txt00;
    private javax.swing.JTextField txt01;
    private javax.swing.JTextField txt02;
    private javax.swing.JTextField txt03;
    private javax.swing.JTextField txt04;
    private javax.swing.JTextField txt05;
    private javax.swing.JTextField txt06;
    private javax.swing.JTextField txt07;
    private javax.swing.JTextField txt08;
    private javax.swing.JTextField txt10;
    private javax.swing.JTextField txt11;
    private javax.swing.JTextField txt12;
    private javax.swing.JTextField txt13;
    private javax.swing.JTextField txt14;
    private javax.swing.JTextField txt15;
    private javax.swing.JTextField txt16;
    private javax.swing.JTextField txt17;
    private javax.swing.JTextField txt18;
    private javax.swing.JTextField txt20;
    private javax.swing.JTextField txt21;
    private javax.swing.JTextField txt22;
    private javax.swing.JTextField txt23;
    private javax.swing.JTextField txt24;
    private javax.swing.JTextField txt25;
    private javax.swing.JTextField txt26;
    private javax.swing.JTextField txt27;
    private javax.swing.JTextField txt28;
    private javax.swing.JTextField txt30;
    private javax.swing.JTextField txt31;
    private javax.swing.JTextField txt32;
    private javax.swing.JTextField txt33;
    private javax.swing.JTextField txt34;
    private javax.swing.JTextField txt35;
    private javax.swing.JTextField txt36;
    private javax.swing.JTextField txt37;
    private javax.swing.JTextField txt38;
    private javax.swing.JTextField txt40;
    private javax.swing.JTextField txt41;
    private javax.swing.JTextField txt42;
    private javax.swing.JTextField txt43;
    private javax.swing.JTextField txt44;
    private javax.swing.JTextField txt45;
    private javax.swing.JTextField txt46;
    private javax.swing.JTextField txt47;
    private javax.swing.JTextField txt48;
    private javax.swing.JTextField txt50;
    private javax.swing.JTextField txt51;
    private javax.swing.JTextField txt52;
    private javax.swing.JTextField txt53;
    private javax.swing.JTextField txt54;
    private javax.swing.JTextField txt55;
    private javax.swing.JTextField txt56;
    private javax.swing.JTextField txt57;
    private javax.swing.JTextField txt58;
    private javax.swing.JTextField txt60;
    private javax.swing.JTextField txt61;
    private javax.swing.JTextField txt62;
    private javax.swing.JTextField txt63;
    private javax.swing.JTextField txt64;
    private javax.swing.JTextField txt65;
    private javax.swing.JTextField txt66;
    private javax.swing.JTextField txt67;
    private javax.swing.JTextField txt68;
    private javax.swing.JTextField txt70;
    private javax.swing.JTextField txt71;
    private javax.swing.JTextField txt72;
    private javax.swing.JTextField txt73;
    private javax.swing.JTextField txt74;
    private javax.swing.JTextField txt75;
    private javax.swing.JTextField txt76;
    private javax.swing.JTextField txt77;
    private javax.swing.JTextField txt78;
    private javax.swing.JTextField txt80;
    private javax.swing.JTextField txt81;
    private javax.swing.JTextField txt82;
    private javax.swing.JTextField txt83;
    private javax.swing.JTextField txt84;
    private javax.swing.JTextField txt85;
    private javax.swing.JTextField txt86;
    private javax.swing.JTextField txt87;
    private javax.swing.JTextField txt88;
    // End of variables declaration//GEN-END:variables
}
