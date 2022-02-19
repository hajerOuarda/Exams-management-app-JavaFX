/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoChapitres;
import Dao.DaoQuestion;
import Model.Chapitres;
import Model.Qcm;
import Model.Qroq;
import Model.Question;
import View.ExamensView;
import View.QcmView;
import View.QrocView;
import View.QuestionView;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author hajer
 */
public class QuestionController {

    QuestionView qv = new QuestionView();
    QcmView qcmView = new QcmView();
    QrocView qrocView = new QrocView();

    QCMController qcmController = new QCMController();
    QrocController qrocController = new QrocController();

    DaoQuestion daoq = new DaoQuestion();
    DaoChapitres daochap = new DaoChapitres();

    Integer idExamen;

    public QuestionController() {
    }

    public QuestionController(Integer idExamen) {
        this();
        this.idExamen = idExamen;
    }
    List<Chapitres> listeChap = new ArrayList();

    public void afficheFormualire(BorderPane root) {

        listeChap = daochap.getMyList();

        qv.formulaireAjout(root, listeChap);
        addQst(root);

    }

    public void addQst(BorderPane root) {

        qv.getTg()
                .selectedToggleProperty()
                .addListener((obs, oldVal, newVal) -> {
                    if (newVal.isSelected()) {

                        if (newVal instanceof RadioButton) {
                            if (((RadioButton) newVal).getText().equals("QCM")) {
                                System.out.println("QCM choosed ||");
                                qcmView.afficheQCM(qv.getQstBorder());

                            } else if (((RadioButton) newVal).getText().equals("QROC")) {
                                System.out.println("QROC choosed ||");
                                qrocView.afficheQROC(qv.getQstBorder());
                            }
                        }
                    }
                });

        qv.getBtnAjout().setOnAction((e) -> {
            String ennonce = qv.getTextField1().getText();

            boolean qcmHasError = true;
            boolean qrocHasError = true;

            Qcm qcm = null;
            Qroq qroc = null;

            if (ennonce != null && !ennonce.trim().equals("")
                    && qv.getCbox().getValue() != null
                    && (qv.getRdQCM().isSelected() || qv.getRdQROC().isSelected())) {
                Question question = new Question(ennonce);

                if (qv.getRdQCM().isSelected()) {
                    qcm = new Qcm();
                    qcmController.setQcmView(qcmView);
                    qcmHasError = qcmController.ajouterQCM(qcm);

                    if (!qcmHasError) {
                        question.setQcm(qcm);

                    } else {
                        System.out.println("Remplir tous les champs de qcm");
                    }
                }

                if (qv.getRdQROC().isSelected()) {
                    qroc = new Qroq();
                    qrocController.setQrocView(qrocView);
                    qrocHasError = qrocController.ajouterQroc(qroc);

                    if (!qrocHasError) {
                        question.setQroc(qroc);

                    } else {
                        System.out.println("Remplir tous les champs de qroc  ");
                    }
                }

                Chapitres selectedChap = (Chapitres) qv.getCbox().getValue();

                if (selectedChap != null) {
                    question.setChap(selectedChap);
                }

                if (this.idExamen != null) {
                    question.setIdExamen(idExamen);
                }
                if(!qcmHasError || !qrocHasError ){
                    daoq.add(question);
                }
                
                

            }
            else System.out.println("Remplir tous les champs de question ! ");
        });
    }

    public void afficheListQuestions(ExamensView exV) {

        ArrayList listQst = daoq.getMyList();
        qv.affichageListQuestion(listQst, exV);

    }

}
