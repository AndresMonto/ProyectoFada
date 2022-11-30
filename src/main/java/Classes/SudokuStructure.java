/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.awt.Point;
import javax.swing.JTextField;

/**
 *
 * @author Administrador
 */
public class SudokuStructure {
    
    public JTextField Input;
    public String PrevValue;
    public Point Coordinate;
    public boolean Default;

    public SudokuStructure(JTextField Input,String PrevValue, Point Coordinate, boolean Default) {
        this.Input = Input;
        this.PrevValue = PrevValue;
        this.Coordinate = Coordinate;
        this.Default = Default;
    }
    
}
