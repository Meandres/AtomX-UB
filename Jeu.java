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
        System.out.println(getTab().getNbObstacles()==0 || getJoueur().getSolde()<=0);
        //setFini(getTab().getNbObstacles()==0 || getJoueur().getSolde()<=0);
        //getJoueur().setGagne(getTab().getNbObstacles()==0 && getJoueur().getSolde()>0);
        }
    public void tour(){
        Scanner input=new Scanner(System.in);
        Position p;
        //getTab().getCases()[5][5]=new Prison(new Position(5,5));
        do{
        System.out.println("Entrez l'endroit où vous souhaitez faire commencer votre particule.");
        int x=input.nextInt();
        int y=input.nextInt();
        p=new Position(x, y);
        }while(!p.isValide(getTab().getCases().length));
        System.out.println("Entrez le poid que vous souhaitez attribuer à la particule :");
        int poid=input.nextInt();
        getJoueur().setParticule(new Particule(p, getDirInitiale(p), poid));
        getJoueur().setSolde(getJoueur().getSolde()-poid);
        do{
            avance();
            getJoueur().getParticule().arret(getTab().getCases().length);
        }while(getJoueur().getParticule().isActive());
        int x=getJoueur().getParticule().getPos().getX(), y=getJoueur().getParticule().getPos().getY();
        if(x==-1 || x==getTab().getCases().length || y==-1 || y==getTab().getCases().length){
            System.out.println("Vous avez récupéré votre particule avec un poid de "+ getJoueur().getParticule().getPoid()+ " sur la case "+getJoueur().getParticule().getPos());
            getJoueur().setSolde(getJoueur().getSolde()+getJoueur().getParticule().getPoid());
            }
        else{
            System.out.println("Vous n'avez pas récupéré votre particule.");
        }
        System.out.println("Votre nouveau solde est :" + getJoueur().getSolde());
        //getFini();
        if (getJoueur().getGagne()){
            System.out.println("Vous avez gagné.");
        }
    }
    
    
    public Jeu(int taille){
        setFini(false);
        setTab(LesCases.getTab(10));
        Scanner input=new Scanner(System.in);
        System.out.println("Entrez votre pseudo :");
        setJoueur(new Joueur(input.nextLine()));
        }
    public Jeu(byte parametre){
        setFini(false);
        setTab(LesCases.getTab(parametre));
        Scanner input=new Scanner(System.in);
        System.out.println("Entrez votre pseudo :");
        setJoueur(new Joueur(input.nextLine()));
    }

    @Override
    public String toString() {
        return "Jeu{" + "fini=" + fini + ", joueur=" + joueur + ", tab=" + tab + '}';
    }
    public Direction getDirInitiale(Position p){
        Direction dir=new Direction(0,0);
        int taille = getTab().getCases().length;
        if (p.getX()==0 && p.getY()<taille && p.getY()>=0)
            dir=new Direction(1, 0);
        if (p.getX()==(taille-1) && p.getY()<taille && p.getY()>=0)
            dir=new Direction(-1, 0);
        if (p.getY()==0 && p.getX()<taille && p.getX()>=0)
            dir=new Direction(0, 1);
        if (p.getY()==(taille-1) && p.getX()<taille && p.getX()>=0)
            dir=new Direction(0, -1);
        return dir;
    }
    public void avance(){
        Position pos=getJoueur().getParticule().getPos();
        Direction dir=getJoueur().getParticule().getDir();
        getTab().getCases()[pos.getX()][pos.getY()].setContenu(getJoueur().getParticule());
        getTab().getCases()[pos.getX()][pos.getY()].action();
        pos.setX(pos.getX()+dir.getX());
        pos.setY(pos.getY()+dir.getY());
    }
}
