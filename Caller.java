/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author Administrator
 */
public class Caller implements Runnable {

    String msg;
    Callme target;
    Thread t;

    public Caller(String msg, Callme target) {
        this.msg = msg;
        this.target = target;
        t = new Thread(this);
        t.start();
    }
    
    @Override    
    public void run() {
        target.call(msg);
    }
    
    
}
