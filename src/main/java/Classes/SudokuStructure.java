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
    
    public JTextField input;
    public String prevValue;
    public Point coordinate;
    public boolean defaultValue;

    public SudokuStructure(JTextField input,String prevValue, Point coordinate, boolean defaultValue) {
        this.input = input;
        this.prevValue = prevValue;
        this.coordinate = coordinate;
        this.defaultValue = defaultValue;
    }
    
}
