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
public class Teleporteur extends Obstacle {
    private Position arrivee;
    private final int poid;

    public Position getArrivee() {
        return arrivee;
    }
    public void setArrivee(Position p){
        this.arrivee=p;
    }
    public int getPoid() {
        return poid;
    }
    
    @Override
    public void action(){
        this.getContenu().setPos(getArrivee());
        this.getContenu().nvPoid(this.getPoid());
    }
    public Teleporteur(Position p, int taille){
        super(p);
        this.poid=(int)(Math.random()*Obstacle.PoidMaxObstacles)+1;
        this.arrivee=new Position((int)(Math.random()*taille), (int)(Math.random()*taille));
    }
    public Teleporteur(Position p, int poid, Position arrivee){
        super(p);
        this.poid=poid;
        setArrivee(arrivee);
    }

    @Override
    public String toString() {
        return "Teleporteur{"+this.getPos() + " arrivee=" + arrivee + ", poid=" + poid + '}';
    }
    
}
