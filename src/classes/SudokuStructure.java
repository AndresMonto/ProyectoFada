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
    public Point Coordinate;

    public SudokuStructure(JTextField Input, Point Coordinate) {
        this.Input = Input;
        this.Coordinate = Coordinate;
    }
    
}