/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gb346159
 */
import java.util.*;
public class LesJoueurs 
{
    private ArrayList<Joueur> lstJ;
    
    public LesJoueurs()
    {
        lstJ = new ArrayList<Joueur>();
    }
    
    public Joueur getJoueur(int i)
    {
        return lstJ.get(i);
    }
    public int getNbJoueur()
    {
        return lstJ.size();
    }
    public void ajouteJoueur(Joueur j)
    {
        lstJ.add(j);
    }
    public void supprimeJoueur(Joueur j)
    {
        lstJ.remove(j);
    }
    public Joueur rechJoueur(String ps)
    {
        Joueur trouve = null;
        for(int i=0; i<this.getNbJoueur(); i++)
        {
            if(this.getJoueur(i).getPseudo().equals(ps))
                trouve = this.getJoueur(i);
        }
        return trouve;
    }
    
    public String toString()
    {
        String msg = "";
        for(int i=0; i<this.getNbJoueur(); i++)
        {
            msg += "Le joueur n°"+(i+1)+" s'appelle "+this.getJoueur(i).getPseudo();
            msg += "\nIl aime la couleur "+this.getJoueur(i).getCouleur();
            msg += "\nIl dispose d'un solde de "+this.getJoueur(i).getSolde();
            msg += "\n\n";
        }
        return msg;
    }
}
