/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class DateMonthDiffJava {
    
    static int monthsBetween(Date a, Date b) {
    Calendar cal = Calendar.getInstance();
    if (a.before(b)) {
        cal.setTime(a);
    } else {
        cal.setTime(b);
        b = a;
    }
    int c = 0;
    while (cal.getTime().before(b)) {
        cal.add(Calendar.MONTH, 1);
        c++;
    }
    return c - 1;
}
    
    public static void main(String[] args) {
    String start = "30/08/2017";
    String end = "09/10/2017";
    DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    try {
        System.out.println(monthsBetween(sdf.parse(start), sdf.parse(end)));
    } catch (ParseException e) {
        e.printStackTrace();
    }
}
    
}
