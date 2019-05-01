/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomx_1_0;

/**
 *
 * @author Gabriel
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
}