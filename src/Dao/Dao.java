/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Chapitres;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hajer
 */
public abstract class Dao<T> {

    Connection con;

    public Dao() {
        con = MySingleton.connexion();

    }

    public Connection getCon() {
        return con;
    }

    public abstract int add(T c);

    public abstract T find(int id);

    public abstract ArrayList<T> getMyList();
//   public abstract T update(int id);

    public abstract void delete(int idObj);

}
