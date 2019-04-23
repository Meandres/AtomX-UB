/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomx_1_0;

/**
 *
 * @author nous
 */
public class Joueur {
    private String pseudo;
    private int solde;
    private Particule particule;
    private boolean gagne;

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public void setSolde(int solde) {
        this.solde = solde;
    }
    public void setParticule(Particule particule) {
        this.particule = particule;
    }
    public void setGagne(boolean f){
        this.gagne=f;
    }
    public boolean getGagne(){
        return gagne;
    }
    public int getSolde() {
        return solde;
    }
    public String getPseudo() {
        return pseudo;
    }
    public Particule getParticule() {
        return particule;
    }
    
    
    public Joueur(String pseudo) {
        setPseudo(pseudo);
        setSolde(50);
        setGagne(false);
    }

    @Override
    public String toString() {
        return "Joueur{" + "pseudo=" + pseudo + ", solde=" + solde + ", particule=" + particule + '}';
    }

    
    
    
    
}
