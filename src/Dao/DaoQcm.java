/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Qcm;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hajer
 */
public class DaoQcm extends Dao<Qcm> {

    Connection cnx;

    public DaoQcm() {
        cnx = getCon();
    }

    @Override
    public int add(Qcm c) {
        int qcmID = 0;
        try {

            String[] myprops = c.getPropositions();
            String correctOne = "";
            Boolean[] propsCorrect = c.getProCorrect();

            if (propsCorrect[0] == true) {
                correctOne = myprops[0];
            } else if (propsCorrect[1] == true) {
                correctOne = myprops[1];
            } else {
                correctOne = myprops[2];
            }

            String p1 = myprops[0];
            String p2 = myprops[1];
            String p3 = myprops[2];

            String requete = "insert into qcm (proposition1,proposition2,proposition3,propositionCorrect)values(?,?,?,?)";

            PreparedStatement ps = cnx.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, p1);
            ps.setString(2, p2);
            ps.setString(3, p3);
            ps.setString(4, correctOne);
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                qcmID = (int) rs.getLong(1);
            }

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("|| Execption ||");
        }
        System.out.println("Qcm bien ajoute :" + c.toString() + "avec id =" + qcmID);

        return qcmID;
    }

    @Override
    public ArrayList<Qcm> getMyList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int idObj) {
        try {

            String requete = "delete from qcm where id=?";

            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, "" + idObj);
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("|| Execption ||");
        }
        System.out.println("qcm de id= " + idObj + "bien supprime");
    }

    @Override
    public Qcm find(int id) {
        Qcm qcm = new Qcm();
        String[] propositions = new String[3];
        Boolean[] propCorrects = new Boolean[3];
        try {
            String prop1 = "";
            String prop2 = "";
            String prop3 = "";
            String propC = "";

            String requete = "select * from qcm where idQ = ? ";
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, "" + id);
            ps.execute();

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                prop1 = rs.getString(2);
                prop2 = rs.getString(3);
                prop3 = rs.getString(4);
                propC = rs.getString(5);

            }

            propositions[0] = prop1;
            propositions[1] = prop2;
            propositions[2] = prop3;

            if (propC.equals(propositions[0])) {
                propCorrects[0] = true;
            } else {
                propCorrects[0] = false;
            }
            if (propC.equals(propositions[1])) {
                propCorrects[1] = true;
            } else {
                propCorrects[1] = false;
            }
            if (propC.equals(propositions[2])) {
                propCorrects[2] = true;
            } else {
                propCorrects[2] = false;
            }

            qcm.setPropositions(propositions);
            qcm.setProCorrect(propCorrects);

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Execption");
        }
        return qcm;

    }

}
