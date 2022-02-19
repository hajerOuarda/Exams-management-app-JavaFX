/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Examens;
import View.MenuView;
import examsapp.ExportFiles;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author hajer
 */
public class MenuController {

    BorderPane root;
    ExportFiles exf=new ExportFiles();
    
    MenuView v = new MenuView();

    ChapitreController cc = new ChapitreController();
    ExamenController ec = new ExamenController();
    QuestionController qc = new QuestionController();

    public MenuController(BorderPane root) {
        this.root = root;
    }

    public void afficheMenu() {

        v.showMenu(root);
        controlerMenu();

    }

    public void controlerMenu() {

        v.getAjoutCh().setOnAction((event) -> {

            cc.controleFormAjout(root);

        });

        v.getListeCh().setOnAction((event) -> {
            cc.afficheListChap(root);
        });

        v.getListeExamens().setOnAction((event) -> {
            ec.afficheListEx(root);
        });

        v.getAjoutQst().setOnAction((event) -> {
            qc.afficheFormualire(root);

        });
        v.getAjouterExam().setOnAction((event) -> {
            ec.ex = new Examens();
            qc.afficheListQuestions(ec.getEv());
            ec.controleFormAjout(root);

        });

        v.getSupprimerExam().setOnAction((event) -> {
            ec.suppExam(root);

        });

        v.getExporterQst().setOnAction((event) -> {
            exf.exporterQst();
        });
        v.getExporterEx().setOnAction((event) -> {
            exf.exporterExam();
        });
        
        v.getAlimenter().setOnAction((event) -> {
            exf.alimenter();
        });
        v.getQuitter().setOnAction((event) -> {
            root.getScene().getWindow().hide();
        });

    }

}
