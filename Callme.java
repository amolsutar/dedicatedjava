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
public class Callme {
    synchronized void call(String msg){
        System.out.println("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Callme.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("]");
        
    }
}
