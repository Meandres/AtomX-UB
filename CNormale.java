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
public class CNormale extends Case {
    
    public CNormale(Position p){
        super(p);
    }

    @Override
    public String toString() {
        return "CNormale{"+this.getPos()+'}';
    }
    
    
}
