/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Chapitres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hajer
 */
public class DaoChapitres extends Dao<Chapitres> {

    Connection cnx;

    public DaoChapitres() {
        cnx = getCon();
    }

    @Override
    public int add(Chapitres c) {

        try {

            String titre = c.getTitre();

            String requete = "insert into chapitres (titre) values(?)";

            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, "" + titre);
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("|| Execption ||");
        }
        System.out.println("insertion de chapitre :" + c.toString());
        return 0;
    }

    @Override
    public ArrayList<Chapitres> getMyList() {

        ArrayList<Chapitres> listChapitres = new ArrayList<>();

        try {

            String requete = "select * from chapitres ";
            Statement ps = cnx.createStatement();
            ResultSet rs = ps.executeQuery(requete);

            while (rs.next()) {
                Chapitres chap = new Chapitres(rs.getInt("id"), rs.getString("titre"));
                listChapitres.add(chap);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Execption");
        }

        return listChapitres;
    }

    @Override
    public void delete(int idObj) {
        try {

            String requete = "delete from chapitres where id=?";

            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, "" + idObj);
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("|| Execption ||");
        }
        System.out.println("chapitre de id= " + idObj + "bien supprime");
    }

    @Override
    public Chapitres find(int id) {
        Chapitres chap = new Chapitres();

        try {
            String titre = "";

            String requete = "select * from chapitres where (id) = ? ";
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, "" + id);
            ps.execute();

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                titre = rs.getString(2);
            }

            chap.setId(id);
            chap.setTitre(titre);

            ps.close();
            System.out.println("chapitre bien trouvee :" +chap);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Execption");
        }
        return chap;

    }

}
