/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoExamens;
import Model.Examens;
import View.ExamensView;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author hajer
 */
public class ExamenController {

    DaoExamens daoex = new DaoExamens();
    ExamensView ev = new ExamensView();

    public void afficheListEx(BorderPane root) {

        ArrayList myList = daoex.getMyList();

        ev.afficheListEx(root, myList);
    }

    public void controleFormAjout(BorderPane root) {

        ev.afficheFormAjout(root);
        ajouterExam(root);

    }

    public static Examens ex = new Examens();

    public void ajouterExam(BorderPane root) {

        ev.getBtnAaddExam().setOnAction((event) -> {

            if (!ev.getText1().getText().trim().equals("")) {
                try {
                    int nbrDuree = Integer.parseInt(ev.getText1().getText());
                   
                    ex.setDuree(nbrDuree);
                    ex.setNbQst(ex.getQuestions().size());

                    if (!ex.getQuestions().isEmpty()) {
                        daoex.add(ex);
                    } else {
                        new QuestionController(daoex.add(ex)).afficheFormualire(root);
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("entrez variable numeric: "+ex.getMessage());
                }
            }
        });

    }

    public void suppExam(BorderPane root) {

        List<Examens> listeExams=daoex.getMyList();
        ev.supprimerExam(root,listeExams,daoex);
        
        
//        HBox hb = new HBox(ev.getDeleteEx(), ev.getBtnAaddExam());
//        root.setCenter(hb);
//        ev.getBtnAaddExam().setOnAction((event) -> {
//
//            int id = Integer.parseInt(ev.getDeleteEx().getText());
//            daoex.delete(id);
//
//        });

    }

    public ExamensView getEv() {
        return ev;
    }

}
