/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package empmgmt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author abc
 */
public class DBConnection {
private static Connection conn;
static{
    try{
        Class.forName("oracle.jdbc.OracleDriver");
        conn=DriverManager.getConnection("jdbc:oracle:thin:@//shubham-pc:1521/xe","employee","employee");
         JOptionPane.showMessageDialog(null, "Connected Successfully to DB","Success!!!",JOptionPane.INFORMATION_MESSAGE);
     }
    catch(Exception ex){
      JOptionPane.showMessageDialog(null, "Cannot Connect to DB!!!!","DB ERROR!!!!!!",JOptionPane.ERROR_MESSAGE);
      ex.printStackTrace();
      System.exit(1);
    }
  }
public static Connection getConnection(){
return conn;
}

public static void closeConnection(){
  try{
  conn.close();
  JOptionPane.showMessageDialog(null, "Disconnected Successfully to DB","Success!!!",JOptionPane.INFORMATION_MESSAGE);
  }
   catch(SQLException ex){
    JOptionPane.showMessageDialog(null, "Cannot Disconnect to DB","DB ERROR!!!",JOptionPane.ERROR_MESSAGE);
    ex.printStackTrace();
   }
}
  
}
