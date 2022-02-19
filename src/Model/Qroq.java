/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Arrays;

/**
 *
 * @author hajer
 */
public class Qroq extends Question{
    
    String [] motcles;

    public Qroq( int id, String enonce,String[] motcles) {
        super(id, enonce);
        this.motcles = motcles;
    }

    public Qroq(String[] motcles, String enonce) {
        super(enonce);
        this.motcles = motcles;
    }

   

    public Qroq(String[] motcles) {
        
        this.motcles = motcles;
    }

    public Qroq() {
    }

    public void setMotcles(String[] motcles) {
        this.motcles = motcles;
    }

  
    
    public String[] getMotcles() {
        return motcles;
    }

     @Override
    public String toString() {
        return "Qroq{" + "motcles=" +Arrays.toString(motcles) + '}';
    }
    

  
    
}
