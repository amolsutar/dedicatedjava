/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Synch {

    public static void main(String args[]) {

        Callme target = new Callme();
        Caller ob1 = new Caller("Hello", target);
        Caller ob2 = new Caller("Synchronized", target);
        Caller ob3 = new Caller("World", target);
        
        try {
            //wait for threads to end
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Synch.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}
