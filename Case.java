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
public abstract class Case {
    private Particule contenu;
    
    public void setContenu(Particule p) {
        this.contenu = p;
    }
    public Particule getContenu() {
        return this.contenu;
    }
    public abstract void action();
    
    
}
