/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Classes.Validations;
import Classes.Utilities;
//import static Classes.Utilities.getBuffered;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author Administrador
 */
public class ValidationsTest {
    
    public Validations validations;
    public Utilities utilities;
    
    @BeforeEach
    public void setUp(){
        validations = new Validations();
        utilities = new Utilities();
    }
    
    @DisplayName("Hola soy un test1")
    @Test
    public void test1(){
        try {
//            String url = "src\\main\\java\\Resource\\data.json";
//            Assertions.assertSame(getBuffered(url), new BufferedReader(new FileReader(url)));
//            Assertions.assertNotEquals(Short.MAX_VALUE, Short.MAX_VALUE -1);
//            Assertions.assertFalse(false);
                
        } catch (Exception e) {
        }
        
    }
}
