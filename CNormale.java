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
public class CNormale extends Case {
    
    public CNormale(Position p){
        super(p);
    }
    @Override
    public void action(){
        Position pos=getContenu().getPos();
        Direction dir=getContenu().getDir();
        pos.setX(pos.getX()+dir.getX());
        pos.setY(pos.getY()+dir.getY());
        }

    @Override
    public String toString() {
        return "CNormale{"+this.getPos()+'}';
    }
    
    
}
