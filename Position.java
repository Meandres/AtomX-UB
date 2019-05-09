/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomx1_1;

/**
 *
 * @author nous
 */
public class Position {
    private int x;
    private int y;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public Position(int x, int y) {
        setX(x);
        setY(y);
    }
    public Position(Position p){
        setX(p.getX());
        setY(p.getY());
    }
    @Override
    public String toString() {
        return "P x: " + x + ", y: " + y;
    }
    
    public void modif(Direction d){
        setX(x+d.getX());
        setY(y+d.getY());
    }
    public boolean equals(Position a){
        return this.getX()==a.getX()&&this.getY()==a.getY();
    }
    public boolean estPlusGrandeQue(Position a){
        boolean b=false;
        if(this.getX()==a.getX()){
            if(this.getY()!=a.getY()){
                b=this.getY()>a.getY();
                }
            }
        if(this.getY()==a.getY()){
            if(this.getX()!=a.getX()){
                b=this.getX()>a.getX();
            }
        }
    return b;        
    }
    public boolean isValide(int taille){//teste si une position de départ est valide
        return ( (getX()==0 || getX()==(taille-1)) && getY()<taille && getY()>=0 || (getY()==0 || getY()==(taille-1)) && getX()<taille && getX()>=0 );
    }
}
