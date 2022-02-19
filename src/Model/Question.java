/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hajer
 */
public class Question {

    int id;

    public void setId(int id) {
        this.id = id;
    }
    String enonce;
    Qcm qcm;
    Qroq qroc;
    Chapitres chap;
    Integer idExamen;


    public Question() {
    }

    public Question(int id, String enonce) {
        this.id = id;
        this.enonce = enonce;
    }

    public Question(String enonce) {

        this.enonce = enonce;
    }

    public int getId() {
        return id;
    }

    public String getEnonce() {
        return enonce;
    }

    public Qcm getQcm() {
        return qcm;
    }

    public void setQcm(Qcm qcm) {
        this.qcm = qcm;
    }

    public Qroq getQroc() {
        return qroc;
    }

    public void setQroc(Qroq qroc) {
        this.qroc = qroc;
    }

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public Chapitres getChap() {
        return chap;
    }

    public void setChap(Chapitres chap) {
        this.chap = chap;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    @Override
    public String toString() {
        if (qcm != null) {
            return "Question{" + "id=" + id + ", enonce=" + enonce + ", || "+qcm.toString() + ", ||" + chap.toString() + ", idExamen=" + idExamen + '}';
        } else {
            return "Question{" + "id=" + id + ", enonce=" + enonce +" , ||" + qroc.toString() + ", ||" + chap.toString() + ", idExamen=" + idExamen + '}';
        }
    }

}
