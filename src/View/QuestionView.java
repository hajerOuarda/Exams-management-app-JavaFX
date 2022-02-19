/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ExamenController;
import Model.Chapitres;
import Model.Question;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author hajer
 */
public class QuestionView {

    //pour question
    private Button btnAjout = new Button("add Qst");
    private Label label = new Label("ennonce:  ");
    private TextField textField1 = new TextField();
    private BorderPane qstBorder = new BorderPane();

    public BorderPane getQstBorder() {
        return qstBorder;
    }

    public void setQstBorder(BorderPane qstBorder) {
        this.qstBorder = qstBorder;
    }

    private ComboBox cbox = new ComboBox();
    private HBox hb1 = new HBox();
    private HBox hb2 = new HBox();
    private VBox vb1 = new VBox();
    private HBox hBtn = new HBox();

    private RadioButton rdQCM = new RadioButton("QCM");
    private RadioButton rdQROC = new RadioButton("QROC");
    public static ToggleGroup tg = new ToggleGroup();

    public void formulaireAjout(BorderPane root, List<Chapitres> monlist) {

        for (Chapitres chap : monlist) {
            cbox.getItems().add(chap);
        }

        rdQCM.setToggleGroup(tg);
        rdQROC.setToggleGroup(tg);
        hb1.getChildren().clear();
        hb1.getChildren().addAll(label, textField1, cbox);
        hb2.getChildren().clear();
        hb2.getChildren().addAll(rdQCM, rdQROC);
        vb1.getChildren().clear();
        vb1.getChildren().addAll(hb1, hb2);
        vb1.setSpacing(10);

        hBtn.getChildren().clear();
        hBtn.getChildren().add(btnAjout);

        hBtn.setAlignment(Pos.BOTTOM_RIGHT);

        hb1.setSpacing(12);
        hb2.setSpacing(25);

        BorderPane.setMargin(vb1, new Insets(5, 0, 30, 0));

        qstBorder.setPadding(new Insets(10));

        qstBorder.setTop(vb1);

        qstBorder.setBottom(hBtn);

        root.setCenter(qstBorder);

    }

    public void affichageListQuestion(ArrayList<Question> l, ExamensView exView) {

        BorderPane myBorder = new BorderPane();
        ListView mylistView = new ListView();

        for (Question item : l) {
            mylistView.getItems().add(item);
        }

        mylistView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ExamenController.ex.setQuestions(mylistView.getSelectionModel().getSelectedItems());

        myBorder.setCenter(mylistView);

        exView.setExamBorder(myBorder);

    }

    public ToggleGroup getTg() {
        return tg;
    }

    public ComboBox getCbox() {
        return cbox;
    }

    public Button getBtnAjout() {
        return btnAjout;
    }

    public TextField getTextField1() {
        return textField1;
    }

    public RadioButton getRdQCM() {
        return rdQCM;
    }

    public RadioButton getRdQROC() {
        return rdQROC;
    }

    //        for (int i = 0; i < monlist.size(); i++) {
//            Chapitres c = (Chapitres) monlist.get(i);
//            int idChap = c.getId();
//            cbox.getItems().add(c);
//
//        }
}
