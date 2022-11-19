
package sudoku;


public class Portada extends javax.swing.JFrame {


    public Portada() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cargador = new javax.swing.JLabel();
        progreso = new javax.swing.JProgressBar();
        imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(310, 200));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cargador.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        Cargador.setText("0%");
        getContentPane().add(Cargador, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, 30, 40));

        progreso.setBackground(new java.awt.Color(0, 0, 0));
        progreso.setForeground(new java.awt.Color(255, 255, 0));
        progreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(progreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 680, 10));

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descarga.jpg")));
        getContentPane().add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Portada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Cargador;
    private javax.swing.JLabel imagen;
    public static javax.swing.JProgressBar progreso;
    // End of variables declaration//GEN-END:variables
}
