/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.calculator.Calculator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Наташа
 */
public class NewTest {
    private Calculator calc;
    public NewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        calc = new Calculator();
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void divNZ(){
        assertTrue(calc.div(24, 12) == 2);
    }
    @Test
    public void mulTest(){
        assertTrue(calc.mul(45, 15) == 675);
    }
    @Test(expected = ArithmeticException.class)
    public void divZero(){
        calc.div(12,0);
    }
    
    @Test
    public void addT(){
        assertTrue(calc.add(56, 45) == 101);
    }
    @Test
    public void subT(){
        assertTrue(calc.sub(56, 12) == 44);
    }
    
}
