/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author hajer
 */
public class Chapitres implements Serializable{

    int id;
    String titre;

    public Chapitres() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Chapitres(String titre) {
       
        this.titre = titre;
    }

    public Chapitres(int id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    @Override
    public String toString() {
        return  titre ;
    }

   

    
    
}
