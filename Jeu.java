/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsimple;
import java.util.Scanner;

/**
 *
 * @author nous
 */
public class Jeu {
    private boolean fini;
    private Joueur joueur;
    private LesCases tab;

    public boolean isFini() {
        return fini;
    }
    public Joueur getJoueur() {
        return joueur;
    }
    public LesCases getTab() {
        return tab;
    }
    public void setFini(boolean fini) {
        this.fini = fini;
    }
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    public void setTab(LesCases tab) {
        this.tab = tab;
    }
    public void getFini(){
        boolean fini=false;
        if (getTab().getNbObstacles()==0)
            fini=true;
        if (getJoueur().getSolde()<=0)
            fini=true;
        
        }
    
    
    public Jeu(int taille){
        setFini(false);
        setTab(LesCases.getTab(10));
        Scanner input=new Scanner(System.in);
        System.out.println("Entrez votre pseudo :");
        setJoueur(new Joueur(input.nextLine()));
        }

    @Override
    public String toString() {
        return "Jeu{" + "fini=" + fini + ", joueur=" + joueur + ", tab=" + tab + '}';
    }
    
}
