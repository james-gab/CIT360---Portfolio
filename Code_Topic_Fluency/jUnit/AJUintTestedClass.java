/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingJUnit;

import java.util.Scanner;

/**
 *
 * @author gab
 */
public class AJUintTestedClass {

    
    Scanner userInput = new Scanner(System.in);

    
    public void main(String[] args){
    
        theTest();
        
    }
    
    private void theTest(){
        Integer c = 3;
        
        System.out.println("Please enter A: ");
        String a = userInput.nextLine();
        System.out.println("Please enter B: ");
        String b = userInput.nextLine();

        
        
        System.out.println("The product of 1 + 2 x 3 is: " + testIT(Integer.parseInt(a),Integer.parseInt(b),c));
    
    }
    
    static int testIT(int a, int b, int c){
        
        return a + b * c;
        
    }
    
}
