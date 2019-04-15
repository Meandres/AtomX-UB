/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsimple;

/**
 *
 * @author nous
 */
public class LesCases {
    private Case[][] cases;
    private static double probaObstacles=0.08;//entre 0 et 1

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
    public int getNbObstacles(){
        int nb=0;
        for (Case[] blblbl : getCases()) {
            for (Case caseAct : blblbl) {
                System.out.println(caseAct.getClass());
                if(caseAct.getClass()==Teleporteur.class||caseAct.getClass()==Deviateur.class||caseAct.getClass()==Prison.class){
                    nb++;
                    }
                }
            }
        return nb;
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
