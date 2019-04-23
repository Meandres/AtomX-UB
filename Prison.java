/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomx_1_0;

/**
 *
 * @author nous
 */
public class Prison extends Obstacle {
    private boolean occupee;

    public boolean isOccupee() {
        return occupee;
    }
    public void setOccupee(boolean occupee) {
        this.occupee = occupee;
    }
    
    @Override
    public void action(){
        this.getContenu().setActive(false);
        this.getContenu().nvPoid(this.getPoid());
        this.setOccupee(true);
    }
    public Prison(Position p){
        super(p);
        setOccupee(false);
        setPoid((int)(Math.random()*Obstacle.PoidMaxObstacles)+1);
    }
    public Prison(Position p, int poid){
        super(p);
        setOccupee(false);
        setPoid(poid);
    }

    @Override
    public String toString() {
        return "Prison{"+this.getPos()+ " occupee=" + occupee + ", poid=" + getPoid() + '}';
    }
    
    
}
