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
public class LesCartes {
    private ArrayList<CarteLoto> lst;
    
    public LesCartes()
    {
        lst = new ArrayList<CarteLoto>();
    }
    
    public int getTaille()
    {
        return lst.size();
    }
    
    public CarteLoto getCarte(int i)
    {
        return lst.get(i);
    }
    
    public void ajout(CarteLoto c)
    {
        lst.add(c);
    }
    
    public void retire(CarteLoto c)
    {
        for(int i=0; i<this.getTaille();i++)
        {
            if(this.getCarte(i).equals(c))
                this.retireCarte(i);
        }
    }
    public void retireCartes()
    {
        lst.clear();
    }
    public void retireCarte(int i)
    {
        lst.remove(i);
    }
    
    public LesCartes rechCartes(int num)
    {
        LesCartes lc = new LesCartes();
        for(int i=0; i<this.getTaille();i++)
        {
            CarteLoto c = this.getCarte(i);
            if(c.estDans(num))
                this.ajout(c);
        }
        return lc;
    }
    public void initLesCartes(int n, int nbCol, int nbVal)
    {
        for(int i=0; i<n; i++)
            if(nbVal >= 1 && nbVal <= 90)
            {
                CarteLoto c = new CarteLoto(nbCol, nbVal);
                this.ajout(c);
            }
    }
    
    public String toString()
    {
        String msg = "";
        for(int i=0; i<this.getTaille(); i++)
        {
            msg += "Carte n°"+(i+1);
            msg += "\n"+this.getCarte(i).toString();
            msg += "\n\n";
        }
        return msg;
    }
}
