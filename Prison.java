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
public class Prison extends Obstacle {
    private boolean occupee;
    private final int poid;

    public boolean isOccupee() {
        return occupee;
    }
    public void setOccupee(boolean occupee) {
        this.occupee = occupee;
    }
    public int getPoid() {
        return poid;
    }
    
    @Override
    public void action(){
        this.getContenu().setActive(false);
        this.getContenu().nvPoid(this.getPoid());
    }
    public Prison(Position p){
        super(p);
        setOccupee(false);
        this.poid=(int)(Math.random()*Obstacle.PoidMaxObstacles)+1;
    }

    @Override
    public String toString() {
        return "Prison{"+this.getPos()+ " occupee=" + occupee + ", poid=" + poid + '}';
    }
    
    
}
