/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hajer
 */
public class MySingleton {
    
    private static Connection cnx;

    public MySingleton() {
    }
    
    
    
     public static Connection connexion(){
         if(cnx==null){
        String serveurBD = "jdbc:mysql://127.0.0.1:3306/bd_qcm?autoReconnect=true&useSSL=false";
		String login = "root";
		String motPasse = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnx = DriverManager.getConnection(serveurBD, login, motPasse);
              
                } catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
         }
    
    return cnx;
    }
}
