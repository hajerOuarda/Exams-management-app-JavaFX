/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoQcm;
import Model.Qcm;
import View.QcmView;
import View.QuestionView;
import javafx.event.ActionEvent;

/**
 *
 * @author hajer
 */
public class QCMController {

    private QcmView qcmView = null;
    DaoQcm qcmDao = new DaoQcm();

    public void setQcmView(QcmView qcmView) {
        this.qcmView = qcmView;
    }

    public boolean ajouterQCM(Qcm qcm) {
        boolean hasError = true;

        String prop1 = qcmView.getT1().getText();
        String prop2 = qcmView.getT2().getText();
        String prop3 = qcmView.getT3().getText();
        String propCor = qcmView.getT4().getText();

        if (!prop1.trim().equals("") && !prop2.trim().equals("") && !prop3.trim().equals("")
                && !prop1.equalsIgnoreCase(prop2) && !prop1.equalsIgnoreCase(prop3)
                && !prop2.equalsIgnoreCase(prop3) && !propCor.trim().equals("")
                && (propCor.equals(prop1) || propCor.equals(prop2) || propCor.equals(prop3))) {

            Boolean[] propCorrect = {false, false, false};

            String[] props = {prop1, prop2, prop3};

            if (propCor.equals(prop1)) {
                propCorrect[0] = true;
            }
            if (propCor.equals(prop2)) {
                propCorrect[1] = true;
            }
            if (propCor.equals(prop3)) {
                propCorrect[2] = true;
            }

            qcm.setPropositions(props);
            qcm.setProCorrect(propCorrect);

            hasError = false;
        }
        return hasError;
    }
}
