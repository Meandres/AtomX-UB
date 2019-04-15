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
    private Joueur joueur;

    public void setFini(boolean fini) {
        this.fini = fini;
    }
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    public boolean isFini() {
        return fini;
    }
    public Joueur getJoueur() {
        return joueur;
    }
    
    public Jeu(String pseudo, int taille){//initialise le plateau de jeu et les instances necessaire au jeu
        setJoueur(new Joueur(pseudo));
        
        }
    public void creaCotes(int taille){
        taille=10;//pour le moment
        Ref.setRef(new Ref());
        int[] pos=new int[taille-1];
        pos[0]=2; pos[1]=7; pos[2]=1; pos[3]=3; pos[4]=6; pos[5]=8; pos[6]=0; pos[7]=4; pos[8]=9;
        Ref.getRef().setxNul(new CaseVide(new CaseNonVide(new Position(0, (int)Math.floor(taille/2)))));
        Ref.getRef().setxMax(new CaseVide(new CaseNonVide(new Position(taille-1, (int)Math.floor(taille/2)))));
        Ref.getRef().setyNul(new CaseVide(new CaseNonVide(new Position((int)Math.floor(taille/2), 0))));
        Ref.getRef().setyMax(new CaseVide(new CaseNonVide(new Position((int)Math.floor(taille/2), taille-1))));
        for(int i=0; i<taille; i++){
            CaseVide c=new CaseVide(new CaseNonVide(new Position(0, pos[i])));
            CaseVide act=Ref.getRef().getxNul();//pointe vers la premiere case qu'on a placé
            System.out.println(act.getfMoins());
                while(act.getfMoins()==null&&act.getfPlus()==null){/*on continue jusqu'a ce que la case actuelle soit une extremité*/
                    if(c.getLien().getPos().estPlusGrandeQue(act.getLien().getPos())){
                        act=act.getfPlus();
                        }
                    else
                        act=act.getfMoins();
                    }
            c=new CaseVide(new CaseNonVide(new Position(taille-1, pos[i])));
            act=Ref.getRef().getxNul();//pointe vers la premiere case qu'on a placé
                while(act.getfMoins()==null&&act.getfPlus()==null){/*on continue jusqu'a ce que la case actuelle soit une extremité*/
                    if(c.getLien().getPos().estPlusGrandeQue(act.getLien().getPos())){
                        act=act.getfPlus();
                        }
                    else
                        act=act.getfMoins();
                    }
            c=new CaseVide(new CaseNonVide(new Position(0, pos[i])));
            act=Ref.getRef().getxNul();//pointe vers la premiere case qu'on a placé
                while(act.getfMoins()==null&&act.getfPlus()==null){/*on continue jusqu'a ce que la case actuelle soit une extremité*/
                    if(c.getLien().getPos().estPlusGrandeQue(act.getLien().getPos())){
                        act=act.getfPlus();
                        }
                    else
                        act=act.getfMoins();
                    }
            c=new CaseVide(new CaseNonVide(new Position(0, pos[i])));
            act=Ref.getRef().getxNul();//pointe vers la premiere case qu'on a placé
                while(act.getfMoins()==null&&act.getfPlus()==null){/*on continue jusqu'a ce que la case actuelle soit une extremité*/
                    if(c.getLien().getPos().estPlusGrandeQue(act.getLien().getPos())){
                        act=act.getfPlus();
                        }
                    else
                        act=act.getfMoins();
                    }       
            }

        }
        
}
