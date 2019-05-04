/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomx_1_0;

import java.util.ArrayList;

/**
 *
 * @author nous
 */
public class LesCases {
    private Case[][] cases;
    private static double probaObstacles=0.08;//entre 0 et 1
    private static final int[] scenarios1={4,3,6,6,5,2,2,6,3};

    public void addCase(Case c) {
        cases[c.getPos().getX()][c.getPos().getY()]=c;
    }
    public Case[][] getCases(){
        return cases;
    }
    public static double getProbaObstacles() {
        return probaObstacles;
    }
    public static void setProbaObstacles(double probaObstacles) {
        LesCases.probaObstacles = probaObstacles;
    }
    public LesCases(int taille){
        cases=new Case[taille][taille];
    }
    
    
    public static LesCases getTab(int taille){
        double rand;
        Case c;
        LesCases tab=new LesCases(taille);
        for(int i=0; i<taille; i++){
            for(int j=0; j<taille; j++){
                rand=Math.random();
                if (rand<LesCases.getProbaObstacles()){//la case sera un obstacle
                    c=Obstacle.CreaObstacles(i, j, taille);
                    tab.addCase(c);
                    }
                else{//la case sera une case normale
                   c=new CNormale(new Position(i, j));
                   tab.addCase(c);
                    }
                   
            }
        }
        return tab;
    }
    public static LesCases getTab(byte parametre){
        Case c;
        int poid=3;
        LesCases tab=new LesCases(10);
        switch(parametre){
            case 1:{
                for(int i=0; i<10; i++){
                    for(int j=0; j<10; j++){
                        c=tab.getCases()[i][j]=new CNormale(new Position(i, j));
                    }
                }
                tab.getCases()[scenarios1[0]][scenarios1[1]]=new Prison(new Position(scenarios1[0], scenarios1[1]), poid);
                tab.getCases()[scenarios1[2]][scenarios1[3]]=new Teleporteur(new Position(scenarios1[2], scenarios1[3]), poid, new Position(scenarios1[4],scenarios1[5]));
                tab.getCases()[scenarios1[6]][scenarios1[7]]=new Deviateur(new Position(scenarios1[6], scenarios1[7]), poid, scenarios1[8]);
                break;
            }
        }
        return tab;
    }
    public int getNbObstacles(){
        int nb=0;
        for (Case[] blblbl : getCases()) {
            for (Case caseAct : blblbl) {
                if(caseAct.getClass()==Teleporteur.class||caseAct.getClass()==Deviateur.class||caseAct.getClass()==Prison.class){
                    nb++;
                    }
                }
            }
        return nb;
    }
    public ArrayList<Obstacle> getObstacles(){
        ArrayList<Obstacle> obstacles=new ArrayList<>();
        for (Case[] blblbl : getCases()) {
            for (Case caseAct : blblbl) {
                if(caseAct.getClass()==Teleporteur.class||caseAct.getClass()==Deviateur.class||caseAct.getClass()==Prison.class){
                    Obstacle o=(Obstacle)(caseAct);
                    obstacles.add(o);
                    }
                }
            }
        return obstacles;
    }

    @Override
    public String toString() {
        String msg="LesCases{\n";
        for (Case[] blblbl : getCases()) {
            for (Case Cases : blblbl) {
                msg+=Cases+" ";
            }
            msg+="\n";
        }
        return msg;
    }
    
    
    
}
