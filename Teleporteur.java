/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomx_1_1;

/**
 *
 * @author nous
 */
public class Teleporteur extends Obstacle {
    private Position arrivee;

    public Position getArrivee() {
        return arrivee;
    }
    public void setArrivee(Position p){
        this.arrivee=p;
    }
    @Override
    public void action(){
        this.getContenu().setPos(getArrivee());
        this.getContenu().nvPoid(this.getPoid());
        super.action();
    }
    public Teleporteur(Position p, int taille){
        super(p);
        setPoid((int)(Math.random()*Obstacle.PoidMaxObstacles)+1);
        this.arrivee=new Position((int)(Math.random()*taille), (int)(Math.random()*taille));
    }
    public Teleporteur(Position p, int poid, Position arrivee){
        super(p);
        setPoid(poid);
        setArrivee(arrivee);
    }

    @Override
    public String toString() {
        return "Teleporteur{"+this.getPos() + " arrivee=" + arrivee + ", poid=" + getPoid() + '}';
    }
    
}
