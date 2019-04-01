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
public class Case {
    private Position pos;
    private Case vH;
    private Case vG;
    private Case vD;
    private Case vB;
    private Particule contenu;
    
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
    public void setContenu(Particule p) {
        this.contenu = p;
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
    public Particule getContenu() {
        return this.contenu;
    }

    public Case(Position pos) {
        this.pos = pos;
    }
    
    public void action(){
        if(getContenu().getDirection()[0]!=0){
            if (getContenu().getDirection()[0]==1){
                getvD().setContenu(this.getContenu());
                this.setContenu(null);
                }
            else{
                getvG().setContenu(this.getContenu());
                this.setContenu(null);
                }
            }
        else{//si la direction de la particule en Y est différente de 0
                if(getContenu().getDirection()[1]==1){
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
