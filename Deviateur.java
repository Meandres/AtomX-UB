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
public class Deviateur extends Obstacle {
    private final int poid;
    private final int tours;//en quart de tour
    
    public int getPoid() {
        return poid;
    }
    public int getTours() {
        return tours;
    }
    
    @Override
    public void action(){
        this.getContenu().tourne(tours);
        this.getContenu().nvPoid(this.getPoid());
    }
    
    public Deviateur(Position p){
        super(p);
        this.poid=(int)(Math.random()*Obstacle.PoidMaxObstacles)+1;
        this.tours=(int)(Math.random()*4);
    }
    public Deviateur(Position p, int poid, int tours){
        super(p);
        this.poid=poid;
        this.tours=tours;
    }

    @Override
    public String toString() {
        return "Deviateur{"+this.getPos()+ " poid=" + poid + ", tours=" + tours + '}';
    }
    
}
