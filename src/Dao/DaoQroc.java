/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Qroq;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author hajer
 */
public class DaoQroc extends Dao<Qroq> {

    Connection cnx;

    public DaoQroc() {
        cnx = getCon();
    }

    @Override
    public int add(Qroq c) {
        int qrocID = 0;
        try {

            String[] motCles = c.getMotcles();
           
            String requete = "insert into qroc (motCles) values(?)";

            PreparedStatement ps = cnx.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, String.join(";", motCles));

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                qrocID = (int) rs.getLong(1);
            }

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("|| Execption ||");
        }
        System.out.println("Qroc bien ajoute :" + c.toString() + "avec id =" + qrocID);

        return qrocID;

    }

    @Override
    public ArrayList<Qroq> getMyList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int idObj) {
        try {

            String requete = "delete from qroc where id=?";

            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, "" + idObj);
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("|| Execption ||");
        }
        System.out.println("qroc de id= " + idObj + "bien supprime");
    }

    @Override
    public Qroq find(int id) {
        Qroq qroc = new Qroq();
        String[] motCles = new String[0];

        try {

            String requete = "select * from qroc where idQroc = ? ";
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, "" + id);
            ps.execute();

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String mots = rs.getString(2);

                motCles = mots.split(";");

               
            }

            qroc.setMotcles(motCles);

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Execption");
        }
        return qroc;

    }

}
