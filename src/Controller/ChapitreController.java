/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoChapitres;
import Model.Chapitres;
import View.ChapitresView;
import java.util.ArrayList;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author hajer
 */
public class ChapitreController {

    ChapitresView cv = new ChapitresView();
    DaoChapitres daochap = new DaoChapitres();

    public void controleFormAjout(BorderPane root) {

        cv.afficheFormAjout(root);

        ajouterChap();

    }

    public void ajouterChap() {

        cv.getBtnAjout().setOnAction((event) -> {

            String ennonce = cv.getText1().getText();
            Chapitres c = new Chapitres(ennonce);
            daochap.add(c);

        });

    }

    public void afficheListChap(BorderPane root) {

        ArrayList myList = daochap.getMyList();
        cv.afficheListCh(root, myList);

    }
}
