/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author hajer
 */
public class QrocView {
    
    private Label labelMot = new Label("mot cles   : ");
    private TextField motCles = new TextField();
    private HBox hb1=new HBox();
    
    //private BorderPane qrocBorder=new BorderPane();
    
    public void afficheQROC(BorderPane qstRoot ) {
        
        hb1.getChildren().clear();
        hb1.getChildren().addAll(labelMot,motCles);
        hb1.setSpacing(7);
        hb1.setPadding(new Insets(0, 0, 0, 150));
        qstRoot.setCenter(hb1);
    }

    public TextField getMotCles() {
        return motCles;
    }
    
    
    
    
}
