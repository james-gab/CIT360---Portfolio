/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingJUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gab
 */
public class AJUintTestedClassIT {
    
    public AJUintTestedClassIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class AJUintTestedClass.
     */
    @Test
    public void testMain1() {
        System.out.println("updateTheUser");
        Integer c = 3;
        Integer a = 1;
        Integer b = 2;
        int expResult = 7;
        int result = AJUintTestedClass.testIT(a, b, c);
        assertEquals(expResult, result);
    }
    
    public void testMain2() {
        System.out.println("updateTheUser");
        Integer a = 2;
        Integer b = 3;
        Integer c = 4;
        int expResult = 14;
        int result = AJUintTestedClass.testIT(a, b, c);
        assertEquals(expResult, result);
    }
    
    public void testMain3() {
        System.out.println("updateTheUser");
        Integer a = 10;
        Integer b = 20;
        Integer c = 30;
        int expResult = 610;
        int result = AJUintTestedClass.testIT(a, b, c);
        assertEquals(expResult, result);
    }
    
}
