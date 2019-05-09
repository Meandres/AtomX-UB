/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atomx_1_1;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author nous
 */
public class Jeu {
    private boolean fini;
    private Joueur joueur;
    private LesCases tab;
    private JeuAtomX fenetre;
    
    
    public boolean isFini() {
        return fini;
    }
    public Joueur getJoueur() {
        return joueur;
    }
    public LesCases getTab() {
        return tab;
    }
    
    public int getTaille()
    {
        return tab.getCases().length;
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
        setFini(getTab().getNbObstacles()==0 || getJoueur().getSolde()<=0);
        getJoueur().setGagne(getTab().getNbObstacles()==0 && getJoueur().getSolde()>0);
        }
    public void tour(int x, int y)
    {
        
        Scanner input=new Scanner(System.in);
        Position p = new Position (x, y); int poid;
        String msg; boolean continuer=true;
        if(!p.isValide(getTab().getCases().length))
            System.exit(0);
       System.out.println("Entrez le poids que vous souhaitez attribuer à la particule :");
        do{
            poid=input.nextInt();
            }while(getJoueur().getSolde()-poid<0);
        getJoueur().setParticule(new Particule(p, getDirInitiale(p), poid));
        getJoueur().setSolde(getJoueur().getSolde()-poid);
        do{
            avance();
            getJoueur().getParticule().arret(getTab().getCases().length);
        }while(getJoueur().getParticule().isActive());
        x=getJoueur().getParticule().getPos().getX(); y=getJoueur().getParticule().getPos().getY();
        if(x==-1 || x==getTab().getCases().length || y==-1 || y==getTab().getCases().length){
            this.fenetre.Historique.append("\nVous avez récupéré votre particule avec un poids de "+ getJoueur().getParticule().getPoid()+ " sur la case "+getJoueur().getParticule().getPos());
            System.out.println("\nVous avez récupéré votre particule avec un poids de "+ getJoueur().getParticule().getPoid()+ " sur la case "+getJoueur().getParticule().getPos());
            getJoueur().setSolde(getJoueur().getSolde()+getJoueur().getParticule().getPoid());
            }
        else
        {
            this.fenetre.Historique.append("\nVous n'avez pas récupéré votre particule.");
            System.out.println("\nVous n'avez pas récupéré votre particule.");
        }
        System.out.println("Voulez-vous faire une hypothèse ?");
        do{
            msg=input.nextLine();
            switch(msg){
                case "oui":
                case "Oui":
                case "y":
                case "o":{
                    hypo();
                    continuer=false;
                    break;
                }
                case "non":
                case "Non":
                case "n": continuer=false; break;
            }
        }while(continuer);
        this.fenetre.Historique.append("\nVotre nouveau solde est :" + getJoueur().getSolde());
        getFini();
        if (getJoueur().getGagne())
            this.fenetre.Historique.append("\nVous avez gagné.");
        if(!getJoueur().getGagne()&&getJoueur().getSolde()<=0)
            this.fenetre.Historique.append("\nVous avez perdu.");
    }
    
    
    public Jeu(int taille, JeuAtomX fenetre){
        this.fenetre = fenetre;
        setFini(false);
        setJoueur(this.fenetre.getJoueur());
        // setTab(LesCases.getTab(taille));
        setTab(new LesCases(taille).getTab(taille));
        }
    
    public Jeu(JeuAtomX fenetre){
        this.fenetre = fenetre;
        setFini(false);
        setJoueur(this.fenetre.getJoueur());
        setTab(LesCases.getTab(10));
        }
        
    public Jeu(byte parametre, JeuAtomX fenetre){
        this.fenetre = fenetre;
        setJoueur(this.fenetre.getJoueur());
        setFini(false);
        setTab(LesCases.getTab(parametre));
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
        Direction dir;
        Prison p; Particule part;
        if (getTab().getCases()[pos.getX()][pos.getY()].getClass()==Prison.class){
            p=(Prison)(getTab().getCases()[pos.getX()][pos.getY()]);
            if (p.isOccupee()){
                part=getJoueur().getParticule();//on intervertit les particules
                getJoueur().setParticule(getTab().getCases()[pos.getX()][pos.getY()].getContenu());
                getTab().getCases()[pos.getX()][pos.getY()].setContenu(part);
                getJoueur().getParticule().setActive(true);
                pos=getJoueur().getParticule().getPos();
                dir=getJoueur().getParticule().getDir();
                pos.setX(pos.getX()+dir.getX());
                pos.setY(pos.getY()+dir.getY());
                p.action();
                }
            else{
                getTab().getCases()[pos.getX()][pos.getY()].setContenu(getJoueur().getParticule());
                getTab().getCases()[pos.getX()][pos.getY()].action();
                }
            }
        else{
            getTab().getCases()[pos.getX()][pos.getY()].setContenu(getJoueur().getParticule());
            getTab().getCases()[pos.getX()][pos.getY()].action();
            }
    }
    public void hypo(){
        Position p=hypoPos();
        Scanner input=new Scanner(System.in);
        boolean continuer=true;
        Obstacle o = null;
        if(p!= null)
            o = (Obstacle)getTab().getCases()[p.getX()][p.getY()];
        int corr=0;//doit etre un int pour distinguer les trois cas : pas d'hypoNature(0), hypoNature correcte(2) et hypoNature fausse(1)
        String msg;
        if(p!=null && o!=null){
            this.fenetre.Historique.append("\nVotre hypothèse sur la position est correcte.");
            System.out.println("Voulez-vous faire une hypothèse sur la nature de l'obstacle ? (Cela vous rapportera le double de point en cas de bonne réponse ou vous perdrez tout si vous vous etes trompé)");
            do{
                msg=input.nextLine();
                switch(msg){
                    case "oui":
                    case "Oui":
                    case "y":
                    case "o": corr=hypoNature(o); continuer=false; break;
                    case "non":
                    case "Non":
                    case "n": continuer=false; break;
                    }
                }while(continuer);
            switch(corr){
                case 0: getJoueur().setSolde(getJoueur().getSolde()+o.getPoid());break;
                case 2: getJoueur().setSolde(getJoueur().getSolde()+2*o.getPoid());break;
            }
            getTab().getCases()[p.getX()][p.getY()]=new CNormale(p);
        }
        else{
            this.fenetre.Historique.append("\nVous vous êtes trompé.");
        }
    } 
    public Position hypoPos(){
        Scanner input=new Scanner(System.in);
        int x,y;
        Position p;
        boolean corr=false;
        ArrayList<Obstacle> obstacles=getTab().getObstacles();
        System.out.println("Hypothèse sur la position :");
        x=input.nextInt();y=input.nextInt();
        p=new Position(x, y);
        x=0;
        while(x<obstacles.size()&&!corr){
            corr=obstacles.get(x).getPos().equals(p);
            x++;
            }
        if (!corr) //si l'hypothèse est correcte, on renvoie la position sinon on renvoie null
            p=null;
        return p;
    }
    public int hypoNature(Obstacle ob){
        Scanner input=new Scanner(System.in);
        int corr=1;
        System.out.println("Hypothèse sur la nature :");
        String msg=input.nextLine();
        if(ob.getClass()==Deviateur.class)
            switch(msg){
                case "Déviateur":
                case "Deviateur":
                case "déviateur":
                case "deviateur":
                case "d": corr=2; break;
            }
        if (ob.getClass()==Teleporteur.class)
            switch(msg){
                case "Téléporteur":
                case "Téleporteur":
                case "Teléporteur":
                case "Teleporteur":
                case "téléporteur":
                case "téleporteur":
                case "teléporteur":
                case "teleporteur":
                case "t": corr=2; break;
            }
        if (ob.getClass()==Prison.class)
            switch(msg){
                case "Prison":
                case "prison":
                case "p": corr=2; break;
            }
        return corr;
    }
}
