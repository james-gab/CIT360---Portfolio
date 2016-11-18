/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gab
 * 
 * Sandbox CODE!!!!!
 * 
 */

public class ThreadsRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World");
    }
    
    public static void main(String args[]){
        (new Thread(new ThreadsRun())).start();
        
    }
    
    
    
}
