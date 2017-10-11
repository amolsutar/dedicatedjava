/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static javaapplication3.DateMonthDiffJava.monthsBetween;

/**
 *
 * @author Administrator
 */
public class permisionPk {

    static Connection connection = null;

    public static void getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://115.124.97.239:5432/Building_Permission_Dept", "postgres", "dtech@123");
            //"jdbc:postgresql://localhost:5432/Building_Permission_Dept", "postgres", "dtech@123");
            String query = "SELECT * From building_permission_table";
            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String stage = rs.getString("status");
                System.out.println("stage ==>" + stage);

                Date date = rs.getDate("entrydate");
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String start = df.format(date);
                System.out.println("start :" + start);

                java.util.Date currentdate = Calendar.getInstance().getTime();
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String end = formatter.format(currentdate);
                System.out.println("end :" + end);

                DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                int differenceMonth = DateMonthDiffJava.monthsBetween(sdf.parse(start), sdf.parse(end));
                System.out.println(" Months Difference \n " + differenceMonth);
                if (stage.equalsIgnoreCase("open")) {
                    if (differenceMonth == 0) {
                        rs.updateString("pendingappduration1month", "1");
                        rs.updateString("pendingappduration2month", "0");
                        rs.updateString("pendingappduration3month", "0");
                        rs.updateString("pendingappdurationmorethan3month", "0");
                        rs.updateRow();
                        //st1.execute("UPDATE building_permission_table SET pendingappduration1month='1'");
                    } else if (differenceMonth == 1) {
                        rs.updateString("pendingappduration1month", "0");
                        rs.updateString("pendingappduration2month", "1");
                        rs.updateString("pendingappduration3month", "0");
                        rs.updateString("pendingappdurationmorethan3month", "0");
                        rs.updateRow();
                        //st2.execute("UPDATE building_permission_table SET pendingappduration2month='1'");
                    } else if (differenceMonth == 2) {
                        rs.updateString("pendingappduration1month", "0");
                        rs.updateString("pendingappduration2month", "0");
                        rs.updateString("pendingappduration3month", "1");
                        rs.updateString("pendingappdurationmorethan3month", "0");
                        rs.updateRow();
                        //st3.execute("UPDATE building_permission_table SET pendingappduration3month='1'");
                    } else if (differenceMonth >= 3) {
                        rs.updateString("pendingappduration1month", "0");
                        rs.updateString("pendingappduration2month", "0");
                        rs.updateString("pendingappduration3month", "0");
                        rs.updateString("pendingappdurationmorethan3month", "1");
                        rs.updateRow();
                        //st4.execute("UPDATE building_permission_table SET pendingappdurationmorethan3month='1'");
                    }
                } else {
                    rs.updateString("pendingappduration1month", "0");
                    rs.updateString("pendingappduration2month", "0");
                    rs.updateString("pendingappduration3month", "0");
                    rs.updateString("pendingappdurationmorethan3month", "1");
                    rs.updateRow();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        getConnection();
    }

}
