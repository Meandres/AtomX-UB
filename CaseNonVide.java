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
public class CaseNonVide extends Case {
    private Position pos;
    private Case vH;
    private Case vG;
    private Case vD;
    private Case vB;
    
    public void setPos(Position pos) {
        this.pos = pos;
    }
    public void setvH(Case vH) {
        this.vH = vH;
    }
    public void setvG(Case vG) {
        this.vG = vG;
    }
    public void setvD(Case vD) {
        this.vD = vD;
    }
    public void setvB(Case vB) {
        this.vB = vB;
    }
    public Position getPos() {
        return pos;
    }
    public Case getvH() {
        return vH;
    }
    public Case getvG() {
        return vG;
    }
    public Case getvD() {
        return vD;
    }
    public Case getvB() {
        return vB;
    }
    public CaseNonVide(Position pos){
        setPos(pos);
    }

    @Override
    public String toString() {
        return "CaseNonVide{" + "pos=" + pos + '}';
    }
    public void action(){
        if (getContenu().isActive()){
            if(getContenu().getDir().getX()!=0){
                if (getContenu().getDir().getX()==1){
                    getvD().setContenu(this.getContenu());
                    this.setContenu(null);
                    }
                else{
                    getvG().setContenu(this.getContenu());
                    this.setContenu(null);
                    }
                }
            else{//si la direction de la particule en Y est différente de 0
                    if(getContenu().getDir().getY()==1){
                        getvH().setContenu(this.getContenu());
                        this.setContenu(null);
                        }
                    else{
                        getvB().setContenu(this.getContenu());
                        this.setContenu(null);
                        }
                    }       
            }
    }
    
}
