/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.QuestionController;
import Dao.DaoExamens;
import Model.Chapitres;
import Model.Examens;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author hajer
 */
public class ExamensView {

    private BorderPane examBorder = new BorderPane();

    private Button btnAaddExam = new Button("submit");
    private Label label1 = new Label("duree :  ");

    private TextField text1 = new TextField();

    private TextField deleteEx = new TextField();

    private HBox hbox1 = new HBox();

    private HBox hbox3 = new HBox();
    private VBox vbox = new VBox();

    public BorderPane getExamBorder() {
        return examBorder;
    }

    public void setExamBorder(BorderPane examBorder) {
        this.examBorder = examBorder;
    }

    public void afficheListEx(BorderPane root, ArrayList myList) {

        TableView mytable = new TableView();

        TableColumn<Examens, String> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Examens, String> duree = new TableColumn<>("Duree");
        duree.setCellValueFactory(new PropertyValueFactory<>("duree"));

        TableColumn<Examens, String> nbQst = new TableColumn<>("nb Questions");
        nbQst.setCellValueFactory(new PropertyValueFactory<>("nbQst"));

        ObservableList<Chapitres> data = FXCollections.observableArrayList(myList);

        mytable.getColumns().add(id);
        mytable.getColumns().add(duree);
        mytable.getColumns().add(nbQst);

        mytable.setItems(data);
        BorderPane.setMargin(mytable, new Insets(10, 10, 10, 10));
        root.setCenter(mytable);

    }

    public void afficheFormAjout(BorderPane root) {

        hbox1.getChildren().clear();
        hbox1.getChildren().addAll(label1, text1);

        hbox3.getChildren().clear();
        hbox3.getChildren().add(btnAaddExam);
        vbox.getChildren().clear();
        vbox.getChildren().addAll(hbox1);

        vbox.setSpacing(6);

        BorderPane.setMargin(vbox, new Insets(10, 10, 10, 10));

        hbox1.setAlignment(Pos.CENTER);

        hbox3.setAlignment(Pos.BASELINE_RIGHT);

        examBorder.setPadding(new Insets(0, 10, 10, 0));
        examBorder.setTop(vbox);
        examBorder.setBottom(hbox3);

        root.setCenter(examBorder);

    }

    public void supprimerExam(BorderPane root, List<Examens> listeExams, DaoExamens daoex) {

        Label l1 = new Label("choisir les examsen a supprimer !");
        HBox hb1 = new HBox();
        HBox hb2 = new HBox();
        Button suppBtn = new Button("supprimer");

        hb1.getChildren().clear();
        hb1.getChildren().addAll(l1);
        hb1.setAlignment(Pos.CENTER);
        hb2.getChildren().clear();
        hb2.getChildren().addAll(suppBtn);
        hb2.setAlignment(Pos.BOTTOM_RIGHT);

        BorderPane.setMargin(hb1, new Insets(7, 10, 15, 10));
        BorderPane.setMargin(hb2, new Insets(15, 10, 5, 10));

        examBorder.setPadding(new Insets(10, 10, 10, 10));
        examBorder.setTop(hb1);
        examBorder.setBottom(hb2);

        ListView mylistView = new ListView();

        for (Examens exSupp : listeExams) {
            mylistView.getItems().add(exSupp);

        }
        mylistView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        List<Examens> l = mylistView.getSelectionModel().getSelectedItems();
        suppBtn.setOnAction((event) -> {
            for (Examens examens : l) {
                daoex.delete(examens.getId());
            }
            List<Examens> listeExamsFinal = listeExams;
            listeExamsFinal = daoex.getMyList();
            mylistView.getItems().clear();
            
            for (Examens exSupp : listeExamsFinal) {
                mylistView.getItems().add(exSupp);

            }
        });

        examBorder.setCenter(mylistView);
        root.setCenter(examBorder);

    }

    public Button getBtnAaddExam() {
        return btnAaddExam;
    }

    public TextField getText1() {
        return text1;
    }

    public TextField getDeleteEx() {
        return deleteEx;
    }

}
