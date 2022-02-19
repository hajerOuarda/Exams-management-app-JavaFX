/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hajer
 */
public class Examens {
    int id;
    int duree;
    int nbQst;
    List<Question> questions = new ArrayList();

    

    public Examens(){
        
    }
    
    public Examens(int id, int duree, int nbQst) {
        this(duree, nbQst);
        this.id = id;
    }

    public Examens(int duree, int nbQst) {
        this();
        this.duree = duree;
        this.nbQst = nbQst;
    }

    
    public int getId() {
        return id;
    }

    public int getDuree() {
        return duree;
    }

    public int getNbQst() {
        return nbQst;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setNbQst(int nbQst) {
        this.nbQst = nbQst;
    }
    public void setId(int id) {
        this.id = id;
    }
    

    @Override
    public String toString() {
        return "Examens{" + "id=" + id + ", duree=" + duree + ", nbQst=" + nbQst + '}';
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    
    
}
