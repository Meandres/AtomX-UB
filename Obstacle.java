/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomx1_1;

/**
 *
 * @author nous
 */
public abstract class Obstacle extends Case {
    private int poid;
    private static final String[] obstacles = {"Deviateur", "Teleporteur", "Prison"};
    public static final int PoidMaxObstacles=4;

    public int getPoid() {
        return poid;
    }
    public void setPoid(int poid) {
        this.poid = poid;
    }
    
    
    public Obstacle(Position p){
        super(p);
    }
    @Override
    public void action(){
        Position pos=getContenu().getPos();
        Direction dir=getContenu().getDir();
        pos.setX(pos.getX()+dir.getX());
        pos.setY(pos.getY()+dir.getY());
    }
    
    public static Obstacle CreaObstacles(int i, int j, int taille){
        int rand;
        rand = (int)(Math.random() * obstacles.length);
        Obstacle o=null;
        switch (rand){
            case 0:{
                o=new Deviateur(new Position(i, j)); break;
            }
            case 1:{
                o=new Teleporteur(new Position(i, j), taille); break;
            }
            case 2:{
                o=new Prison(new Position(i, j)); break;
            }
            default:{
                System.out.println("Quelque chose, quelque part, a très mal tourné !");
                System.exit(0);
            }
        }
        return o;
    }
    
}
