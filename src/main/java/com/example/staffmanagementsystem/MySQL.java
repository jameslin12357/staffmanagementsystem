package com.example.staffmanagementsystem;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MySQL {

    public static ArrayList<HashMap<String, Object>> Query(String SQL)
    {
        //ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        ArrayList<HashMap<String, Object>> rows = new ArrayList<HashMap<String, Object>>();

        try{
            //step1 load the driver class
            Class.forName("com.mysql.jdbc.Driver");

            //step2 create the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/staffmanagementsystem","root","1");

            //step3 create the statement object
            Statement stmt=con.createStatement();

            //step4 execute query
            ResultSet rs=stmt.executeQuery(SQL);
            System.out.println(rs);
            ResultSetMetaData rsmd = rs.getMetaData();
            int cc = rsmd.getColumnCount();
            while(rs.next()){
                //ArrayList<String> row = new ArrayList<String>();
                HashMap<String, Object> row = new HashMap<String, Object>();
                for (int i = 1; i < cc + 1; i++){
                    String colName = rsmd.getColumnName(i);
                    String col = rs.getString(i);
                    row.put(colName, col);
                }
                rows.add(row);
            }

            //step5 close the connection object
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return rows;
    }

    public static int Update(String SQL)
    {
        //ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        //ArrayList<HashMap<String, Object>> rows = new ArrayList<HashMap<String, Object>>();
        int rows = 0;
        try{
            //step1 load the driver class
            Class.forName("com.mysql.jdbc.Driver");

            //step2 create the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/staffmanagementsystem","root","1");

            //step3 create the statement object
            Statement stmt=con.createStatement();

            //step4 execute query

            rows = stmt.executeUpdate(SQL);
            /*System.out.println(rs);
            ResultSetMetaData rsmd = rs.getMetaData();
            int cc = rsmd.getColumnCount();
            while(rs.next()){
                //ArrayList<String> row = new ArrayList<String>();
                HashMap<String, Object> row = new HashMap<String, Object>();
                for (int i = 1; i < cc + 1; i++){
                    String colName = rsmd.getColumnName(i);
                    String col = rs.getString(i);
                    row.put(colName, col);
                }
                rows.add(row);
            }
            */
            //step5 close the connection object
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return rows;
    }


    public static String QueryInJSON(String SQL)
    {
        //ArrayList<HashMap<String,String>> rows = new ArrayList<HashMap<String,String>>();
        String JSON = "[";
        try{
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:sc","john","pudong");

            //step3 create the statement object
            Statement stmt=con.createStatement();

            //step4 execute query
            ResultSet rs=stmt.executeQuery(SQL);
            ResultSetMetaData rsmd = rs.getMetaData();

            int cc = rsmd.getColumnCount();
            while(rs.next()){
                //HashMap<String,String> row = new HashMap<String,String>();
                String obj = "{";
                for (int i = 1; i < cc + 1; i++){
                    String colName = rsmd.getColumnName(i);
                    String col = rs.getString(i);
                    obj = obj + "\"" + colName + "\":" + "\"" + col + "\"";
                    if (i != cc){
                        obj = obj + ",";
                    }
                    //row.put(colName,col);
                }
                obj = obj + "},";
                JSON += obj;

                //rows.add(row);
            }
            JSON = JSON.substring(0, JSON.length()-1);
            JSON = JSON + "]";

            //step5 close the connection object
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return JSON;
    }
}