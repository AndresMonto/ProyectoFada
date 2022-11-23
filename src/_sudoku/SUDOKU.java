
package sudoku;

public class SUDOKU {


    public static void main(String[] args) {
       Portada portada = new Portada();
       portada.setVisible(true);
       Ingreso ingreso = new Ingreso();
       
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(0);
               portada.Cargador.setText(Integer.toString(i) + "%");
               portada.progreso.setValue(i);
            }
            portada.setVisible(false);
            ingreso.setVisible(true);
        } catch (Exception e) {
        }
    }
    
}
