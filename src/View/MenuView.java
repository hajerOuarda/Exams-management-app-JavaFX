/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Chapitres;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author hajer
 */
public class MenuView {

    Menu chapters = new Menu("les chapitres");
    Menu exams = new Menu("les examens");
    Menu inout = new Menu("I/O");

    // pour le menu chapitres: 
    MenuItem listeCh = new MenuItem("la liste des chapitres");
    MenuItem ajoutCh = new MenuItem("ajouter chapitre");
    MenuItem ajoutQst = new MenuItem("ajouter Question");
    MenuItem quitter = new MenuItem("Quitter application");

    //pour exams:
    MenuItem listeExamens = new MenuItem("La Liste d'examens");
    Menu genereExamens = new Menu("Genere les examens");
    MenuItem ajouterExam = new MenuItem("Ajouter Exam");
    MenuItem supprimerExam = new MenuItem("Supprimer Exam");

    //pour i/o
    MenuItem alimenter = new MenuItem("Alimenter base de donnee");
    MenuItem exporterQst = new MenuItem("exporter les  Questions");
    MenuItem exporterEx = new MenuItem("exporter les examens");

    //for the main BorderPane
    HBox emptyHB = new HBox();
    VBox emptyVB1 = new VBox();
    VBox emptyVB2 = new VBox();

    public void showMenu(BorderPane root) {

        MenuBar mymenubar = new MenuBar();

        chapters.getItems().addAll(listeCh, ajoutCh, ajoutQst, quitter);

        //pour exams:
        exams.getItems().addAll(listeExamens, genereExamens);
        genereExamens.getItems().addAll(ajouterExam, supprimerExam);

        //pour I/O
        inout.getItems().addAll(alimenter, exporterQst, exporterEx);

        mymenubar.getMenus().addAll(chapters, exams, inout);
        root.setTop(mymenubar);

 
    }

    public MenuItem getListeCh() {
        return listeCh;
    }

    public MenuItem getAjoutCh() {
        return ajoutCh;
    }

    public MenuItem getAjoutQst() {
        return ajoutQst;
    }

    public MenuItem getListeExamens() {
        return listeExamens;
    }

    public MenuItem getGenereExamens() {
        return genereExamens;
    }

    public MenuItem getAlimenter() {
        return alimenter;
    }

    public MenuItem getExporterQst() {
        return exporterQst;
    }

    public MenuItem getExporterEx() {
        return exporterEx;
    }

    public MenuItem getQuitter() {
        return quitter;
    }

    public MenuItem getAjouterExam() {
        return ajouterExam;
    }

    public MenuItem getSupprimerExam() {
        return supprimerExam;
    }

}
