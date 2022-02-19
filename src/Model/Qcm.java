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
public class Qcm extends Question{
   
    String [] propositions;
    Boolean [] proCorrect;

    public Qcm(String[] propositions, Boolean[] proCorrect) {
        this.propositions = propositions;
        this.proCorrect = proCorrect;
    }

    public Qcm() {
    }

    public void setPropositions(String[] propositions) {
        this.propositions = propositions;
    }

    public void setProCorrect(Boolean[] proCorrect) {
        this.proCorrect = proCorrect;
    }
    

    public String[] getPropositions() {
        return propositions;
    }

    public Boolean[] getProCorrect() {
        return proCorrect;
    }

    @Override
    public String toString() {
        return "Qcm{" + "propositions=" + Arrays.toString(propositions) + ", proCorrect=" + Arrays.toString(proCorrect)+ '}';
    }
    
    
}
