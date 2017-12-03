/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Наташа
 */
public class DataBase {
    public static Connection conn;
    public static Statement state;
   // private static int id;
    public static ResultSet rs;
    
  private static void connect() {
      try {
          Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException ex) {
          System.out.println("Can't find this class.");
      }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banan", "root", "4444");
            state = conn.createStatement();
            conn.setAutoCommit(false);
            
        } catch (SQLException ex) {
            System.out.println("Excepion connection");
        }
      
  }
  
  public static void createTable() {
      connect();
        try {
            state.execute("CREATE TABLE user(id int PRIMARY KEY NOT NULL, login varchar(15), age int NOT NULL);");
            state.execute("CREATE TABLE passward (idPas int PRIMARY KEY NOT NULL, pass varchar(8));");
            conn.commit();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Exception creation");
          try {
              conn.rollback();
              conn.close();
          } catch (SQLException ex1) {
              System.out.println("Exeption rollback");
          }
        }
  }
  
  public static void addElement(String name, int age, String pas) {
      connect();
        try {
            state.executeUpdate("INSERT INTO user (login, age) VALUES ('"+name+"', '"+age+"')");
            state.executeUpdate("INSERT INTO passward (pass) values ( '"+pas+"')");
            conn.commit();
            conn.close();
            System.out.println("Success!!");
        } catch (SQLException ex) {
            System.out.println("Element wasn't added");
          try {
              conn.rollback();
              conn.close();
          } catch (SQLException ex1) {
          }
        }

      
  }
  
  public static void delete (String name) {
      connect();
      int idF = 0;
        try {
            rs = state.executeQuery("SELECT * FROM user WHERE login = '"+name+"'");
            if (rs != null) {
                while (rs.next()) {
                    idF = rs.getInt("id");
                }
                state.executeUpdate("DELETE FROM user WHERE login = '"+name+"'");
                state.execute("DELETE FROM passward WHERE idPas = "+idF+"");
            }
            else {
                System.out.println("There is no user with this login");
            }
            conn.commit();
            conn.close();
            System.out.println("User was deleted");
        } catch (SQLException ex) {
            System.out.println("You can't delete it");
          try {
              conn.rollback();
              conn.close();
          } catch (SQLException ex1) {
              System.out.println("You didn't delete this element");         
          }  
        }
  }
  
  public static void checkUser(String log, String pass) {
      int idPa=0;
      String pass2 = null;
      connect();
        try {
            rs = state.executeQuery("SELECT * FROM user WHERE login = '"+log+"';");
            if (rs != null) {
            while(rs.next()) {
                System.out.println(rs.getInt("id"));
                idPa = rs.getInt("id");
            }
            rs = state.executeQuery("SELECT pass FROM passward WHERE idPas = '"+idPa+"';");
            while (rs.next())
                pass2 = rs.getString("pass");
            if (pass.equals(pass2)) {
                System.out.println("There is this user. Passward is right");  
            }
            else {
                System.out.println("Passward isn't right");
            }
            }
            else {
                System.out.println("There is no user with this name");
            }
            conn.commit();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Exception one");
          try {
              conn.rollback();
              conn.close();
          } catch (SQLException ex1) {
              System.out.println("Cannot rollback");
          } 
        }
      
  }
  
  public static void result() {
      connect();
        try {
            rs = state.executeQuery("SELECT * FROM user");
            while (rs.next()) {
                System.out.print(rs.getInt("id") + " ");
                System.out.print(rs.getString("login") + " ");
                System.out.println(rs.getInt("age") + " ");
            }
            conn.commit();
            conn.close();
        } catch (SQLException ex) {
          try {
              conn.rollback();
              conn.close();
          } catch (SQLException ex1) {
          }
        }
      
  }
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
    }
    
}
