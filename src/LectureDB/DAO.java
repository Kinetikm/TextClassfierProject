/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LectureDB;

import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Danny
 */
public class DAO {

    Connection connection = new Connector().link();

    public void show() throws SQLException {
        Statement State = null;//Simple inquiry without argument
        State = connection.createStatement();
        ResultSet res = State.executeQuery("Select user.id, user.Login, user.Age, password.LoginId ,password.password from user , password");
        while (res.next()) {
            System.out.println("Номер в выборке #" + res.getRow()
                    + "\t Номер в базе #" + res.getInt("id")
                    + "\t" + res.getString("Login")
                    + "\t" + res.getString("Age")
                    + "\t" + res.getString("LoginId")
                    + "\t" + res.getString("password"));
        }
    }

    public void add(String login, int age, String password) throws SQLException {
        Statement State = null;
        State = connection.createStatement();
        State.execute("INSERT INTO user (`Login`,`Age`) values ('" + login + "','" + age + "')");
        ResultSet res = State.executeQuery("select  max(id) from user");
        int maxid = 0;
        if (res.next()) {
            maxid = res.getInt("max(id)");
        }
        State.execute("insert into password (`LoginId`,`Password`) values ('" + maxid + "','" + password + "')");
    }

    public void delete(int num) throws SQLException {
        Statement State = null;
        State = connection.createStatement();
        ResultSet res = State.executeQuery("select  id from user where id=" + num);
        int id = 0;
        if (res.next()) {
            id = res.getInt("id");
        }
        State.execute("delete from user where id=" + num);
        State.execute("delete from password where LoginId=" + num);
    }

    public void check(String login, String password) throws SQLException {
        Statement State = null;
        State = connection.createStatement();
        ResultSet res = State.executeQuery("select  Login from user where Login='" + login+"'");
        String log = null;
        if (res.next()) {
            log = res.getString("Login");
        }
        if(log==null){
            System.out.println("Not exist");
            System.exit(0);
        }
        System.out.println(log);
        res = State.executeQuery("select  Password from password where Password='" + password+"'");
        log=null;
        if (res.next()) {
            log = res.getString("Password");
        }
        if(log==null){
            System.out.println("Not exist");
            System.exit(0);
        }
        System.out.println(log);
        res = State.executeQuery("select * from user, password where user.Login='"+login+"' and password.Password='"+password+"'");
        while (res.next()) {
            System.out.println("Номер в выборке #" + res.getRow()
                    + "\t Номер в базе #" + res.getInt("id")
                    + "\t" + res.getString("Login")
                    + "\t" + res.getString("Age")
                    + "\t" + res.getString("LoginId")
                    + "\t" + res.getString("password"));
        }
    }
}
