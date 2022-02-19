/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Qroq;
import View.QrocView;

/**
 *
 * @author hajer
 */
public class QrocController {

    QrocView qrocView = new QrocView();

    public void setQrocView(QrocView qrocView) {
        this.qrocView = qrocView;
    }

    public boolean ajouterQroc(Qroq qroc) {

        boolean hasError = true;

        String motCles = qrocView.getMotCles().getText();

        if (!motCles.trim().equals("")) {
            qroc.setMotcles(motCles.split(";"));
            hasError = false;
        }

        return hasError;
    }
}
