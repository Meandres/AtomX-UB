/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomx;

/**
 *
 * @author nous
 */
public class Deviateur extends Case {
    private int val;//nombre de quarts de tours qui seront appliqués à la particule

    public int getVal() {
        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }
    public Deviateur(Position pos){
        super(pos);
    }
    @Override
    public void action(){
        this.getContenu().getDir().tourne(this.getVal());
        super.action();
    }
    
}
