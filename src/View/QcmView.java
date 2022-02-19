/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author hajer
 */
public class QcmView {

    private Label l1 = new Label("proposition 1           : ");
    private Label l2 = new Label("proposition 2           : ");
    private Label l3 = new Label("proposition 3           : ");
    private Label l4 = new Label("proposition Correct  : ");

    private TextField t1 = new TextField();
    private TextField t2 = new TextField();
    private TextField t3 = new TextField();
    private TextField t4 = new TextField();

    private HBox hb1 = new HBox(l1, t1);
    private HBox hb2 = new HBox(l2, t2);
    private HBox hb3 = new HBox(l3, t3);
    private HBox hb4 = new HBox(l4, t4);
    private VBox vb1 = new VBox(hb1, hb2, hb3, hb4);

    public void afficheQCM(BorderPane qstRoot) {
        
        vb1.getChildren().clear();
        vb1.setSpacing(5);
        vb1.setPadding(new Insets(0, 0, 0, 60));
        vb1.getChildren().addAll(hb1,hb2,hb3,hb4); //illegal argument exception
        
        
        qstRoot.setCenter(vb1);

    }

    public Label getL1() {
        return l1;
    }

    public Label getL2() {
        return l2;
    }

    public Label getL3() {
        return l3;
    }

    public Label getL4() {
        return l4;
    }

    public TextField getT1() {
        return t1;
    }

    public TextField getT2() {
        return t2;
    }

    public TextField getT3() {
        return t3;
    }

    public TextField getT4() {
        return t4;
    }
}
