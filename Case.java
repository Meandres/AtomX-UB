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
public abstract class Case {
    private Particule contenu;
    private Position pos;

    public void setPos(Position pos) {
        this.pos = pos;
    }
    public void setContenu(Particule p) {
        this.contenu = p;
    }
    public Position getPos() {
        return pos;
    }
    public Particule getContenu() {
        return this.contenu;
    }
    public abstract void action();
    public Case(Position p){
        setPos(p);
    }
    
}
