/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gb346159
 */
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
public class Joueur 
{
    private String pseudo;
    private Color couleur;
    private double solde;
    private Image photo;
    private ArrayList<CarteLoto> lescartes;
    private ArrayList<Lot> ll;
    
    public String getPseudo() { return this.pseudo;  }
    public Color getCouleur() { return this.couleur; }
    public double getSolde() { return this.solde; }
    public ArrayList<Lot> getLots() { return this.ll; }
    public int getNbCartes() { return this.lescartes.size(); }
    public CarteLoto getCarte(int n) { return this.lescartes.get(n); }
    public ArrayList<CarteLoto> getCartes() { return this.lescartes; }
    public void ajouteCarte(CarteLoto c) { this.lescartes.add(c); }
    public Image getPhoto() { return this.photo;}
    public void setPseudo(String p) { this.pseudo=p; }
    
    public void setCouleur(Color c) { this.couleur = c; }
    public void setPhoto(Image p) { this.photo = p; }
    public void setSolde(double s) { this.solde = s; }
    
    
    public Joueur() 
    {
        this.pseudo = "";
        this.couleur=Color.gray;
        this.solde = 20;
        this.photo = new ImageIcon(getClass().getResource("/joueurDefaut.png")).getImage();
        this.lescartes = new ArrayList<CarteLoto>();
        this.ll = new ArrayList<Lot>();
    }
    public Joueur(String p) 
    {
        this.pseudo = p;
        this.couleur=Color.gray;
        this.solde = 20;
        this.photo = new ImageIcon(getClass().getResource("/joueurDefaut.png")).getImage();
        this.lescartes = new ArrayList<CarteLoto>();
        this.ll = new ArrayList<Lot>();
    }
    public String toString() 
    {
        String res= "\nJoueur " + this.pseudo;
        res+= "\nCouleur " + this.couleur;
        res+= "\nSolde " + this.solde;
        return res;
    }  
    
    public boolean acheter(CarteLoto c)
    {
        if(getSolde()>=c.getPrix()&&this.lescartes.size()<2)
            return true;
        else
            return false;
    }
    public void ajouteLot(Lot lot)
    {
        ll.add(lot);
    }
    public int getNbLot()
    {
        return ll.size();
    }
    public Lot getLot(int i)
    {
        return ll.get(i);
    }
    
}
