/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsimple;

/**
 *
 * @author nous
 */
public class Joueur {
    private String pseudo;
    private int solde;

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public void setSolde(int solde) {
        this.solde = solde;
    }
    public int getSolde() {
        return solde;
    }
    public String getPseudo() {
        return pseudo;
    }

    public Joueur(String pseudo) {
        setPseudo(pseudo);
        setSolde(50);
    }

    @Override
    public String toString() {
        return "Joueur{" + "pseudo=" + pseudo + ", solde=" + solde + '}';
    }
    
    
    
}
