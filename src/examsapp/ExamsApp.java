/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examsapp;

import Controller.MenuController;
import Dao.DaoQcm;
import Dao.DaoQroc;
import Dao.DaoQuestion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author hajer
 */
public class ExamsApp extends Application {

    BorderPane root = new BorderPane();
    DaoQuestion daoqst=new DaoQuestion();

    @Override
    public void start(Stage primaryStage) {

        MenuController c = new MenuController(root);
        c.afficheMenu();
        Scene scene = new Scene(root, 600, 300);

        
        primaryStage.setTitle("Gestion des examens !");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
