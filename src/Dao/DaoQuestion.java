/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Chapitres;
import Model.Question;
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
public class DaoQuestion extends Dao<Question> {

    Connection cnx;
    DaoQcm daoQcm = new DaoQcm();
    DaoQroc daoQroc = new DaoQroc();
    DaoChapitres daoChap = new DaoChapitres();

    public DaoQuestion() {
        cnx = getCon();
    }

    @Override
    public int add(Question c) {
        Integer idQcm = null;
        Integer idQroc = null;

        if (c.getQcm() != null) {
            idQcm = daoQcm.add(c.getQcm());
            
        }

        if (c.getQroc() != null) {
            idQroc = daoQroc.add(c.getQroc());
        }

        try {

            String ennonce = c.getEnonce();
          
            String requete = "insert into questions (enonce, idCh, idQcm, idQroc, idExam)values(?, ?, ?, ?, ?)";

            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, ennonce);
            ps.setString(2, "" + c.getChap().getId());
            if (idQcm != null) {
                ps.setInt(3, idQcm);
            } else {
                ps.setNull(3, java.sql.Types.INTEGER);
            }
            if (idQroc != null) {
                ps.setInt(4, idQroc);
            } else {
                ps.setNull(4, java.sql.Types.INTEGER);
            }
            if (c.getIdExamen() != null) {
                ps.setInt(5, c.getIdExamen());
            } else {
                ps.setNull(5, java.sql.Types.INTEGER);
            }
            
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("|| Execption ||");
        }
        System.out.println("question bien ajoute ! ");
        System.out.println("---------------------- ");
        return 0;
    }

    @Override
    public ArrayList<Question> getMyList() {
        ArrayList<Question> listQuestions = new ArrayList<>();

        try {

            String requete = "select * from questions where idExam is null";
            Statement ps = cnx.createStatement();
            ResultSet rs = ps.executeQuery(requete);

            while (rs.next()) {
                Question qst = new Question(rs.getInt("id"), rs.getString("enonce"));

                qst.setQcm(daoQcm.find(rs.getInt("idQcm")));
                qst.setQroc(daoQroc.find(rs.getInt("idQroc")));
                qst.setChap(daoChap.find(rs.getInt("idCh")));

                listQuestions.add(qst);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Execption");
        }

        return listQuestions;

    }

    @Override
    public void delete(int idObj) {
         try {

            String requete = "delete from questions where id=?";

            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, "" + idObj);
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("|| Execption ||");
        }
        System.out.println("question de id= " + idObj + "bien supprime");
    }

    @Override
    public Question find(int id) {

        Question qst = new Question();

        try {
            String enonce = "";
            int idChap = 0;
            int idQcm = 0;
            int idQroc = 0;
            int idExam = 0;

            String requete = "select * from questions where (id) = ? ";
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, "" + id);
            ps.execute();

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                enonce = rs.getString(2);
                idChap = rs.getInt(3);
                idQcm = rs.getInt(4);
                idQroc = rs.getInt(5);
                idExam = rs.getInt(6);

            }

            qst.setId(id);
            qst.setEnonce(enonce);

            qst.setChap(daoChap.find(idChap));
            if (idQcm != 0) {
                qst.setQcm(daoQcm.find(idQcm));
            } else {
                qst.setQcm(null);
            }

            if (idQroc != 0) {
                qst.setQroc(daoQroc.find(idQroc));
            } else {
                qst.setQroc(null);
            }

            if (idExam != 0) {
                qst.setIdExamen(idExam);
            } else {
                qst.setIdExamen(0);
            }

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Execption");
        }
        return qst;

    }

}
