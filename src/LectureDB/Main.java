/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LectureDB;

import java.sql.SQLException;

/**
 *
 * @author Danny
 */
public class Main {
    public static void main(String[] args) throws SQLException{
        //new DAO().add("David", 64, "Goliaf");
        //new DAO().show();
        //new DAO().delete(3);
        new DAO().check("Sinicin", "Rn5");
        //new DAO().show();
    }
}
