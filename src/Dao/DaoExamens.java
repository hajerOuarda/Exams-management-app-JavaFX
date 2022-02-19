/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Examens;
import Model.Question;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hajer
 */
public class DaoExamens extends Dao<Examens> {

    java.sql.Connection cnx;

    public DaoExamens() {
        cnx = getCon();
    }

    @Override
    public int add(Examens ex) {
        int idExam = 0;

        try {

            int duree = ex.getDuree();
            int nbQst = ex.getNbQst();
            String requete = "insert into examens (duree, nbQst) values(?, ?)";

            PreparedStatement ps = cnx.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, duree);
            ps.setInt(2, nbQst);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idExam = (int) rs.getLong(1);
            }

            ps.close();

            //update questions
            requete = "update questions set idExam = ? where id = ?";
            for (Question qst : ex.getQuestions()) {
                ps = cnx.prepareStatement(requete);
                ps.setInt(1, idExam);
                ps.setInt(2, qst.getId());
                ps.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("|| Execption ||");
        }
        System.out.println("examen bien ajoute :");
        return idExam;
    }

    @Override
    public ArrayList<Examens> getMyList() {

        ArrayList<Examens> listExamens = new ArrayList<>();

        try {

            String requete = "select * from examens ";
            Statement ps = cnx.createStatement();
            ResultSet rs = ps.executeQuery(requete);

            while (rs.next()) {
                Examens ex = new Examens(rs.getInt("id"), rs.getInt("duree"), rs.getInt("nbQst"));
                listExamens.add(ex);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Execption");
        }

        return listExamens;
    }

    @Override
    public void delete(int idObj) {

        try {

            String requete = "delete from examens where id=?";

            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, "" + idObj);
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("|| Execption ||");
        }
        System.out.println("examen de id= " + idObj + "bien supprime");

    }

    @Override
    public Examens find(int id) {
        Examens exam = new Examens();

        try {
            int duree = 0;
            int nbQst = 0;

            String requete = "select * from examens where (id) = ? ";
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, "" + id);
            ps.execute();

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                duree = Integer.parseInt(rs.getString(2));
                nbQst = Integer.parseInt(rs.getString(3));
            }

            exam.setId(id);
            exam.setDuree(duree);
            exam.setNbQst(nbQst);

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Execption");
        }
        return exam;

    }

}
