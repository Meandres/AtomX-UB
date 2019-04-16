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
public class Particule {
    private Position pos;
    private Direction dir;
    private boolean active;

    public void setPos(Position pos) {
        this.pos = pos;
    }
    public void setDir(Direction dir) {
        this.dir = dir;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    
    public Position getPos() {
        return pos;
    }
    public Direction getDir() {
        return dir;
    }
    public boolean isActive() {
        return active;
    }

    public Particule(Position pos, Direction dir) {
        setPos(pos);
        setDir(dir);
        
        setActive(true);
    }
    
    
}
