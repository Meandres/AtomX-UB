/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomx;

/**
 *
 * @author nous
 */
public class Jeu {
    private boolean fini;
    private Case caseActive;
    private LesCases casesExternes;
    private Joueur joueur;

    public void setFini(boolean fini) {
        this.fini = fini;
    }
    public void setCaseActive(Case caseActive) {
        this.caseActive = caseActive;
    }
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    public boolean isFini() {
        return fini;
    }
    public Case getCaseActive() {
        return caseActive;
    }
    public Joueur getJoueur() {
        return joueur;
    }
    
    public Jeu(String pseudo, int taille){//initialise le plateau de jeu et les instances necessaire au jeu
        setJoueur(new Joueur(pseudo));
        
        
    }
    
}
