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
public class Deviateur extends Obstacle {
    private final int tours;//en quart de tour
   
    public int getTours() {
        return tours;
    }
    
    @Override
    public void action(){
        this.getContenu().tourne(tours);
        this.getContenu().nvPoid(this.getPoid());
        super.action();
    }
    
    public Deviateur(Position p){
        super(p);
        setPoid((int)(Math.random()*Obstacle.PoidMaxObstacles)+1);
        this.tours=(int)(Math.random()*4);
    }
    public Deviateur(Position p, int poid, int tours){
        super(p);
        setPoid(poid);
        this.tours=tours;
    }

    @Override
    public String toString() {
        return "Deviateur{"+this.getPos()+ " poid=" + getPoid() + ", tours=" + tours + '}';
    }
    
}
