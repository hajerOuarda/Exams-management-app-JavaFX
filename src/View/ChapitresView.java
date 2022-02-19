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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class ChapitresView {

    private Button btnAjout = new Button("submit");
    private Label label1 = new Label(" titre de chapitre : ");

    private TextField text1 = new TextField();

    private HBox hbox1 = new HBox();
    private HBox hbox2 = new HBox();

    private VBox vbox = new VBox();

    public Button getBtnAjout() {
        return btnAjout;
    }

    public Label getLabel1() {
        return label1;
    }

    public TextField getText1() {
        return text1;
    }

    public HBox getHbox1() {
        return hbox1;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void afficheListCh(BorderPane root, ArrayList mylist) {

        TableView mytable = new TableView();

        TableColumn<Chapitres, String> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Chapitres, String> titre = new TableColumn<>("Titre");
        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));

        ObservableList<Chapitres> data = FXCollections.observableArrayList(mylist);

        mytable.getColumns().add(id);
        mytable.getColumns().add(titre);

        mytable.setItems(data);

        BorderPane.setMargin(mytable, new Insets(7, 10, 15, 10));
        root.setCenter(mytable);

    }

    public void afficheFormAjout(BorderPane root) {

        hbox1.getChildren().clear();
        hbox1.getChildren().addAll(label1, text1);

        hbox2.getChildren().clear();
        hbox2.getChildren().add(btnAjout);

        vbox.getChildren().clear();
        vbox.getChildren().addAll(hbox1, hbox2);

        hbox1.setSpacing(20);
        hbox2.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(12, 45, 0, 45));
        vbox.setAlignment(Pos.TOP_CENTER);

        vbox.setSpacing(20);
        root.setCenter(vbox);

    }

}
